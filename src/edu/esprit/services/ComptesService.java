/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import edu.esprit.entities.Comptes;
import edu.esprit.utils.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenouvo
 */
public class ComptesService {
    
      private  Connection cnx ;
      private Statement ste;


    public ComptesService() {
        cnx = (Connection) MyConnection.getMyCnx().getConnection();
    }
    public void ajouterComptes (Comptes c) throws SQLException{
        ste = (Statement) cnx.createStatement ();
         System.out.println(c.getID());
        String req ="INSERT INTO Comptes (ID, Nom, Prénom, Email, CIN,Num_Tel) VALUES (NULL,'"+c.getNom()+"','"+c.getPrenom()+"',' "+c.getEmail()+"', '"+c.getCIN()+"','"+c.getNum_Tel()+"');";
        ste.executeUpdate(req);
        System.out.println("Comptes added !");
        
       
        
    
    }
     public void supprimerComptes(Comptes c) throws SQLException {
        try{
             String querry = "DELETE FROM `Comptes` WHERE ID=" + c.getID();
        Statement stm = (Statement) cnx.createStatement();
        stm.executeUpdate(querry);   
          System.out.println("Comptes deleted !");

        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
       

    }
    public void AffichageComptes(Comptes c) throws SQLException{
        try {
        String req = "SELECT * from Comptes";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rt =  stm.executeQuery(req);
        while (rt.next()) {
            String ID = rt.getString("ID");
            String Nom = rt.getString("Nom");
            String Prenom = rt.getString("Prénom");
            String Email = rt.getString("Email");
            String CIN = rt.getString("CIN");
            String Num_Tel = rt.getString("Num_Tel");
            
            System.out.println(ID+" : "+Nom+" : "+Prenom+" : "+Email+" : "+CIN+" : "+Num_Tel);
        }
        
        }
        catch (SQLException ex) {
          System.err.println(ex.getMessage());
        }
    }
      public List<Comptes> getComptes() throws SQLException {
        String querry = "SELECT * FROM `Comptes`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Comptes> Comptes = new ArrayList<>();
        while (rs.next()) {
            Comptes c = new Comptes();
            c.setID(rs.getInt(1));
            c.setNom(rs.getString(2));
            c.setPrenom(rs.getString(3));
            c.setEmail(rs.getString(4));
            c.setCIN(rs.getString(5));
            c.setNum_Tel(rs.getString(6));
            
         
            Comptes.add(c);
        }
        return Comptes;
    }
           public void updateComptes(Comptes c,String nom,String prenom,String email,String  cin,String num_tel) throws SQLException {
            
             try{
        Statement stm = (Statement) cnx.createStatement();
        String query = "UPDATE Comptes SET nom= '"+nom+"', prenom= '"+prenom+"', email= '"+email+"', cin= '"+cin+"' WHERE ID='"+c.getID()+"'";
        stm.executeUpdate(query); 
        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
       
    }
    

}