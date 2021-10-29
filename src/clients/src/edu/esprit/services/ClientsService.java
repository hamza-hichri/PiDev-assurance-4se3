/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import com.mysql.jdbc.Connection;
import edu.esprit.utils.MyConnection;
import edu.esprit.entities.Clients;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class ClientsService {
    private Connection cnx;

    public ClientsService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterClient (Clients p, int id){
        String querry = "INSERT INTO `clients`(`id_client`, `role`, `nom_client`, `prenom_client`, `cin`, `num_client`, `adresse_client`, `date_naissance`, `num_patente`, `registre_commerce`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
             
            
            PreparedStatement st = cnx.prepareStatement(querry);
             
            st.setInt(1, id);
            st.setString(2, p.getRole());
            st.setString(3, p.getNom_client());
            st.setString(4, p.getPrenom_client());
            st.setInt(5, p.getCin());
            st.setInt(6, p.getNum_client());
            st.setString(7, p.getAdresse_client());
            st.setDate(8, new Date(System.currentTimeMillis()));
            st.setInt(9, p.getNum_patente());
            st.setInt(10,p.getRegistre_commerce());
            
            st.executeUpdate();
            System.out.println("Client added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void updateClient (Clients p){
        String querry = "UPDATE clients SET num_client`=?, adresse_client`=?, num_patente`=? WHERE id_client`=?";
        try {
             
            
            PreparedStatement st = cnx.prepareStatement(querry);
             
            
           
           
            
          
            st.setInt(1, p.getNum_client());
            st.setString(2, p.getAdresse_client());
            st.setInt(3, p.getNum_patente());
            st.setInt(4, p.getId_client());
           
            
            int rowsUpdated=st.executeUpdate();
            if (rowsUpdated>0){
            System.out.println("Client updated !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void supprimerClient(int id ) {
              String querry = "DELETE FROM `clients` WHERE id_client= ?" ;
        try{
           
        PreparedStatement stm = cnx.prepareStatement(querry);
        stm.setInt(1, id);
        stm.executeUpdate();   
          System.out.println("Client deleted !");

        } catch (SQLException ex){
            Logger.getLogger(ClientsService.class.getName()).log(Level.SEVERE,null,ex);

        }
       

    }
    
        public List<Clients> getIndivClients() {
        String querry = "SELECT * FROM `clients` WHERE role='indiv'";
        List<Clients> clients = new ArrayList<>();
        
        try{
        
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Clients p = new Clients();
            p.setId_client(rs.getInt(1));
            p.setRole(rs.getString(2));
            p.setNom_client(rs.getString(3));
            p.setPrenom_client(rs.getString(4));
            p.setCin(rs.getInt(5));
            p.setNum_client(rs.getInt(6));
            p.setAdresse_client(rs.getString(7));
            
         
            clients.add(p);
        }
        }catch (SQLException ex){
            Logger.getLogger(ClientsService.class.getName()).log(Level.SEVERE,null,ex);
        }
        return clients;
    }
        
        
        public List<Clients> getProClients()  {
        String querry = "SELECT * FROM `clients` WHERE role='pro'";
        List<Clients> clients = new ArrayList<>();
        try{
        
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Clients p = new Clients();
            p.setId_client(rs.getInt(1));
            p.setRole(rs.getString(2));
            p.setNom_client(rs.getString(3));
            p.setPrenom_client(rs.getString(4));
            p.setCin(rs.getInt(5));
            p.setNum_client(rs.getInt(6));
            p.setAdresse_client(rs.getString(7));
          
            p.setNum_patente(rs.getInt(8));
            p.setRegistre_commerce(rs.getInt(9));
            clients.add(p);
        }}catch (SQLException ex){
            Logger.getLogger(ClientsService.class.getName()).log(Level.SEVERE,null,ex);
        }
        return clients;
    }
        
        public List<Clients> getAllClients()  {
        String querry = "SELECT * FROM `clients`";
        
        List<Clients> listc = new ArrayList<>();
        try{
        
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(querry);
        while (rs.next()) {
            Clients p = new Clients();
            p.setId_client(rs.getInt(1));
            p.setRole(rs.getString(2));
            p.setNom_client(rs.getString(3));
            p.setPrenom_client(rs.getString(4));
            p.setCin(rs.getInt(5));
            p.setNum_client(rs.getInt(6));
            p.setAdresse_client(rs.getString(7));
            
            p.setNum_patente(rs.getInt(8));
            p.setRegistre_commerce(rs.getInt(9));
            listc.add(p);
        }}catch (SQLException ex){
            Logger.getLogger(ClientsService.class.getName()).log(Level.SEVERE,null,ex);
        }
        return listc;
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
