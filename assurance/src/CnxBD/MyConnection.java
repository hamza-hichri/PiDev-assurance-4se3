/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CnxBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ISSAM
 */
public class MyConnection {
      public String url="jdbc:mysql://localhost:3306/aziz";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    public static MyConnection myc;
    
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("connecton etablie "+url);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connection non etablie");        
        }
    }
    ////design pattern singleton
     public static Connection getConnection(){
     return cnx;
     }
    
    
    public static MyConnection getIstance(){
    if (myc==null){
    myc=new MyConnection();
    }
    return myc;
    }
}
