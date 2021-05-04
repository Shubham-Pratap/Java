package com.app.dao;

import com.app.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int saveUser(User user) {

        int rows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?)");
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getEmailAddress());
            rows = statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rows;
    }
}
