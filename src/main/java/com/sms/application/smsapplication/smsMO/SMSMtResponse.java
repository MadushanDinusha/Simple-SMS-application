package com.sms.application.smsapplication.smsMO;

public class SMSMtResponse {

    private String statusCode;
    private String description;

    public SMSMtResponse(String statusCode, String description){
        this.statusCode = statusCode;
        this.description = description;
    }
}
