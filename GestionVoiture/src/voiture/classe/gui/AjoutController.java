/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.gui;
import voiture.classe.gui.AffichageVoitureController;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import voiture.classe.entities.Voiture;
import voiture.classe.service.VoitureService;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AjoutController implements Initializable {

    @FXML
    private TextField cinuv;
    @FXML
    private TextField marv;
    @FXML
    private TextField modv;
    @FXML
    private TextField chav;
    @FXML
    private TextField cgv;
    @FXML
    private TextField nbp;
    @FXML
    private TextField valv;
    @FXML
    private TextField puisv;
    @FXML
    private TextField agev;
    @FXML
    private Button btnajout;
    @FXML
    private Button btnannuler;
    @FXML
    private Label controlesaisie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutvoiture(ActionEvent event) {
        if(cinuv.getText().isEmpty()||marv.getText().isEmpty()||modv.getText().isEmpty()||chav.getText().isEmpty()||cgv.getText().isEmpty()||nbp.getText().isEmpty()||valv.getText().isEmpty()||puisv.getText().isEmpty()||agev.getText().isEmpty()){
            controlesaisie.setTextFill(Color.TOMATO);
            controlesaisie.setText("Verifier votre champs");}
        else{
            int cinut= Integer.parseInt(cinuv.getText());
            String marqv=marv.getText();
            String modele=modv.getText();
            String chassis=chav.getText();
            String cartegrise=cgv.getText();
            int nbplace=Integer.parseInt(nbp.getText());
            float valeur=Float.parseFloat(valv.getText());
            int puis=Integer.parseInt(puisv.getText());
            int age=Integer.parseInt(agev.getText());
            Voiture v= new Voiture(cinut, marqv, modele, chassis,cartegrise, nbplace, valeur, puis, age);
            VoitureService vs = new VoitureService();
            vs.ajouterVoiture2(v);
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AffichageVoiture.fxml"));
        try {
            Parent root= loader.load();
            AffichageVoitureController affv=loader.getController();
            cinuv.getScene().setRoot(root);
            
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }}
        /*affv.SetTextIdv(v.getIdV()+"");
            affv.SetTextCinUtilisateur(v.getCinUtilisateur()+"");
            affv.SetTextmarqueV(v.getMarqueV()+"");
            affv.SetTextmodeleV(v.getModeleV()+"");
            affv.SetTextchasisV(v.getChasisV()+"");
            affv.SetTextGriseV(v.getGriseV()+"");
            affv.SetTextnbplaceV(v.getNbplaceV()+"");
            affv.SetTextvaleurV(v.getValeurV()+"");
            affv.SetTextpuissV(v.getPuissV()+"");
            affv.SetTextageV(v.getAgeV()+"");*/
            
        
   }    


    @FXML
    private void retourv(ActionEvent event) {
        try {
                Parent root = FXMLLoader.load(getClass().getResource("AffichageVoiture.fxml"));
                Stage stage = (Stage) cinuv.getScene().getWindow();
            stage.close();
                Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
