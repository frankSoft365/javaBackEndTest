package com.example.demo;

import com.example.demo.pojo.Student;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {

    @Test
    public void updateTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/frank_school", "root", "12345678");
        Statement statement = root.createStatement();
        int i = statement.executeUpdate("insert into student values (null, 'jane', null, null)");
        System.out.println("受影响行数 : " + i);
        statement.close();
        root.close();
    }

    @Test
    public void  queryTest() {
        Connection root = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            root = DriverManager.getConnection("jdbc:mysql://localhost:3306/frank_school", "root", "12345678");
            preparedStatement = root.prepareStatement("select * from student where id = ?");
            preparedStatement.setInt(1, 3);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Student student = new Student(
                        res.getInt("id"),
                        res.getString("name")
                );
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                root.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
