/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author hamza
 */
public class VoitureConnection {
    private String url="jdbc:mysql://localhost:3306/assurance";
    private String user="root";
    private String psw="";
    private Connection cnxV;
    
    private static VoitureConnection mycnxv;
    
    private VoitureConnection() {
        try {
            cnxV= (Connection) DriverManager.getConnection(url, user, psw);
            System.out.println("connected");
        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    public Connection getCnxV() {
        return cnxV;
    }
    public static VoitureConnection getCnx(){
        if (mycnxv==null){
            mycnxv= new VoitureConnection();
        }
        return mycnxv;
    }
}
