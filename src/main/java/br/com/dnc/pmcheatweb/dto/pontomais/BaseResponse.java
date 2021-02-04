package br.com.dnc.pmcheatweb.dto.pontomais;

public class BaseResponse extends BaseDomain {

    //    {"error":"Faça login para continuar.","redirect_to_login":true,"meta":{"now":1583245386,"ip":"191.54.235.207"}}

    private String erro;
    private String error;
    private String success;

    public BaseResponse(){}

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
