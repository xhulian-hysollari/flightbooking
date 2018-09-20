/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connect {
    public String Url = "jdbc:mysql://localhost:3306/flights";
    public String Uid = "root";
    public String Pwd = "";
    
    public static String USER;
    private Connection con;
    
    public void getConnected(){
      Connection connection;
      try{
          
      setConnection(DriverManager.getConnection(Url, Uid, Pwd));
      
      
    }catch(Exception e){
        System.err.println(e);
    }

    }
    public Connection getConnection(){
        return con;
    }

    
    public void setConnection(Connection connect) {
        this.con = connect;
    }
}
