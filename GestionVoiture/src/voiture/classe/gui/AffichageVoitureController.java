/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.gui;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import voiture.classe.entities.Voiture;
import voiture.classe.service.VoitureService;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class AffichageVoitureController implements Initializable {
    public static String vv="";
    Connection cnx;
     PreparedStatement pst;
    @FXML
    private TableView<Voiture> tableV;
    @FXML
    private TableColumn<Voiture, Integer> idV;
    @FXML
    private TableColumn<Voiture, Integer> CinUtilisateur;
    @FXML
    private TableColumn<Voiture, String> marqueV;
    @FXML
    private TableColumn<Voiture, String> modeleV;
    @FXML
    private TableColumn<Voiture, String> chasisV;
    @FXML
    private TableColumn<Voiture, String> griseV;
    @FXML
    private TableColumn<Voiture, Integer> nbplaceV;
    @FXML
    private TableColumn<Voiture, Float> valeurV;
    @FXML
    private TableColumn<Voiture, Integer> puissV;
    @FXML
    private TableColumn<Voiture, Integer> ageV;
    @FXML
    private Button updateV;
    @FXML
    private Button deleteV;
    @FXML
    private Button createnewvoiture;
    @FXML
    private Button rerurntomain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        voitable();
        showAllVoiture();
       
        
        
    }    
    
    public void SetTextIdv(String msg){
        this.idV.setText(msg);
    
    }
    public void SetTextCinUtilisateur(String msg){
        this.CinUtilisateur.setText(msg);
    
    }
    public void SetTextmarqueV(String msg){
        
    this.marqueV.setText(msg);
    }
    public void SetTextmodeleV(String msg){
        this.modeleV.setText(msg);
    
    }
    public void SetTextchasisV(String msg){
        
    this.chasisV.setText(msg);
    }
    public void SetTextGriseV(String msg){
        this.griseV.setText(msg);
    
    }
    public void SetTextnbplaceV(String msg){
        this.nbplaceV.setText(msg);
    
    }
    public void SetTextvaleurV(String msg){
        this.valeurV.setText(msg);
    
    }
    public void SetTextpuissV(String msg){
        this.puissV.setText(msg);
    
    }
    public void SetTextageV(String msg){
        this.ageV.setText(msg);
    
    }
     private void showAllVoiture() {
        ObservableList<Voiture> voitureList = FXCollections.observableArrayList();
        
        VoitureService us = new VoitureService();
        voitureList = us.retrieveallVoiture();
        idV.setCellValueFactory(new PropertyValueFactory<>("idV"));
        CinUtilisateur.setCellValueFactory(new PropertyValueFactory<>("CinUtilisateur"));
        marqueV.setCellValueFactory(new PropertyValueFactory<>("marqueV"));
        modeleV.setCellValueFactory(new PropertyValueFactory<>("modeleV"));
        chasisV.setCellValueFactory(new PropertyValueFactory<>("chasisV"));
        griseV.setCellValueFactory(new PropertyValueFactory<>("GriseV"));
        nbplaceV.setCellValueFactory(new PropertyValueFactory<>("nbplaceV"));
        valeurV.setCellValueFactory(new PropertyValueFactory<>("valeurV"));
        puissV.setCellValueFactory(new PropertyValueFactory<>("puissV"));
        ageV.setCellValueFactory(new PropertyValueFactory<>("ageV"));
        //tableV.setItems(voitureList);
        tableV.setItems(voitureList);
    }
     
    @FXML
    private void updateV(ActionEvent event) {
    Object selectedItems = tableV.getSelectionModel().getSelectedItems().get(0);
            System.out.println(selectedItems);
            AffichageVoitureController.vv = selectedItems.toString().split(",")[0].substring(12);
            
            System.out.println(AffichageVoitureController.vv);
            System.out.println(vv);
             
            try {
                Parent root = FXMLLoader.load(getClass().getResource("EditVoiture.fxml"));
                Stage stage = (Stage) updateV.getScene().getWindow();
            stage.close();
                Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }}

    @FXML
    private void deleteV(ActionEvent event) {
        Object selectedItems = tableV.getSelectionModel().getSelectedItems().get(0);
            System.out.println(selectedItems);
            AffichageVoitureController.vv = selectedItems.toString().split(",")[0].substring(12);
            System.out.println("hello");
            System.out.println(AffichageVoitureController.vv);
 String query = "DELETE FROM Voiture WHERE idV =" + AffichageVoitureController.vv + "";
        executeQuery(query);
        showAllVoiture();
        
    }
    public void voitable()
      {/*
        
            ObservableList<Voiture> Voiture = FXCollections.observableArrayList();
            try {
            pst = (PreparedStatement) cnx.prepareStatement("select CinUtilisateur,marqueV,modeleV,chasisV,GriseV,nbplaceV,valeurV,puissV,ageV from Voiture");
                ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Voiture v = new Voiture();
                    v.setCinUtilisateur(rs.getInt("CinUtilisateur"));
                    v.setMarqueV(rs.getString("marque"));
                    v.setModeleV(rs.getString("modeleV"));
                    v.setChasisV(rs.getString("chasisV"));
                    v.setGriseV(rs.getString("GriseV"));
                    v.setGriseV(rs.getString("GriseV")); 
                    v.setNbplaceV(rs.getInt("nbplaceV"));
                    v.setValeurV(rs.getFloat("valeurV"));
                    v.setPuissV(rs.getInt("GriseV"));
                    v.setAgeV(rs.getInt("ageV"));
                    Voiture.add(v);
                }
            }
            tableV.setItems(Voiture);
            idV.setCellValueFactory(f -> f.getValue().
            NomColumn.setCellValueFactory(f -> f.getValue().NomProperty());
            PreColumn.setCellValueFactory(f -> f.getValue().PrenomProperty());
            NumColumn.setCellValueFactory(f -> f.getValue().Num_TelProperty());
            EmailColumn.setCellValueFactory(f -> f.getValue().EmailProperty());
            
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       */}
    public java.sql.Connection getConnection(){
        java.sql.Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    private void executeQuery(String query) {
 Connection conn = (Connection) getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();    }
}

    @FXML
    private void createVoiturebtn(ActionEvent event) {
        try {
                Parent root = FXMLLoader.load(getClass().getResource("Ajout.fxml"));
                Stage stage = (Stage) updateV.getScene().getWindow();
            stage.close();
                Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }}

    @FXML
    private void retourmainpage(ActionEvent event) {
    }
}
