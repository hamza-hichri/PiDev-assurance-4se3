/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author asus
 */
public class Clients {
    
        private int id_client;
    private String nom_client;
    private int num_client;
    private String adresse_client;

    public Clients() {
    }

    @Override
    public String toString() {
        return "Clients{" + "id_client=" + id_client + ", nom_client=" + nom_client + ", num_client=" + num_client + ", adresse_client=" + adresse_client + '}';
    }
    
    public Clients(int idclient, String nom_client, int num_client, String adresse_client) {
        this.id_client=idclient;
        this.nom_client = nom_client;
        this.num_client = num_client;
        this.adresse_client = adresse_client;
    }

    public Clients( String nom_client, int num_client, String adresse_client) {
        this.nom_client = nom_client;
        this.num_client = num_client;
        this.adresse_client = adresse_client;
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
     
    
}
