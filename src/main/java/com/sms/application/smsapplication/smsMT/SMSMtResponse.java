package com.sms.application.smsapplication.smsMT;

public class SMSMtResponse {

    private String statusCode;
    private String description;

    public SMSMtResponse(String statusCode, String description){
        this.description = description;
        this.statusCode = statusCode;
    }
}
