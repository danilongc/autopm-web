package br.com.dnc.pmcheatweb.dto.pontomais.register;

import br.com.dnc.pmcheatweb.dto.pontomais.BaseDomain;

public class RegisterRequest extends BaseDomain {

    public TimeCard time_card;
    public String _path;
    public Device _device;
    public String _appVersion;

    public RegisterRequest(){}

    public TimeCard getTime_card() {
        return time_card;
    }

    public void setTime_card(TimeCard time_card) {
        this.time_card = time_card;
    }

    public String get_path() {
        return _path;
    }

    public void set_path(String _path) {
        this._path = _path;
    }

    public Device get_device() {
        return _device;
    }

    public void set_device(Device _device) {
        this._device = _device;
    }

    public String get_appVersion() {
        return _appVersion;
    }

    public void set_appVersion(String _appVersion) {
        this._appVersion = _appVersion;
    }


    public static RegisterRequest defaultRequest(){

        RegisterRequest request = new RegisterRequest();

        request.setTime_card(new TimeCard(-18.90860339D, 48.26135041D,
            "Av. João Naves de Ávila, 1331 - Tibery, Uberlândia - MG, 38408-902, Brasil", null,
            false));

        request.set_path("/meu_ponto/registro_de_ponto");
        request.set_device(new Device(new Browser("Chrome", "80.0.3987.122", "Chrome" )));
        request.set_appVersion("0.10.32");

        return request;
    }
}