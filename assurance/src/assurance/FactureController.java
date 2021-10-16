/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assurance;

import CnxBD.MyConnection;
import static CnxBD.MyConnection.cnx;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import entities.Facture;
import java.awt.Menu;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ISSAM
 */
public class FactureController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField matricule;
    @FXML
    private TextField code_voiture;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private Label label ;
    @FXML
    private Label msg ;
     PreparedStatement preparedStatement;
    private Statement st;
    private ResultSet rs;
     MyConnection myc = MyConnection.getIstance();
    Connection cnx = myc.getConnection();
    @FXML
    private Button back;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void valider(ActionEvent event) throws SQLException {
           if (nom.getText().isEmpty() || prenom.getText().isEmpty() || matricule.getText().isEmpty() || code_voiture.getText().isEmpty() || prix.getText().isEmpty() || date_deb.getValue()== null || date_fin.getValue()== null) {
            msg.setTextFill(Color.TOMATO);
            msg.setText("Enter all details");
            
        } else {
         String st = "INSERT INTO facture (nom,prenom,matricule,code,prix,date_debut,date_fin) VALUES (?,?,?,?,?,?,?)";
         preparedStatement = (PreparedStatement) cnx.prepareStatement(st);
         preparedStatement.setString(1, nom.getText());
         preparedStatement.setString(2, prenom.getText());
         preparedStatement.setString(3, matricule.getText());
         preparedStatement.setString(4, code_voiture.getText());
         preparedStatement.setString(5, prix.getText());
         preparedStatement.setString(6, date_deb.getValue().toString());
         preparedStatement.setString(7, date_fin.getValue().toString());
         preparedStatement.executeUpdate();
         msg.setTextFill(Color.GREEN);
         msg.setText("Added Successfully");
         
        }
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
