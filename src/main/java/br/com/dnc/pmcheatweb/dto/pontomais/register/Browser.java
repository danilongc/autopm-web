package br.com.dnc.pmcheatweb.dto.pontomais.register;

import br.com.dnc.pmcheatweb.dto.pontomais.BaseDomain;

public class Browser extends BaseDomain{

    public String name;
    public String version;
    public String versionSearchString;

    public Browser(){}

    public Browser(String name, String version, String versionSearchString) {
        this.name = name;
        this.version = version;
        this.versionSearchString = versionSearchString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionSearchString() {
        return versionSearchString;
    }

    public void setVersionSearchString(String versionSearchString) {
        this.versionSearchString = versionSearchString;
    }
}