package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.smsMT.SMSMtRequest;
import com.sms.application.smsapplication.smsMT.SMSMtResponse;

public interface SMSMtHandler {

    SMSMtResponse sendSMS(SMSMtRequest smsMtResponse);
}
