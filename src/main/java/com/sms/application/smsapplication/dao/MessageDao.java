package com.sms.application.smsapplication.dao;


import com.sms.application.smsapplication.user.UserDetails;

import java.util.Optional;

public interface MessageDao {
    void createMessageRequest(String message);
    Optional<UserDetails> findUserMessageByid(int id);
}
