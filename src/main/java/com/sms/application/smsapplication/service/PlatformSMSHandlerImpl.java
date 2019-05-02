package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.dao.MessageDao;
import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;
import com.sms.application.smsapplication.smsMT.SMSMtRequest;
import com.sms.application.smsapplication.user.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class PlatformSMSHandlerImpl implements PlatformSMSHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformSMSHandlerImpl.class);
    private MessageDao messageDao;
    private SMSMoReceiver smsMoReceiver;
    private SMSMtHandler smsMtHandler;

    @Autowired
    public PlatformSMSHandlerImpl(MessageDao messageDao, SMSMoReceiver smsMoReceiver, SMSMtHandler smsMtHandler){
        this.messageDao = messageDao;
        this.smsMtHandler = smsMtHandler;
        this.smsMoReceiver= smsMoReceiver;
    }
    @Override
    public SMSMoResponse handleReceivedSMS(SMSMoRequest smsMoRequest) {
        String message = smsMoRequest.getMessage();
        String destinationAddress = smsMoRequest.getSourceAddress();
        messageDao.createMessageRequest(message);
        try{
            LOGGER.debug("Setting MT Request");
            SMSMtRequest smsMtRequest = new SMSMtRequest();
            smsMtRequest.setDestinationAddresses(Collections.singletonList(destinationAddress));
            Optional <UserDetails> userDetails = messageDao.findUserMessageByid(Integer.parseInt(message));

            if(userDetails.isPresent()){
                UserDetails userDetails1 =userDetails.get();
                smsMtRequest.setMessage(userDetails1.getMessage());
                smsMtHandler.sendSMS(smsMtRequest);
            }
            else{
                smsMtRequest.setMessage("can not find id");
                smsMtHandler.sendSMS(smsMtRequest);
            }
        }catch (Exception e){
            LOGGER.error("Fail to send the sms");
            return new SMSMoResponse("E1000", "Error");
        }

        return smsMoReceiver.processReceivedMsg(smsMoRequest);
    }
}
