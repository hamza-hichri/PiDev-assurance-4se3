/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Clients {
    
    private int id_client;
    private String role;
    private String nom_client;
    private String prenom_client;
    private int cin;
    private int num_client;
    private String adresse_client;
    private Date date_naissance;
    private int num_patente;
    private int registre_commerce;

    public Clients() {
    }

    public Clients(int id_client, String role, String nom_client, String prenom_client, int cin, int num_client, String adresse_client, Date date_naissance, int num_patente, int registre_commerce) {
        this.id_client = id_client;
        this.role = role;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.cin = cin;
        this.num_client = num_client;
        this.adresse_client = adresse_client;
        this.date_naissance = date_naissance;
        this.num_patente = num_patente;
        this.registre_commerce = registre_commerce;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getNum_client() {
        return num_client;
    }

    public void setNum_client(int num_client) {
        this.num_client = num_client;
    }

    public String getAdresse_client() {
        return adresse_client;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresse_client = adresse_client;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getNum_patente() {
        return num_patente;
    }

    public void setNum_patente(int num_patente) {
        this.num_patente = num_patente;
    }

    public int getRegistre_commerce() {
        return registre_commerce;
    }

    public void setRegistre_commerce(int registre_commerce) {
        this.registre_commerce = registre_commerce;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clients other = (Clients) obj;
        if (this.id_client != other.id_client) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clients{" + "id_client=" + id_client + ", role=" + role + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", cin=" + cin + ", num_client=" + num_client + ", adresse_client=" + adresse_client + ", date_naissance=" + date_naissance + ", num_patente=" + num_patente + ", registre_commerce=" + registre_commerce + '}';
    }

    
    
    
    
     
    
}
