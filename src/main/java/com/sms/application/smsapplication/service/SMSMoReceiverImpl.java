package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;
import org.springframework.stereotype.Service;

@Service
public class SMSMoReceiverImpl implements SMSMoReceiver {
    @Override
    public SMSMoResponse processReceivedMsg(SMSMoRequest smsMoRequest) {
        return new SMSMoResponse("S1000","Success");
    }
}
