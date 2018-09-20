/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import models.login_model;

public class login_controller {

    login_model lm = new login_model();
    
    public void sign_in(String email, String password) {
        
            lm.sign_in(email, password);
        
    }
    
}
