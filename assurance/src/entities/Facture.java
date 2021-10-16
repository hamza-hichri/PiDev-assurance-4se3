/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author ISSAM
 */
public class Facture {
    private int id ; 
    private String nom ;
    private String prenom ; 
    private String matricule ; 
    private String code_voiture; 
    private int prix ;
    private Date date_debut ;
    private Date date_fin ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCode_voiture() {
        return code_voiture;
    }

    public void setCode_voiture(String code_voiture) {
        this.code_voiture = code_voiture;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Facture(String nom, String prenom, String matricule, String code_voiture, int prix, Date date_debut, Date date_fin) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.code_voiture = code_voiture;
        this.prix = prix;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    
    
    
}
