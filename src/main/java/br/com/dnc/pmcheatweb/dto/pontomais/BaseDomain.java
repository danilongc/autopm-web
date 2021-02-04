package br.com.dnc.pmcheatweb.dto.pontomais;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class BaseDomain implements Serializable{

    private static final long serialVersionUID = -5314688602727695363L;

    protected Gson gson = new Gson();

    @Override
    public String toString() {

        try {
            return gson.toJson(this);
        } catch (Exception e) {
            e.printStackTrace();
            return super.toString();
        }
    }


}
