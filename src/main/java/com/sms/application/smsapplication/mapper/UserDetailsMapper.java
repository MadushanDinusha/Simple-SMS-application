package com.sms.application.smsapplication.mapper;

import com.sms.application.smsapplication.user.UserDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsMapper implements RowMapper<UserDetails> {

    public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(rs.getInt("id"));
        userDetails.setMessage(rs.getString("user_name"));
        return userDetails;
    }

}
