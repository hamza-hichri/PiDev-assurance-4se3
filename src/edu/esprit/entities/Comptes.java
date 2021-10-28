/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Lenouvo
 */
public class Comptes {
    
    private int ID;
    private String Nom;
    private String Prenom;
    private String Email;
    private String CIN;
    private String Num_Tel;

    public Comptes() {
    }

    public Comptes(int ID, String Nom, String Prenom, String Email, String CIN, String Num_Tel) {
        this.ID = ID;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.CIN = CIN;
        this.Num_Tel = Num_Tel;
    }

    public Comptes(String Nom, String Prenom, String Email, String CIN, String Num_Tel) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
        this.CIN = CIN;
        this.Num_Tel = Num_Tel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNum_Tel() {
        return Num_Tel;
    }

    public void setNum_Tel(String Num_Tel) {
        this.Num_Tel = Num_Tel;
    }

    @Override
    public String toString() {
        return "Comptes{" + "ID=" + ID + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", CIN=" + CIN + ", Num_Tel=" + Num_Tel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.ID;
        return hash;
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
        final Comptes other = (Comptes) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    
        
    }

