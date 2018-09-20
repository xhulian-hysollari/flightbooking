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

public class register_model {
    public void register(String name, String surname, String email, String pass) {    
                try {
                db_connect db = new db_connect();
                Connection connection;
                connection = DriverManager.getConnection(db.Url,db.Uid,db.Pwd);
                String sql = "INSERT INTO users (name, surname, email, password, type) VALUES (?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, surname);
                pst.setString(3, email);
                pst.setString(4, pass);
                pst.setString(5, "client");    
                pst.execute();

                JOptionPane.showMessageDialog(null, "You were registered");
                connection.close();
            } 
            catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
}
}
