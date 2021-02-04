package br.com.dnc.pmcheatweb.dto.app;

import java.util.Objects;

public class UserDto {

    private String user;
    private String pass;
    private Boolean forceNextFreeDay = false;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getForceNextFreeDay() {
        return forceNextFreeDay;
    }

    public void setForceNextFreeDay(Boolean forceNextFreeDay) {
        this.forceNextFreeDay = forceNextFreeDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(user, userDto.user) &&
            Objects.equals(pass, userDto.pass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, pass);
    }

}
