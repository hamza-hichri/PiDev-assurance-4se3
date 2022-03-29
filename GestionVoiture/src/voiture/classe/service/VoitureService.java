/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import voiture.classe.entities.Voiture;
import voiture.classe.utils.VoitureConnection;

/**
 *
 * @author hamza
 */
public class VoitureService {

    private Connection cnxv;
    private Statement st;
    public VoitureService() {
        cnxv = VoitureConnection.getCnx().getCnxV();
    }

    public void ajouterVoiture2(Voiture v) {
        try {
            String req = "INSERT INTO voiture(CinUtilisateur,marqueV,modeleV,GriseV,chasisV,nbplaceV,valeurV,puissV,ageV) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnxv.prepareStatement(req);
//            pst.setInt(1, v.getIdV());
            pst.setInt(1, v.getCinUtilisateur());
            pst.setString(2, v.getMarqueV());
            pst.setString(3, v.getModeleV());
            pst.setString(4, v.getChasisV());
            pst.setString(5, v.getGriseV());
            pst.setInt(6, v.getNbplaceV());
            pst.setFloat(7, v.getValeurV());
            pst.setInt(8, v.getPuissV());
            pst.setInt(9, v.getAgeV());
            pst.executeUpdate();
            System.out.println("voiture ajouter ! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   public void affichervoiture (){
        try {
        String req = "SELECT * from voiture";
        Statement st = (Statement) cnxv.createStatement();
        ResultSet rt =  st.executeQuery(req);
        while (rt.next()) {
            int id=rt.getInt("idV");
            int cinu= rt.getInt("CinUtilisateur");
            String marque = rt.getString("marqueV");
            String modele = rt.getString("modeleV");
            String chasis = rt.getString("chasisV");
            String grise = rt.getString("GriseV");
            int nbre = rt.getInt("nbplaceV");
            float valeur =rt.getInt("valeurV");
            int puiss= rt.getInt("puissV");
            int age=rt.getInt("ageV");
            System.out.println(id+"°/ "+cinu+" : "+marque+" : "+modele+" : "+chasis+" : "+grise+" : "+nbre+" : "+valeur+" : "+puiss+" : "+age);
        }
        
        }
        catch (SQLException ex) {
          System.err.println(ex.getMessage());
    }}
   public void updatevoiture(Voiture v ,int CinUtilisateur,String marqueV,String modeleV,String GriseV,String chasisV,int nbplaceV,float valeurV,int puissV,int ageV){     
             try{
        Statement st = (Statement) cnxv.createStatement();
        String query = "UPDATE voiture SET CinUtilisateur= '"+CinUtilisateur+"', marqueV= '"+marqueV+"', modeleV= '"+modeleV+"',GriseV= '"+GriseV+"',chasisV='"+chasisV+"',nbplaceV='"+nbplaceV+"',valeurV='"+valeurV+"',puissV='"+puissV+"',ageV= '"+ageV+"'WHERE idV='"+v.getIdV()+"'";
        st.executeUpdate(query); 
        } catch (SQLException e){
          System.err.println(e.getMessage());

        }
   }
   public ObservableList<Voiture> retrieveallVoiture(){
    ObservableList<Voiture> Voiture = FXCollections.observableArrayList();
   
        try {
             String sql = "select * from Voiture";
     
             st = (Statement) cnxv.prepareStatement(sql);
             ResultSet rst;
        rst = st.executeQuery(sql);
             while (rst.next()) {
                 Voiture v = new Voiture();
                 v.setIdV(rst.getInt("idV"));
                 
                 v.setCinUtilisateur(rst.getInt("CinUtilisateur"));
                 v.setMarqueV(rst.getString("marqueV"));
                 v.setModeleV(rst.getString("modeleV"));
                 v.setChasisV(rst.getString("chasisV"));
                 v.setGriseV(rst.getString("GriseV"));
                 v.setNbplaceV(rst.getInt("nbplaceV"));
                 v.setValeurV(rst.getFloat("valeurV"));
                 v.setPuissV(rst.getInt("puissV"));
                 v.setAgeV(rst.getInt("ageV"));
                 Voiture.add(v);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return  Voiture;
    
}
public void deleteVoiture(int idv){
        
            //String req = "DELETE FROM evenement WHERE (id="+id+")";
            String req = "DELETE FROM voiture WHERE voiture.idV="+idv;
            try {
            PreparedStatement st = cnxv.prepareStatement(req);
            st.executeUpdate(req);
            System.out.println("voiture deleted");
        } catch (SQLException ex) {
                System.out.println("Erreur suppression voiture");
        }
    }
}
