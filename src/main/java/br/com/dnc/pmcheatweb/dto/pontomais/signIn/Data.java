package br.com.dnc.pmcheatweb.dto.pontomais.signIn;

import br.com.dnc.pmcheatweb.dto.pontomais.BaseDomain;
import java.util.Objects;

public class Data extends BaseDomain {

    public String email;
    public int sign_in_count;
    public String last_sign_in_ip;
    public int last_sign_in_at;

    public Data(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSign_in_count() {
        return sign_in_count;
    }

    public void setSign_in_count(int sign_in_count) {
        this.sign_in_count = sign_in_count;
    }

    public String getLast_sign_in_ip() {
        return last_sign_in_ip;
    }

    public void setLast_sign_in_ip(String last_sign_in_ip) {
        this.last_sign_in_ip = last_sign_in_ip;
    }

    public int getLast_sign_in_at() {
        return last_sign_in_at;
    }

    public void setLast_sign_in_at(int last_sign_in_at) {
        this.last_sign_in_at = last_sign_in_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return sign_in_count == data.sign_in_count &&
            last_sign_in_at == data.last_sign_in_at &&
            Objects.equals(email, data.email) &&
            Objects.equals(last_sign_in_ip, data.last_sign_in_ip);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, sign_in_count, last_sign_in_ip, last_sign_in_at);
    }
}
