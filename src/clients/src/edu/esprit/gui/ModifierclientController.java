/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Clients;
import edu.esprit.services.ClientsService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */

   public class ModifierclientController implements Initializable {

   
    private TextField numaj;
    @FXML
    private TextField adresseaj;
    @FXML
    private TextField patenteaj;
    @FXML
    private Button modifclient;
    ClientsService cs =new ClientsService ();
    public static Clients s ;

    

    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }
public static void setClients (Clients o ){
        s=o;
    }
    @FXML public void updateclient (ActionEvent event)
    { 
        Clients o1 =new Clients();
//        if (nomaj.getText().isEmpty()
//                || prenomaj.getText().isEmpty()
//                || cinaj.getText().isEmpty()
//                || numaj.getText().isEmpty()
//                || adresseaj.getText().isEmpty()
//               
//               ) {
//                       
//                       
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText("Veuillez remplir tous les champs");
//            alert.showAndWait();
//            
//        } else {
            
        
        s.setNum_client(Integer.parseInt(numaj.getText()));
       s.setAdresse_client(adresseaj.getText());
       
        s.setNum_patente(Integer.parseInt(patenteaj.getText()));

        cs.updateClient(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("client updated ☺ ");
            alert.setContentText("client updated avec sucèes ☺ ");
            alert.showAndWait();
        
    }
    
    
            
    
   
            }

    

