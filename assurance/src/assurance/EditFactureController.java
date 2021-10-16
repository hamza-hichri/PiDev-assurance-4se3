/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assurance;

import CnxBD.MyConnection;
import java.awt.Menu;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ISSAM
 */
public class EditFactureController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField matricule;
    @FXML
    private TextField code;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker date_deb;
    @FXML
    private DatePicker date_fin;
    @FXML
    private Button btn_edit;
    @FXML
    private Label label;
    @FXML
    private Label msg;
    @FXML
    private Button back;
       MyConnection myc = MyConnection.getIstance();
    Connection cnx = myc.getConnection();
    PreparedStatement preparedStatement;
    private Statement st;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Statement statement=null ;
        ResultSet resultSet = null ;
        try {
            statement=(Statement) cnx.createStatement();
            String sql="SELECT * FROM facture WHERE id = '"+ConsulterFactureController.vv+"' ";
            
            //preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
           resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
           
            nom.setText(resultSet.getString("nom"));
            prenom.setText(resultSet.getString("prenom"));
            matricule.setText(resultSet.getString("matricule"));
            code.setText(resultSet.getString("code"));
            prix.setText(resultSet.getString("prix"));
            date_deb.setValue(LocalDate.now());
            date_fin.setValue(LocalDate.now());
                  	 
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO
    }    

    @FXML
    private void edit(ActionEvent event) {
        updatedata();
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ConsulterFacture.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String updatedata(){
        try {
            String st = "UPDATE facture SET nom = ?, prenom = ?, matricule = ?, code = ? , prix = ? , date_debut = ? ,date_fin = ? WHERE id = '"+ConsulterFactureController.vv+"';";
            preparedStatement = (PreparedStatement) cnx.prepareStatement(st);
          preparedStatement.setString(1, nom.getText());
         preparedStatement.setString(2, prenom.getText());
         preparedStatement.setString(3, matricule.getText());
         preparedStatement.setString(4, code.getText());
         preparedStatement.setString(5, prix.getText());
         preparedStatement.setString(6, date_deb.getValue().toString());
         preparedStatement.setString(7, date_fin.getValue().toString());

            preparedStatement.executeUpdate();
            msg.setTextFill(Color.GREEN);
            msg.setText("Updated Successfully");
            return "Success";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            msg.setTextFill(Color.TOMATO);
            msg.setText(ex.getMessage());
            return "Exception";
        }
    }

    
}
