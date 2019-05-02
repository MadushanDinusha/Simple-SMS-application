package com.sms.application.smsapplication.smsMT;

import java.util.List;

public class SMSMtRequest {

    private String version;
    private String applicationId;
    private String password;
    private List<String> destinationAddresses;
    private String sourceAddress;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    @Override
    public String toString() {
        return "SMSMtRequest{" +
                "version='" + version + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", password='" + password + '\'' +
                ", destinationAddresses=" + destinationAddresses +
                ", sourceAddress='" + sourceAddress + '\'' +
                '}';
    }
}
