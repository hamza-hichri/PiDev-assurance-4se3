/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Offres;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


/**
 * FXML Controller class
 *
 * @author seif
 */
public class OffreController implements Initializable {

    @FXML
    private Label txt_id;
    @FXML
    private Button btn_envoie;
    @FXML
    private TextArea tf_message;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Connection getConnection(){
      Connection cnx;
      try{
          
          cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assurance", "root", "");
          return cnx;
          
      }catch(Exception ex){      
                
       System.out.println("ERROR: " +ex.getMessage());
       return  null;
       
   }
     
  
   }
   
   public ObservableList<Offres> getoffreList(){
       
   ObservableList<Offres> offreList  = FXCollections.observableArrayList();
   Connection cnx = getConnection();
   String query = "SELECT FROM gestion_des_offres";
   Statement st;
   ResultSet rs;
   
   try{
    
            st = cnx.createStatement();
       
            rs = st.executeQuery(query);
            Offres offre;
            while(rs.next()){
         offre = new Offres (rs.getInt("id"), rs.getString("date_de_reception"), rs.getString("Prix"));
            offreList.add(offre);
            
        }
       
      } catch(Exception ex){
    
    ex.printStackTrace();
}
      return offreList;
      
   }
   
 
}
