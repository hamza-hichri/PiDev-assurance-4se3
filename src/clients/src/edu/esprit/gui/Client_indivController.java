/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import Iservice.mylistener;
import edu.esprit.entities.Clients;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Client_indivController implements Initializable {
private mylistener mylistener;
private Clients oeuvre;
    @FXML
    private Label nomc;
    @FXML
    private Label prenomc;
    @FXML
    private Label cinc;
    @FXML
    private Label numeroc;
    @FXML
    private Label adressec;
    @FXML
    private Label rolec;
    @FXML
    private Label patentec;
    @FXML
    private Label registrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ajouterP(ActionEvent event) {
        mylistener.onpressed(event,oeuvre);
    }

    @FXML
    private void click(MouseEvent event) {
         mylistener.onClickListener(event,oeuvre);
    }
    
    public void setData(Clients oeuvre, mylistener myListener) {
        this.oeuvre  = oeuvre;
        this.mylistener = myListener;
        nomc.setText(oeuvre.getNom_client());
         
     prenomc.setText(oeuvre.getPrenom_client());
   
     cinc.setText(oeuvre.getCin()+"");
   
     numeroc.setText(oeuvre.getNum_client()+"");
   
    adressec.setText(oeuvre.getAdresse_client());
    
     rolec.setText(oeuvre.getRole());
  
    patentec.setText(oeuvre.getNum_patente()+"");
    
    registrec.setText(oeuvre.getRegistre_commerce()+"");
        
      
        
       
    }
}
