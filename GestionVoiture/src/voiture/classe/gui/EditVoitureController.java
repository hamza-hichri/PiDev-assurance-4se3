/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.gui;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import voiture.classe.utils.VoitureConnection;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class EditVoitureController implements Initializable {

    @FXML
    private TextField cinuu;
    @FXML
    private TextField marquevu;
    @FXML
    private TextField modelevu;
    @FXML
    private TextField chasisvu;
    @FXML
    private TextField grisevu;
    @FXML
    private TextField nbvu;
    @FXML
    private TextField valvu;
    @FXML
    private TextField puisvu;
    @FXML
    private TextField agevu;
    @FXML
    private Button modifvu;
    @FXML
    private Button annulervu;
    VoitureConnection myc = VoitureConnection.getCnx();
    Connection cnx = myc.getCnxV();
    PreparedStatement preparedStatement;
    private java.sql.Statement st;
    @FXML
    private Label msg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Statement statement=null ;
        ResultSet resultSet = null ;
        try {
            statement=(Statement) cnx.createStatement();
            String sql="SELECT * FROM Voiture WHERE idV = '"+AffichageVoitureController.vv+"' ";
            
            //preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
           resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
           
            cinuu.setText(resultSet.getString("CinUtilisateur"));
            marquevu.setText(resultSet.getString("marqueV"));
            modelevu.setText(resultSet.getString("modeleV"));
            chasisvu.setText(resultSet.getString("chasisV"));
            grisevu.setText(resultSet.getString("GriseV"));
            nbvu.setText(resultSet.getString("nbplaceV"));
            valvu.setText(resultSet.getString("valeurV"));
            puisvu.setText(resultSet.getString("puissV"));
            agevu.setText(resultSet.getString("ageV"));
            
                  	 
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO
    }    

    @FXML
    private void saveupdate(ActionEvent event) {
        updatevoiture();
    }

    @FXML
    private void returnvu(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AffichageVoiture.fxml"));
            Stage stage = (Stage) annulervu.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public String updatevoiture(){
        try {
            String st = "UPDATE Voiture SET CinUtilisateur = ?, marqueV = ?, modeleV = ?, chasisV = ? , GriseV= ? , nbplaceV= ? ,valeurV= ? ,puissV=? , ageV=? WHERE idV = '"+AffichageVoitureController.vv+"';";
            preparedStatement = (PreparedStatement) cnx.prepareStatement(st);
          preparedStatement.setString(1, cinuu.getText());
         preparedStatement.setString(2, marquevu.getText());
         preparedStatement.setString(3, modelevu.getText());
         preparedStatement.setString(4, chasisvu.getText());
         preparedStatement.setString(5, grisevu.getText());
         preparedStatement.setString(6, nbvu.getText());
         preparedStatement.setString(7, valvu.getText());
         preparedStatement.setString(8, puisvu.getText());
         preparedStatement.setString(9, agevu.getText());
         
         
         

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
