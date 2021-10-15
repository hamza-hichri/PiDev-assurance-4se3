/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import com.mysql.jdbc.Connection;
import edu.esprit.utils.MyConnection;
import edu.esprit.entities.Clients;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author asus
 */
public class ClientsService {
    private Connection cnx;

    public ClientsService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterClient (Clients p){
        try {
             String querry = "INSERT INTO `clients` (`nom_client`, `num_client`, `adresse_client`) VALUES ('"
                + p.getNom_client() + "', '" + p.getNum_client() + "', '" + p.getAdresse_client()+"')";
            
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(querry);
            System.out.println("Client added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerClient(Clients p) throws SQLException {
        try{
             String querry = "DELETE FROM `clients` WHERE id_client=" + p.getId_client();
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);   
          System.out.println("Client deleted !");

        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
       

    }
    
        public List<Clients> getClients() throws SQLException {
        String querry = "SELECT * FROM `clients`";
        Statement stm = (Statement) cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        List<Clients> clients = new ArrayList<>();
        while (rs.next()) {
            Clients p = new Clients();
            p.setId_client(rs.getInt(1));
            p.setNom_client(rs.getString(2));
            p.setNum_client(rs.getInt(3));
            p.setAdresse_client(rs.getString(4));
         
            clients.add(p);
        }
        return clients;
    }
        
        public void updateClient(Clients p,String nom,int num,String adresse) throws SQLException {
            
             try{
        Statement stm = cnx.createStatement();
        String query = "UPDATE clients SET nom_client= '"+nom+"', num_client= '"+num+"', adresse_client= '"+adresse+"' WHERE id_client='"+p.getId_client()+"'";
        stm.executeUpdate(query); 
        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
       
    }

    
    
    
}
