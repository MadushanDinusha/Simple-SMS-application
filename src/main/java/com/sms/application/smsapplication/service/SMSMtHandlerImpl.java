package com.sms.application.smsapplication.service;

import com.sms.application.smsapplication.smsMT.SMSMtRequest;
import com.sms.application.smsapplication.smsMT.SMSMtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SMSMtHandlerImpl implements SMSMtHandler {

    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSMtHandlerImpl.class);

    @Value("${platform.sms.endpoint}")
    private String platformSmsMtEndpoint;

    @Autowired
    public SMSMtHandlerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SMSMtResponse sendSMS(SMSMtRequest SMSMtRequest) {
        LOGGER.debug("Send the sms to platform");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SMSMtRequest> requestHttpEntity = new HttpEntity<>(SMSMtRequest, headers);
        ResponseEntity<SMSMtResponse> smsMtConfirmation = restTemplate
                .postForEntity(platformSmsMtEndpoint, requestHttpEntity, SMSMtResponse.class);

        return smsMtConfirmation.getBody();
    }
}
