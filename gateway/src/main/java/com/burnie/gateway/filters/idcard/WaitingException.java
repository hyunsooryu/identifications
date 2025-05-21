package com.burnie.gateway.filters.idcard;

public class WaitingException extends RuntimeException{
    WaitingException(String message){
        super(message);
    }
}
