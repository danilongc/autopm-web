package br.com.dnc.pmcheatweb.service;


import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UsersSession {

    private LinkedHashSet<UserInfo> userCredentialsList = new LinkedHashSet<>();

    public UsersSession(){

    }

    public void set(UserInfo userCredentials){
        this.userCredentialsList.add(userCredentials);
    }

    public void remove(UserInfo userCredentials){
        this.userCredentialsList.remove(userCredentials);
    }

    public void update(UserInfo userCredentials){
       this.userCredentialsList.add(userCredentials);
    }

    public Set<UserInfo> getAll(){
        return Collections.unmodifiableSet(this.userCredentialsList);
    }

}
