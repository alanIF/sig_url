package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlandeMedeiros
 */
public class ConnectionFactory {
     public  Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sig_url","root","");
            
        }catch(SQLException e){
                throw new RuntimeException(e);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    
    }
}
