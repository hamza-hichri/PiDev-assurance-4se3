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
import java.sql.SQLException;
import java.sql.Date;


/**
 *
 * @author mezri
 */
public class Workshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ClientsService ps = new ClientsService();
        Clients p = new Clients(1,"Khaled", 11,"asef");
        Clients p1 = new Clients(2,"Khaled", 11,"asef");

        //ps.ajouterClient(p);
        //ps.ajouterClient(p1);
        //ps.supprimerClient(p);
        //System.out.println("List"+ps.getClients());
        //ps.updateClient(p1,"haya",14,"aman");
         Date date_naissance = new Date(1920, 12, 5);

        Individu in =new Individu("ekhdem  ", 0, date_naissance);
        IndividuService is = new IndividuService();
        is.ajouterIndividu(in, p1);
    }
    
}
