/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import edu.esprit.utiles.MyConnection;
import edu.esprit.entities.Package;
import java.sql.SQLException;

/**
 *
 * @author seif
 */
public class PackageService {
    private Connection cnx;

    public PackageService() {
       cnx = (Connection) MyConnection.getMyCnx().getConnection();
       
    }
    public void ajouterPackage (Package p){
        try {
            String req = "INSERT INTO gestion_des_package (nom) values (?,?)";
             PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.executeUpdate();
          
            System.out.println("Le contrat a été ajouté avec succes ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }

  
    
}
