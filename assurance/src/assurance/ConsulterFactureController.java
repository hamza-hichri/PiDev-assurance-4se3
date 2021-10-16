/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assurance;
import CnxBD.MyConnection;
import entities.Facture;
import java.awt.Menu;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author ISSAM
 */
public class ConsulterFactureController implements Initializable {

    @FXML
    private Button btn_update;
    @FXML
    private Button back;
    
    MyConnection myc = MyConnection.getIstance();
    Connection cnx = myc.getConnection();
    PreparedStatement preparedStatement;
    private Statement ste;
    private ResultSet rs;
    private ObservableList<ObservableList> data;
    String SQL = "SELECT * from facture";
    @FXML
    private Button btn_delete;
    @FXML
    private TableView table_fact;
   
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fetColumnList();
       fetRowList();
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
        public static String vv="";

    @FXML
    private void update(ActionEvent event) {
        Object selectedItems = table_fact.getSelectionModel().getSelectedItems().get(0);
            ConsulterFactureController.vv = selectedItems.toString().split(",")[0].substring(1);
            System.out.println(ConsulterFactureController.vv);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("EditFacture.fxml"));
            Stage stage = (Stage) btn_update.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    private void delete(String ref)     throws SQLException {
        //PreparedStatement pre=(PreparedStatement) connection.preparedStatement("delete from event where id="+ref);
        
        String st = "delete from facture where id=?";
            preparedStatement = (PreparedStatement) cnx.prepareStatement(st);
            preparedStatement.setString(1, ref);
            preparedStatement.execute();
            fetRowList();
       
    }
    private void fetColumnList() {

        try {
            ResultSet rs = cnx.createStatement().executeQuery(SQL);

            //SQL FOR SELECTING ALL OF CUSTOMER
              TableColumn test = new TableColumn("test");
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
              
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                
                table_fact.getColumns().removeAll(col);
                table_fact.getColumns().addAll(col);
                
                System.out.println("Column [" + i + "]");
   
   table_fact.setRowFactory(tv -> {

    // Define our new TableRow
    TableRow<Facture> row = new TableRow<>();
    btn_delete.setOnMouseClicked((MouseEvent event) -> {
        Object selectedItems = table_fact.getSelectionModel().getSelectedItems().get(0);
        String data1 = selectedItems.toString().split(",")[0].substring(1);
        try {
            delete(data1);
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterFactureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    return row;
});
      
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
        
    }
    
    private void fetRowList() {
        data = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            rs = cnx.createStatement().executeQuery(SQL);

            while (rs.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }
            table_fact.setItems(data);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }   
    }
}
