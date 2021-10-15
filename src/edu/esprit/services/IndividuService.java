/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import com.mysql.jdbc.Connection;
import edu.esprit.entities.Individu;
import edu.esprit.utils.MyConnection;
import edu.esprit.entities.Clients;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author asus
 */
public class IndividuService {
     private Connection cnx;

    public IndividuService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    

    public void ajouterIndividu (Individu p,Clients s){
        try {
             String querry = "INSERT INTO `individu` (`id_client`, `prenom_client`, `cin`,`date_naissance`) VALUES ('"
                + s.getId_client()+ "', '" + p.getPrenom()+ "', '" + p.getCin()+"',' "+ p.getDate_naissance()+ "')";
            
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(querry);
            System.out.println("INDIVIDU added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
