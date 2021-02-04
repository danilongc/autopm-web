package br.com.dnc.pmcheatweb.controller;


import br.com.dnc.pmcheatweb.dto.app.BaseRestResponse;
import br.com.dnc.pmcheatweb.dto.app.UserDto;
import br.com.dnc.pmcheatweb.dto.app.UserStatusRestResponse;
import br.com.dnc.pmcheatweb.service.UserInfo;
import br.com.dnc.pmcheatweb.service.UserService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseRestResponse addUpdateUser(@RequestBody UserDto user){

        userService.addUser(user);

        return new BaseRestResponse()
            .withMessage("Usuário incluido para apontamento automático com sucesso.");
    }

    @DeleteMapping( path = "/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseRestResponse deleteUser(@PathVariable String user){

        userService.removeUser(user);

        return new BaseRestResponse()
            .withMessage("Usuário removido para apontamento automático com sucesso.");
    }

    @GetMapping( path = "/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatusRestResponse isPunchingClock(@PathVariable String user){

        UserInfo userInfo = userService.getUserInfo(user);
        return new UserStatusRestResponse(userInfo.getUser(), userInfo.getLastRequestSuccess(), userInfo.getPunchInNextFreeDay(), userInfo.getIbgeCityCode());

    }

    @GetMapping( path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserStatusRestResponse> getAllUsers(){

        return userService.getAllUserInfo()
            .stream()
            .map(UserStatusRestResponse::new)
            .collect(Collectors.toList());

    }

}
