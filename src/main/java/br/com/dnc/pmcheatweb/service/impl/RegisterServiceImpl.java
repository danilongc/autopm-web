package br.com.dnc.pmcheatweb.service.impl;

import br.com.dnc.pmcheatweb.dto.pontomais.register.RegisterRequest;
import br.com.dnc.pmcheatweb.service.CalendarService;
import br.com.dnc.pmcheatweb.service.HeaderHelper;
import br.com.dnc.pmcheatweb.service.RegisterService;
import br.com.dnc.pmcheatweb.service.UserInfo;
import br.com.dnc.pmcheatweb.service.UsersSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    private static final String REGISTER_URL = "https://api.pontomais.com.br/api/time_cards/register";

    private final UsersSession usersSession;

    private final CalendarService calendarService;

    @Autowired
    public RegisterServiceImpl(UsersSession usersSession,
        CalendarService calendarService) {

        this.usersSession = usersSession;
        this.calendarService = calendarService;
    }

    @Override
    public void register(){
        this.register(false);
    }

    @Override
    public void register(boolean resetFreeDay){

        Set<UserInfo> allUsers = usersSession.getAll();

        log.info("Iniciando registro de ponto para {} usuário(s)", allUsers.size());

        allUsers.forEach(user -> {

            try {

                Boolean freeDay = calendarService.isFreeDay(user.getIbgeCityCode());

                if( freeDay && !user.getPunchInNextFreeDay()){
                    log.info("Ponto não registrado para para o usuário [{}] - FERIADO OU FINAL DE SEMANA", user.getUser());
                    return;
                }

                Map headers = new HashMap();

                HeaderHelper.buildHeaders(headers, user);

                RegisterRequest request = RegisterRequest.defaultRequest();

                Unirest
                    .post(REGISTER_URL)
                    .headers(headers)
                    .body(request.toString())
                    .asString();

                user.setLastRequestSuccess(true);

                if(resetFreeDay){
                    user.setPunchInNextFreeDay(false);
                }

                log.info("{}Registro de ponto realizado para {}", freeDay ? "DIA LIVRE - " : "", user.getUser());

            }catch (Exception e){
                user.setLastRequestSuccess(false);
                log.error("Erro ao registrar ponto para o usuário {} - ", user.getUser(), e);
            }finally {
                usersSession.update(user);
            }
        });

    }


}
