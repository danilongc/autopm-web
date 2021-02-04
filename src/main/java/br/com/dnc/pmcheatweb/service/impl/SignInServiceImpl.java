package br.com.dnc.pmcheatweb.service.impl;

import br.com.dnc.pmcheatweb.dto.pontomais.signIn.SigInRequest;
import br.com.dnc.pmcheatweb.dto.pontomais.signIn.SignInResponse;
import br.com.dnc.pmcheatweb.exception.BusinessException;
import br.com.dnc.pmcheatweb.service.LoginService;
import br.com.dnc.pmcheatweb.service.UserInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SignInServiceImpl implements LoginService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

//    private static final String SIGN_IN_URL = "http://localhost:8080/api/auth/sign_in";
    private static final String SIGN_IN_URL = "https://api.pontomais.com.br/api/auth/sign_in";

    @Override
    public UserInfo generateToken(String user, String pass) {

        log.info("Gerando Token para usuário [{}]", user);

        try {

            String uuid = UUID.randomUUID().toString();

            SigInRequest request = new SigInRequest(user, pass);

            Map headers = new HashMap<>();
            headers.put("uuid", uuid);
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
            headers.put("Content-Type", "application/json");

            HttpResponse<String> responseObjt = Unirest
                .post(SIGN_IN_URL)
                .headers(headers)
                .body(request.toString())
                .asString();


            SignInResponse response = SignInResponse.fromJson(responseObjt.getBody());

            if(!StringUtils.isEmpty(response.getError())){
                throw new BusinessException()
                    .withMessage("Falha ao realizar login.")
                    .withDetail(response.getError());
            }

            String token = response.getToken();
            String client = response.getClient_id();
            String expiry =  responseObjt.getHeaders().get("expiry").get(0);


            UserInfo userCredentials = new UserInfo(user);
            userCredentials.setToken(token);
            userCredentials.setUid(user);
            userCredentials.setUuid(uuid);
            userCredentials.setClient(client);
            userCredentials.setExpiry(expiry);

            log.info("Token gerado para usuário [{}] com sucesso", user);

            return userCredentials;

        } catch (UnirestException e) {
            System.out.println("Erro realizar requisição de Login: " + e.getMessage());
            log.error("Erro na solicitação de signIn ", e);

            throw new BusinessException("Falha ao realizar login.");
        }

    }

}
