/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

import edu.esprit.entities.Clients;
import edu.esprit.entities.Individu;
import edu.esprit.services.ClientsService;
import edu.esprit.services.IndividuService;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author mezri
 */
public class Workshop extends Application
{
    private Stage ps;
    private Parent pp ;
    @Override
    public void start(Stage ps) throws IOException
{
    this.ps=ps;
    this.ps.setTitle("menu");
    pp = FXMLLoader.load(getClass().getResource("/edu/esprit/gui/Menu.fxml"));
    Scene scene=new Scene(pp);
    this.ps.setScene(scene);
    this.ps.show();
}
        /**'
    
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
