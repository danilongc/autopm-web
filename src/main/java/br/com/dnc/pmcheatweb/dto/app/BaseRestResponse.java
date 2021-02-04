package br.com.dnc.pmcheatweb.dto.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRestResponse {

    private String message;
    private String details;

    public BaseRestResponse() {
    }

    public BaseRestResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public BaseRestResponse withMessage(String message) {
        this.message = message;
        return this;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    public BaseRestResponse withDetails(String details) {
        this.details = details;
        return this;
    }

}
