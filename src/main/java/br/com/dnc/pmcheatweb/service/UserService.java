package br.com.dnc.pmcheatweb.service;

import br.com.dnc.pmcheatweb.dto.app.UserDto;
import java.util.Set;

public interface UserService {

    void addUser(UserDto userDto);

    void removeUser(String user);

    UserInfo getUserInfo(String user);

    Set<UserInfo> getAllUserInfo();


}
