package br.com.dnc.pmcheatweb.dto.pontomais.signIn;

import br.com.dnc.pmcheatweb.dto.pontomais.BaseResponse;
import com.google.gson.Gson;
import java.util.Objects;

public class SignInResponse extends BaseResponse {

    public String token;
    public String client_id;
    public Data data;

    public SignInResponse() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SignInResponse that = (SignInResponse) o;
        return Objects.equals(token, that.token) &&
            Objects.equals(client_id, that.client_id) &&
            Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(token, client_id, data);
    }

    public static SignInResponse fromJson(String body) {
        return new Gson().fromJson(body, SignInResponse.class);
    }
}