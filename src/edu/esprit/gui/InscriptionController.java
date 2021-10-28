/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Lenouvo
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField txtCIN;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtNumTel;
    @FXML
    private TextField txtEmail;
    
    @FXML
    private TableView<Record> table;
    @FXML
    private TableColumn<Record, String> CINColumn;
    @FXML
    private TableColumn<Record, String> NomColumn;
    @FXML
    private TableColumn<Record, String> PreColumn;
     @FXML
    private TableColumn<Record, String> NumColumn;
    @FXML
    private TableColumn<Record, String> EmailColumn;
   
    
    Connection cnx;
     PreparedStatement pst;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
   
 
     public void Connect()
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
        } catch (ClassNotFoundException ex) {
          
        }catch (SQLException ex) {
                 
        
    }

 
    }
      @FXML
    void Ajouter(ActionEvent event) throws SQLException {
       
            Connect();
            String CIN = txtCIN.getText();
            String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();
            String Email = txtEmail.getText();
            String Num_Tel = txtNumTel.getText();
            
        
         
          
                if(CIN.isEmpty()||Nom.isEmpty()||Prenom.isEmpty()||Num_Tel.isEmpty()||Email.isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setHeaderText("Member");
                alert.setContentText("Champ vide");
                alert.showAndWait();
         }else{
                
       String st = "INSERT INTO records (CIN,Nom,Prenom,Num_Tel,Email) VALUES (?,?,?,?,?)";
         pst = (PreparedStatement) cnx.prepareStatement(st);
         pst.setString(1, CIN);
         pst.setString(2, Nom);
         pst.setString(3, Prenom);         
         pst.setString(5, Num_Tel);
         pst.setString(4, Email);
        
         pst.executeUpdate();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Member");
                alert.setContentText("Record Addedd Successfully");
                alert.showAndWait();
         table();
   
                }
        
        
              } 
    
    public void table()
      {
        
            ObservableList<Record> records = FXCollections.observableArrayList();
            try {
            pst = cnx.prepareStatement("select CIN,Nom,Prenom,Email,Num_Tel from records");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Record record = new Record();
                    record.setCIN(rs.getString("CIN"));
                    record.setNom(rs.getString("Nom"));
                    record.setPrenom(rs.getString("Prenom"));
                    record.setNum_Tel(rs.getString("Num_Tel"));
                    record.setEmail(rs.getString("Email"));
                    
                    records.add(record);
                }
            }
            table.setItems(records);
            CINColumn.setCellValueFactory(f -> f.getValue().CINProperty());
            NomColumn.setCellValueFactory(f -> f.getValue().NomProperty());
            PreColumn.setCellValueFactory(f -> f.getValue().PrenomProperty());
            NumColumn.setCellValueFactory(f -> f.getValue().Num_TelProperty());
            EmailColumn.setCellValueFactory(f -> f.getValue().EmailProperty());
            
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connect();
       table();
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException  {
           
        //PreparedStatement pre=(PreparedStatement) connection.preparedStatement("delete from event where id="+ref);
        
        String st = "delete from records where CIN=?";
            pst = (PreparedStatement) cnx.prepareStatement(st);
            pst.setString(1, txtCIN.getText());
            pst.execute();
            table();
    }

    @FXML
    private void Modifier(ActionEvent event) throws SQLException {
          /* String CIN = txtCIN.getText();
            String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();
            String Num_Tel = txtNumTel.getText();
            String Email = txtEmail.getText();
           
            */
        /* String st = "UPDATE  records SET  Nom = '" + txtNom.getText() + "', Prenom = " +
                txtPrenom.getText()+ ", Num_Tel = " + txtNumTel.getText() + ", Email = " + txtEmail.getText() + " WHERE CIN = " + txtCIN.getText() + "";
            /*pst = (PreparedStatement) cnx.prepareStatement(st);
            pst.setString(1, CIN);
            pst.setString(2, Nom);
            pst.setString(3, Prenom);         
            pst.setString(5, Num_Tel);
            pst.setString(4, Email);
*/
        //    pst.executeUpdate(); 
           
          /*  pst.executeUpdate();
             txtCIN.setText("");
             txtNom.setText("");
             txtPrenom.setText("");
             txtNumTel.setText("");
             txtEmail.setText("");
           */
          
          try {
            String st = "UPDATE records SET Nom = ?, Prenom = ?, Num_Tel = ?, Email = ?  WHERE CIN = '"+txtCIN.getText()+"';";
            pst = (PreparedStatement) cnx.prepareStatement(st);
          pst.setString(1, txtNom.getText());
         pst.setString(2, txtPrenom.getText());
         pst.setString(3, txtNumTel.getText());
         pst.setString(4, txtEmail.getText());


            pst.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
          
          
             table();
             
        } 
           
        

    }

   /** @FXML
    private void chercher(ActionEvent event) {
        
            String st = "select CIN,Nom,Prenom,Num_Tel,Email from records where CIN='"+txtSearch.getText()+"'";
            int m=0;
            try {
            pst = (PreparedStatement) cnx.prepareStatement(st);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txtCIN.setText(rs.getString("CIN"));
                txtNom.setText(rs.getString("Nom"));
                txtPrenom.setText(rs.getString("Prenom"));
                txtNumTel.setText(rs.getString("Num_Tel"));
                txtEmail.setText(rs.getString("Email"));
                m=1;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
            if(m==0){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Aucun compte trouvé avec CIN = "+txtSearch.getText()+"", ButtonType.OK);
                alert.showAndWait();
            }
    }*/



