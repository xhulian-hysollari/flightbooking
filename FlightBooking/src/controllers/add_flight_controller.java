/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.add_flight_model;

public class add_flight_controller {
 
    add_flight_model afm = new add_flight_model();
    
    public void add_flight(String country, String city, String start, String end, int price) {
        afm.add(country, city, start, end, price);
    }
    
}
