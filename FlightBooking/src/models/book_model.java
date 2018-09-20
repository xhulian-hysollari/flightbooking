/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.db_connect;
import static flightbooking.book.jTable1;
import flightbooking.personal_flights;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class book_model {
    public void getFlights(DefaultTableModel flights) {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);
            Object[] row = null;
            ResultSet rs;
            Statement stm = connection.createStatement();
            rs = stm.executeQuery("select * from flights");
            while (rs.next()) {
                String string = String.valueOf(rs.getInt("id")) + ","
                        + rs.getString("country") + ","
                        + rs.getString("city") + ","
                        + rs.getString("starting_date") + ","
                        + rs.getString("return_date") + ","
                        + rs.getInt("price");
                row = string.split(",");
                jTable1.setModel(flights);
                flights.addRow(row);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addPersonalFlight(int user_id, int flight_id) {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);
            String sql = "INSERT INTO personal(user_id, flight_id) VALUES (?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, user_id);
            pst.setInt(2, flight_id);
            pst.execute();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void personalFlights(DefaultTableModel personal, String user_id) {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);
            Object[] row = null;
            ResultSet rs;
            Statement stm = connection.createStatement();
            rs = stm.executeQuery("select *, personal.id as personal_id from flights inner join personal on flights.id = personal.flight_id where personal.user_id = " +user_id);
            while (rs.next()) {
                String string = String.valueOf(rs.getInt("personal_id")) + ","
                        + rs.getString("country") + ","
                        + rs.getString("city") + ","
                        + rs.getString("starting_date") + ","
                        + rs.getString("return_date") + ","
                        + rs.getInt("price");
                row = string.split(",");
                personal_flights.jTable1.setModel(personal);
                personal.addRow(row);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void cancelFlight() {
        try {
            db_connect db = new db_connect();
            Connection connection;
            connection = DriverManager.getConnection(db.Url, db.Uid, db.Pwd);

            Statement stm = connection.createStatement();

            String id = (String) personal_flights.jTable1.getModel().getValueAt(personal_flights.jTable1.getSelectedRow(), 0);

            String sql = "delete from personal where id=" + id;
            if (stm.executeUpdate(sql) == 1) {
                JOptionPane.showMessageDialog(null, "Flight cancelled");
            }
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
