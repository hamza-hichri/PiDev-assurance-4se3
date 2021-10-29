/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.service;

import com.mysql.jdbc.Connection;
import edu.esprit.utiles.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author seif
 */
public class PackageService {
    
   private Connection cnx;

    public PackageService() {
        cnx =  (Connection) MyConnection.getMyCnx().getConnection();
        
    }

   public void ajouterPackage (Package p){
        try {
            String req = "INSERT INTO gestion_des_package (Nom,Date_sous,Date_exp,Prix) values (?,?,?,?)";
             PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
             
            pst.setString(1, p.getName());
           
            
            pst.executeUpdate();
          
            System.out.println("Le contrat a été ajouté avec succes ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
   }
   
   public void afficherPackage (){
        try {
        String req = "SELECT * from gestion_des_package";
        Statement st = (Statement) cnx.createStatement();
        ResultSet rt =  st.executeQuery(req);
        while (rt.next()) {
            int id=rt.getInt("idPackage");
            
            String Nom = rt.getString("NomPackage");
            String Date_sous = rt.getString("Date_sousPackage");
            String Date_exp = rt.getString("Date_expPackage");
            String Prix = rt.getString("PrixPackage");
            
            System.out.println(id+"°/ "+Nom+" : "+Date_sous+" : "+Date_exp+" : "+Prix+",");
        }
        
        }
        catch (SQLException ex) {
          System.err.println(ex.getMessage());
    }}
   
   public void updatePackage(Package p ,String nom,String date_sous,String date_exp,String Prix){     
             try{
        Statement st = (Statement) cnx.createStatement();
        String query = "UPDATE gestion_des_package SET nomPackage= '"+nom+"', date_sousPackage= '"+date_sous+"', date_expPackage= '"+date_exp+"',PrixPackage= '"+Prix+"'WHERE idPackage='"+p.getName()+"'";
        st.executeUpdate(query); 
        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
   }
   
   
   public void deletePackage(int id){
        
            //String req = "DELETE FROM evenement WHERE (id="+id+")";
            String req = "DELETE FROM gestion_des_package WHERE package.idPackage="+id;
            try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("package supprimé");
        } catch (SQLException ex) {
                System.out.println("Erreur de suppression");
        }
    }
   
   public void recherchePackage(int id){
        try {
     String sql = "SELECT * FROM gestion_des_package WHERE idPackage='"+id+"'";  
        PreparedStatement statement = cnx.prepareStatement(sql);
        Statement st = (Statement) cnx.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        rs.last();
        int nbrRow = rs.getRow();
        if(nbrRow!=0){
            System.out.println("Package existe");
        }else {
            System.out.println("Package non existant");
        }
        
        }catch (SQLException e){
            System.out.println(e.getMessage());
    
        }
        }
}
