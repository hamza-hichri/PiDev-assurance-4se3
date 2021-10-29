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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutclientController implements Initializable {

    @FXML
    private TextField nomaj;
    @FXML
    private TextField prenomaj;
    @FXML
    private TextField cinaj;
    @FXML
    private TextField numaj;
    @FXML
    private ComboBox<String> roleaj;
    @FXML
    private TextField adresseaj;
    @FXML
    private TextField dateaj;
    @FXML
    private TextField registreaj;
    @FXML
    private TextField patenteaj;
    @FXML
    private Button ajoutclient;
     ClientsService cs = new ClientsService();
    String rolee ="";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ObservableList<String> cat = FXCollections.observableArrayList("individuel","professionel");
        roleaj.setItems(cat);
    }    
 
    @FXML public void ajoutclient (ActionEvent event)
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
            o1.setNom_client(nomaj.getText());
        o1.setPrenom_client(prenomaj.getText());
        o1.setCin(Integer.parseInt(cinaj.getText()));
        o1.setNum_client(Integer.parseInt(numaj.getText()));
        o1.setAdresse_client(adresseaj.getText());
        o1.setRole(rolee);
        o1.setRegistre_commerce(Integer.parseInt(registreaj.getText()));
        o1.setNum_patente(Integer.parseInt(patenteaj.getText()));

        cs.ajouterClient(o1, 1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("client ajouté ☺ ");
            alert.setContentText("clients ajouté avec sucèes ☺ ");
            alert.showAndWait();
        
    }
    
    @FXML
    private void selectcat(ActionEvent event) {
        String s = roleaj.getSelectionModel().getSelectedItem();
        rolee = s ;
    }
            }
