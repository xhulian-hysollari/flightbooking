/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.register_model;

public class register_controller {
    
    register_model rm = new register_model();
    
    public void register(String name, String surname, String email, String password) {
        rm.register(name, surname, email, password);
    }
    
}
