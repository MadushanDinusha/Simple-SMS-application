package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.smsMO.SMSMoRequest;
import com.sms.application.smsapplication.smsMO.SMSMoResponse;

public interface PlatformSMSHandler {
    SMSMoResponse handleReceivedSMS(SMSMoRequest smsMoRequest);
}
