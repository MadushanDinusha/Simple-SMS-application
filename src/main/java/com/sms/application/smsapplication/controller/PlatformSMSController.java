package com.sms.application.smsapplication.controller;

import com.sms.application.smsapplication.service.PlatformSMSHandler;
import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class PlatformSMSController {

    @Autowired
    PlatformSMSHandler platformSMSHandler;

    @RequestMapping(path = "/receive",method = RequestMethod.POST)
    public SMSMoResponse receiveSMS(@RequestBody SMSMoRequest smsMoRequest){
        return platformSMSHandler.handleReceivedSMS(smsMoRequest);
    }
}
