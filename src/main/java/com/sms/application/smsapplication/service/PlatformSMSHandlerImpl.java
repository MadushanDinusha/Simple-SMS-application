package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.dao.MessageDao;
import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformSMSHandlerImpl implements PlatformSMSHandler{

    private MessageDao messageDao;
    private SMSMoReceiver smsMoReceiver;

    @Autowired
    public PlatformSMSHandlerImpl(MessageDao messageDao, SMSMoReceiver smsMoReceiver){
        this.messageDao = messageDao;
        this.smsMoReceiver= smsMoReceiver;
    }
    @Override
    public SMSMoResponse handleReceivedSMS(SMSMoRequest smsMoRequest) {
        String message = smsMoRequest.getMessage();
        messageDao.createMessageRequest(message);

        return smsMoReceiver.processReceivedMsg(smsMoRequest);
    }
}
