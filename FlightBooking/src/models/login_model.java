/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.db_connect;
import flightbooking.add_flight;
import flightbooking.book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login_model {
    public void sign_in(String email, String password) {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);
            String sql = "Select * from users where email=? and password=? ";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs;
            rs = pst.executeQuery();
            if (rs.next()) {
                if("admin".equals(rs.getString("type"))) {
                    add_flight af = new add_flight();
                    af.setVisible(true);
                    af.id = rs.getString("id");
                    
                } else {
                    book b = new book();
                    b.id = rs.getString("id");
                    b.setVisible(true);
                    book.add_flight_btn.setVisible(false);
                }
            }
            connection.close();
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
    }
}
