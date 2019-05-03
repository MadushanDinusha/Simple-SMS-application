package com.sms.application.smsapplication.dao;

import com.sms.application.smsapplication.mapper.UserDetailsMapper;
import com.sms.application.smsapplication.user.UserDetails;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MessageDaoImpl implements MessageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDaoImpl.class);
    private final JdbcTemplate template;
    private static final String INSERT_MESSAGE = "INSERT INTO userd(user_name) VALUES(?)";
    private static final String FIND_MESSAGE_BY_ID = "SELECT * FROM userd WHERE id = ?";

    @Autowired
    public MessageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public void createMessageRequest(String message) {
        try {
            LOGGER.info("Inserting message[{}] to database", message);
            template.update(INSERT_MESSAGE, new Object[]{message});
        } catch (Exception e) {
            LOGGER.error("Error occurred while inserting");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<UserDetails> findUserMessageByid(int id) {
        try {
            UserDetails passportDetail = template.queryForObject(FIND_MESSAGE_BY_ID,
                    new Object[]{id}, new UserDetailsMapper());
            return Optional.ofNullable(passportDetail);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.debug("Could not find any passport-request with ref-no[{}]", id);
            return Optional.empty();
        } catch (Exception e) {
            LOGGER.error("Error occurred while finding passport request with ref-no[{}] ", id, e);
            throw new RuntimeException(e);
        }
    }
}
