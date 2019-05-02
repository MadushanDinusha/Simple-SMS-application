package com.sms.application.smsapplication.smsMO;

public class SMSMoRequest {

    private String version;
    private String applicationId;
    private String sourceAddress;
    private String message;
    private String requestId;
    private String messageEncoding;

    public SMSMoRequest() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String messageEncoding() {
        return messageEncoding;
    }

    public void messageEncoding(String encoding) {
        this.messageEncoding = encoding;
    }

    @Override
    public String toString() {
        return "SMSMoRequest{" +
                "version='" + version + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", message='" + message + '\'' +
                ", requestId='" + requestId + '\'' +
                ", encoding='" + messageEncoding + '\'' +
                '}';
    }
}
