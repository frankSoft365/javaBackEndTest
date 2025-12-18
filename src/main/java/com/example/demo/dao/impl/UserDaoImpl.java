package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDaoImpl implements UserDao {

    public Integer checkUser(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        Integer count = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/frank_school";
            String user = "root";
            String pw = "12345678";
            connection = DriverManager.getConnection(url, user, pw);
            String sql = "select count(*) as res from user where username = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("res");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
