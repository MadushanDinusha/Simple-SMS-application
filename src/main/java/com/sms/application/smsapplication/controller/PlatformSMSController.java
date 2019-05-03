package com.sms.application.smsapplication.controller;

import com.sms.application.smsapplication.service.PlatformSMSHandler;
import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class PlatformSMSController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformSMSController.class);

    @Autowired
    PlatformSMSHandler platformSMSHandler;

    @RequestMapping(path = "/receive",method = RequestMethod.POST)
    public SMSMoResponse receiveSMS(@RequestBody SMSMoRequest smsMoRequest){
        LOGGER.info("SMS received");
        return platformSMSHandler.handleReceivedSMS(smsMoRequest);
    }
}
