package com.burnie.remoteapi.common;

public enum API {

    ID_CARD("idCardAuthService"),
    FACE("faceAuthService");

    private final String serviceName;

    API(String serviceName){
        this.serviceName = serviceName;
    }

    public String getServiceName(){
        return this.serviceName;
    }
}
