/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lenouvo
 */
public class TestController implements Initializable {

   @FXML
    
    private ImageView imglogo;
    @FXML 
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Image img = new Image("/edu/esprit/gui/assurance.gif");
       imglogo.setImage(img);
    }
    @FXML
    public void login( MouseEvent event) throws IOException{
        if(txtUsername.getText().equals("admin")&& txtPassword.getText().equals("admin")){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/edu/esprit/gui/MainView.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
            check();
            
        }else{
            error();
        }
    }
    public void error(){

        Notifications notification =Notifications.create();
        notification.title("Error");
        notification.text("Error Username Or Password Is Incorrect");
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }
    public void check(){
        Notifications notification =Notifications.create();
        notification.title("Success");
        notification.text("Welcome");
        notification.hideAfter(Duration.seconds(5));
        notification.position(Pos.BASELINE_RIGHT);
        notification.show();
    }
}
