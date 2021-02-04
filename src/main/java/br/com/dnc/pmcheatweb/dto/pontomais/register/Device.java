package br.com.dnc.pmcheatweb.dto.pontomais.register;

import br.com.dnc.pmcheatweb.dto.pontomais.BaseDomain;

public class Device extends BaseDomain{

    public String manufacturer;
    public String model;
    public String uuid;
    public String version;
    public Browser browser;

    public Device(){}

    public Device(Browser browser){
        this.browser = browser;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
}