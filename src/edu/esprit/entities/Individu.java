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
public class Individu extends Clients{
    private int id_client;
    private Date date_naissance ;
    private int cin;
    private String prenom;

    public Individu( String nom_client, int num_client, String adresse_client) {
        super( nom_client, num_client, adresse_client);
    }
     public Individu( String prenom, int cin, Date date_naissance) {
        this.prenom=prenom;
        this.cin=cin;
        this.date_naissance=date_naissance;
    }

    @Override
    public String toString() {
        return "Individu{" + "id_client=" + id_client + ", date_naissance=" + date_naissance + ", cin=" + cin + ", prenom=" + prenom + '}';
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
