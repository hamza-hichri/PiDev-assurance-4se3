/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewpackage;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import edu.esprit.entities.Package;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import static java.util.Collections.list;
import java.util.List;



import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;



/**
 *
 * @author seif
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Package> table_package;
    @FXML
    private TableColumn<Package, Integer> col_id;
    @FXML
    private TableColumn<Package, String> col_nom;
    @FXML
    private TableColumn<Package, String> col_date_sous;
    @FXML
    private TableColumn<Package, String> col_date_exp;
    @FXML
    private TableColumn<Package, String> col_prix;
       @FXML
    private Label txt_nom;
    @FXML
    private Label txt_sous;
    @FXML
    private Label txt_exp;
    @FXML
    private Label txt_prix;
    
    Connection cnx;
     PreparedStatement pst;
    
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button but_cherch;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prix;
    
    
    @Override
  public void initialize(URL location, ResourceBundle resources) { 
   
   
   table_package();
}
    public void Connection() throws SQLException
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/assurance","root","");
        } catch (ClassNotFoundException ex) {
          
        }catch (SQLException ex) {
                 
        
    }

 
    }
    

    @FXML
    private void savepackage(ActionEvent event) throws SQLException {
       
       Connection();
       
            String Nom = txt_nom.getText();
            String Date_sous = txt_sous.getText();
            String Date_exp = txt_exp.getText();
            String Prix = txt_prix.getText();
            
            
        
         
          
                if(Nom.isEmpty()||Date_sous.isEmpty()||Date_exp.isEmpty()||Prix.isEmpty())
         {
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setHeaderText("Package");
                alert.setContentText("Champ vide");
                alert.showAndWait();
         }else{
                
       String st = "INSERT INTO gestion_des_package (Nom,Date_sous,Date_exp,Prix) VALUES (?,?,?,?)";
         pst = (PreparedStatement) cnx.prepareStatement(st);
         pst.setString(1, Nom);
         pst.setString(2, Date_sous);
         pst.setString(3, Date_exp);         
         pst.setString(4, Prix);
         
        
         pst.executeUpdate();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Member");
                alert.setContentText("Package Addedd Successfully");
                alert.showAndWait();
         table_package();
   
                }
        
        
              }  

    private void table_package() {
        ObservableList<Package> packages = FXCollections.observableArrayList();
            try {
            pst = cnx.prepareStatement("select Id,Nom,Date_sous,Date_exp,Prix from gestion_des_package");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    Package pack = new Package();
                    
                    pack.setId(rs.getInt("ID"));
                    pack.setNom(rs.getString("Nom"));
                    pack.setDate_sous(rs.getString("Date_sous"));
                    pack.setDate_exp(rs.getString("Date_exp"));
                    pack.setPrix(rs.getString("Prix"));
                    
                    packages.add(pack);
                }
            }
            
            
        table_package.setItems(packages);
   col_id.setCellValueFactory(new PropertyValueFactory<Package, Integer>("id"));
   col_nom.setCellValueFactory(new PropertyValueFactory<Package, String>("Nom"));
   col_date_sous.setCellValueFactory(new PropertyValueFactory<Package, String>("Date_sous")); 
   col_date_exp.setCellValueFactory(new PropertyValueFactory<Package, String>("Date_exp"));
   col_prix.setCellValueFactory(new PropertyValueFactory<Package, String>("Prix"));
            
  
         
        } catch (SQLException ex) {
           
        }
                
       
        
    }
    
  @FXML
    private void deletedpackage()throws SQLException  {
           
       
        String st = "delete from gestion_des_package where Nom =?";
            pst = (PreparedStatement) cnx.prepareStatement(st);
            pst.setString(1, txt_nom.getText());
            pst.execute();
            table_package();
    }
    
@FXML
    private void updatepackage() throws SQLException {


          /* String Nom = txt_nom.getText();
            String Date_sous = txt_sous.getText();
            String Date_exp = txt_exp.getText();
            String Prix = txt_prix.getText();
           
           
            */
        /* String st = "UPDATE  gestion_des_package SET + "', Date_sous = " +
                txt_sous.getText()+ ", Date_exp = " + txt_exp.getText() + ", Prix = " + txt_prix.getText() + " WHERE Nom = " + txt_Nom.getText() + "";
            /*pst = (PreparedStatement) cnx.prepareStatement(st);
            pst.setString(1, Nom);
         pst.setString(2, Date_sous);
         pst.setString(3, Date_exp);         
         pst.setString(4, Prix);
*/
        //    pst.executeUpdate(); 
           
          /*  pst.executeUpdate();
             txt_nom.setText("");
             txt_sous.setText("");
             txt_exp.setText("");
             txt_exp.setText("");
             txt_prix.setText("");
           */
          
          try {
            String st = "UPDATE gestion_des_package SET Date_sous = ?, Date_exp= ?, Prix = ?  WHERE Nom = '"+txt_nom.getText()+"';";
            pst = (PreparedStatement) cnx.prepareStatement(st);
         pst.setString(1, txt_nom.getText());
         pst.setString(2, txt_sous.getText());
         pst.setString(3, txt_exp.getText());
         pst.setString(4, txt_prix.getText());


            pst.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
        }
          
          
             table_package();
             
        } 
}



@FXML/**
    private void cherhcerpackage(ActionEvent event)throws SQLException {
        
         String st = "select Nom,Date_sous,Date_exp,Prix, from gestion_des_package where Nom ='"+txt_nom.getText()+"'";
            int m=0;
            try {
            pst = (PreparedStatement) cnx.prepareStatement(st);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txt_nom.setText(rs.getString("Nom"));
                txt_sous.setText(rs.getString("Date_sous"));
                txt_exp.setText(rs.getString("Date_exp"));
                txt_prix.setText(rs.getString("Prix"));
                
                m=1;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
            
    }*/
    

        

    







