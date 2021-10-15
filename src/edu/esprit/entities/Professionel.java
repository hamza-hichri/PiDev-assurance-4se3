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
public class Professionel extends Clients{
  private int id_client;
    private int num_pretente;
    private int num_client;
    private String adresse_client;
    public int getId_client() {
        return id_client;
    }
    
    public Professionel( int num_client, int num_pretente, String adresse_client) {
        this.num_client=num_client;
        this.num_pretente=num_pretente;
        this.adresse_client=adresse_client;
    }


    @Override
    public String toString() {
        return "Professionel{" + "id_client=" + id_client + ", num_pretente=" + num_pretente + ", num_client=" + num_client + ", adresse_client=" + adresse_client + '}';
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getNum_pretente() {
        return num_pretente;
    }

    public void setNum_pretente(int num_pretente) {
        this.num_pretente = num_pretente;
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
       

    public Professionel( String nom_client, int num_client, String adresse_client) {
        super( nom_client, num_client, adresse_client);
    }
}
