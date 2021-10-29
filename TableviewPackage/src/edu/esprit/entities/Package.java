/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Objects;

/**
 *
 * @author seif
 */
public class Package {
    private int id;
    private String nom;
    private String date_sous;
    private String date_exp;
  
    private String prix;
    
    public Package() {
        
    }

    

    public Package(int id, String nom, String date_sous, String date_exp, String prix) {
        this.id = id;
        this.nom = nom;
        this.date_sous = date_sous;
        this.date_exp = date_exp;
        this.prix = prix;
    }

    public Package(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Package(String nom, String prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Package(int id) {
        this.id = id;
    }

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

    public String getDate_sous() {
        return date_sous;
    }

    public void setDate_sous(String date_sous) {
        this.date_sous = date_sous;
    }

    public String getDate_exp() {
        return date_exp;
    }

    public void setDate_exp(String date_exp) {
        this.date_exp = date_exp;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Package{" + "id=" + id + ", nom=" + nom + ", date_sous=" + date_sous + ", date_exp=" + date_exp + ", prix=" + prix + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.prix);
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
        final Package other = (Package) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        return true;
    }

}