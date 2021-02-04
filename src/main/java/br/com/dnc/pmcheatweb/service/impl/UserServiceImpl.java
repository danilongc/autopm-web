package br.com.dnc.pmcheatweb.service.impl;

import br.com.dnc.pmcheatweb.dto.app.UserDto;
import br.com.dnc.pmcheatweb.exception.BusinessException;
import br.com.dnc.pmcheatweb.service.LoginService;
import br.com.dnc.pmcheatweb.service.UserInfo;
import br.com.dnc.pmcheatweb.service.UserService;
import br.com.dnc.pmcheatweb.service.UsersSession;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Value("${ibgecode.uberlandia}")
    private String ibgeCode;


    private final LoginService loginService;
    private final UsersSession usersSession;


    @Autowired
    public UserServiceImpl(LoginService loginService,
        UsersSession usersSession){

        this.loginService = loginService;
        this.usersSession = usersSession;
    }

    @Override
    public void addUser(UserDto userDto) {

        UserInfo userInfo = loginService.generateToken(userDto.getUser(), userDto.getPass());
        userInfo.setUser(userDto.getUser());

        if(userDto.getForceNextFreeDay()){
            userInfo.setPunchInNextFreeDay(true);
            userInfo.setIbgeCityCode(ibgeCode);
        }

        usersSession.set(userInfo);
    }

    @Override
    public void removeUser(String user) {
        usersSession.remove(new UserInfo(user));
    }

    @Override
    public UserInfo getUserInfo(String user) {

        Optional<UserInfo> opt = usersSession.getAll().stream()
            .filter(p -> p.getUser().equals(user)).findFirst();

        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new BusinessException("Usuário não encontrado");
        }
    }

    @Override
    public Set<UserInfo> getAllUserInfo() {
        return usersSession.getAll();
    }
}
