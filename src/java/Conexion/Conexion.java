/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rodri
 */
public class Conexion {
    Connection conn;
    String url ="jdbc:mysql://localhost:3306/sistema2";
    String user ="root";
    String pass="";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("error de conexion "+e.getMessage());
        }
        return conn;
    }
}
