package com.login.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class Validate {
    public static Optional<User> checkUser(String login, String password) {
        boolean st = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root",
                    "root");
            if (!conn.isClosed()) {
                System.out.println("Соединение с базой данных успешно");
            }
            PreparedStatement pst = conn.prepareStatement("select * from myshema_8347.authorization where login=? and password=?");
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                User user = new User()
                        .setId(rs.getInt("Id"))
                        .setLogin(rs.getString("loging"))
                        .setName(rs.getString("Name"))
                        .setRole(rs.getString("Rolle"));

                return Optional.of(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
