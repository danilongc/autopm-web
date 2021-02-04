package br.com.dnc.pmcheatweb.service;


import java.util.Objects;

public class UserInfo {

    private String user;
    private String token;
    private String uid;
    private String uuid;
    private String client;
    private String expiry;
    private Boolean lastRequestSuccess;

    private Boolean punchInNextFreeDay = false;
    private String ibgeCityCode;


    public UserInfo(String user){
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getLastRequestSuccess() {
        return lastRequestSuccess;
    }

    public void setLastRequestSuccess(Boolean lastRequestSuccess) {
        this.lastRequestSuccess = lastRequestSuccess;
    }

    public Boolean getPunchInNextFreeDay() {
        return punchInNextFreeDay;
    }

    public void setPunchInNextFreeDay(Boolean punchInNextFreeDay) {
        this.punchInNextFreeDay = punchInNextFreeDay;
    }


    public String getIbgeCityCode() {
        return ibgeCityCode;
    }

    public void setIbgeCityCode(String ibgeCityCode) {
        this.ibgeCityCode = ibgeCityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo that = (UserInfo) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user);
    }
}
