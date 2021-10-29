/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLEncoder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URLConnection;
/**
 *
 * @author seif
 */
public class SMSsender extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  {
      
        
        String message = "Nouveelle  Offre";
        String username = "Seyf";
        String password = "12345678";
        String phone = "55640259";
        String adress = "https://api.orange.com/smsmessaging/v1/outbound/tel%3A%2B{{55640259}}/requests";
        String port = "8080";
        
        URL url = new URL(
        
        adress+": "+port+"/SendSMS?username="+username+" &password="+password+"&phone="+phone+"&message="+URLEncoder.encode(message, "UTF-8")
        );
                
       /** 
        URLConenction connection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new.InputStreamReader(Connection.getInputStream()));
        String inputLine;
        while(inputLine = bufferedReader .readLine()) !=null){
        System.out.println(inputLine);
    }
        
      bufferedReader.close();
    }
        
    }*/
    

