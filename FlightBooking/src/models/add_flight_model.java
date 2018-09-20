/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.db_connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class add_flight_model {

    public void add(String country, String city, String start, String end, int price) {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);
            String sql = "INSERT INTO flights (`country`, `city`, `starting_date`, `return_date`, `price`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, country);
            pst.setString(2, city);
            pst.setString(3, start);
            pst.setString(4, end);
            pst.setInt(5, price);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Flight Added");

            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
