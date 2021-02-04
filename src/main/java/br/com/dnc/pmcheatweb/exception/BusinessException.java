package br.com.dnc.pmcheatweb.exception;

public class BusinessException extends RuntimeException {

    private String message;
    private String details;

    public BusinessException(String message){
        super();
        this.message = message;
    }

    public BusinessException(){
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException withMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public BusinessException withDetail(String detail) {
        this.details = detail;
        return this;
    }

}
