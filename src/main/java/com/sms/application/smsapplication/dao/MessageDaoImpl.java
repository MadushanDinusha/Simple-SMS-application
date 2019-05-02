package com.sms.application.smsapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageDaoImpl implements MessageDao {

    private final JdbcTemplate template;
    private static final String INSERT_MESSAGE = "INSERT INTO userd(user_name) VALUES(?)";

    @Autowired
    public MessageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public void createMessageRequest(String message) {
        try {
            template.update(INSERT_MESSAGE, new Object[]{message});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
