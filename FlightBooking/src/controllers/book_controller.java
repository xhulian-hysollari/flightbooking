/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.table.DefaultTableModel;
import models.book_model;

public class book_controller {
    book_model bm = new book_model();
    
    public void getFlights(DefaultTableModel flights) {
        bm.getFlights(flights);
    }
    
    public void addPersonalFlight(int user_id, int flight_id) {
        bm.addPersonalFlight(user_id, flight_id);
    }
    
    public void PersonalFlights(DefaultTableModel personal, String user_id) {
        bm.personalFlights(personal, user_id);
    }
    
    public void cancelFlight() {
        bm.cancelFlight();
    }
}
