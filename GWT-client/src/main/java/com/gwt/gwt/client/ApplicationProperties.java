package com.gwt.gwt.client;

public enum ApplicationProperties {

    BASEURL("localhost:8080/api"),
    APISAVEDATA("/savedata/");

    private String param;

    ApplicationProperties(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
