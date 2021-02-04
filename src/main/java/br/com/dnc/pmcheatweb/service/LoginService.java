package br.com.dnc.pmcheatweb.service;

public interface LoginService {

    UserInfo generateToken(String user, String pass);

}
