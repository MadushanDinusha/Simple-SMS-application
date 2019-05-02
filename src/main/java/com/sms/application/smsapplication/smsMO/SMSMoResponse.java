package com.sms.application.smsapplication.smsMO;

public class SMSMoResponse {

    private String statusCode;
    private String description;

    public SMSMoResponse(String statusCode, String description){
        this.statusCode = statusCode;
        this.description = description;
    }
}
