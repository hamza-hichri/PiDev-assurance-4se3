/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import edu.esprit.entities.Clients;
import edu.esprit.services.ClientsService;
import Iservice.mylistener;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.AnchorPane;
   
/**
 * FXML Controller class
 *
 * @author asus
 */
public class MenuController implements Initializable {
    private Clients c;
    ClientsService cs = new ClientsService();
    private mylistener mylistener;
    @FXML
    private ScrollPane scrollO;
    @FXML
    private GridPane grid;
    @FXML
    private Button suprimclient;
    @FXML
    private Button modifclient;
    @FXML
    private Button ajoutclient;
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Clients> listc=new ArrayList<>();
        listc.addAll(cs.getAllClients());
       if (listc.size() > 0) {
                setChosenO(listc.get(0));
                mylistener = new mylistener() {
                    @Override
                    public void onClickListener(MouseEvent event ,Clients oeuvre) {
                            setChosenO(oeuvre);
                            System.out.println(oeuvre);
                    }

                    @Override
                    public void onpressed(ActionEvent event, Clients oeuvre) { 
                   
                    }
                    @Override
                    public void onClickListener(Clients facture) {
  
                    }

                    
                };
       }
        int column=0;
        int row=1;
        try{
            for (int i=0;i<listc.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader ();
            fxmlLoader.setLocation(getClass().getResource("client_indiv.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            
            Client_indivController itemController = fxmlLoader.getController();
            itemController.setData(listc.get(i),mylistener);
        
        if (column == 1) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(10));
                }}
                 catch (IOException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
       
}
    private void setChosenO(Clients o) {
        c=o;
        
        
        
        
        
    }
    
    @FXML
    private void suprimclient(ActionEvent event) throws IOException {
        cs.supprimerClient(c.getId_client());
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        
        
      

    }

      



    @FXML
   private void ajoutclient(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ajoutclient.fxml"));
            Scene tableViewScence = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(tableViewScence);
     window.show();
    }
   @FXML
   private void modifclient(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("modifierclient.fxml"));
            Scene tableViewScence = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(tableViewScence);
     window.show();
}
}
