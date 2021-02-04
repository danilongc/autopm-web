package br.com.dnc.pmcheatweb.dto.app;

import br.com.dnc.pmcheatweb.service.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserStatusRestResponse {

    private String user;
    private Boolean lastRequestSuccess;
    private Boolean forceNextFreeDay;
    private String ibgeCityCode;


    public UserStatusRestResponse(String user, Boolean lastRequestSuccess, Boolean forceNextFreeDay,  String ibgeCityCode) {

        this.user = user;
        this.lastRequestSuccess = lastRequestSuccess;
        this.forceNextFreeDay = forceNextFreeDay;
        this.ibgeCityCode = ibgeCityCode;
    }

    public UserStatusRestResponse(UserInfo userInfo) {

        this.user = userInfo.getUser();
        this.lastRequestSuccess = userInfo.getLastRequestSuccess();
        this.forceNextFreeDay = userInfo.getPunchInNextFreeDay();
        this.ibgeCityCode =  userInfo.getIbgeCityCode();
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


    public Boolean getForceNextFreeDay() {
        return forceNextFreeDay;
    }

    public void setForceNextFreeDay(Boolean forceNextFreeDay) {
        this.forceNextFreeDay = forceNextFreeDay;
    }

    public String getIbgeCityCode() {
        return ibgeCityCode;
    }

    public void setIbgeCityCode(String ibgeCityCode) {
        this.ibgeCityCode = ibgeCityCode;
    }
}
