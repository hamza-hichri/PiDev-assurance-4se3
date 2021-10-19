/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author seif
 */
public class Package {
    private int id;
    private String nom;
    private String date_sous;
    private String date_exp;

    public Package() {
        
    }

    public Package(int id, String nom, String date_sous, String date_exp) {
        this.id = id;
        this.nom = nom;
        this.date_sous = date_sous;
        this.date_exp = date_exp;
    }

    public Package(String nom) {
        this.nom = nom;
       
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

    @Override
    public String toString() {
        return "Package{" + "id=" + id + ", nom=" + nom + ", date_sous=" + date_sous + ", date_exp=" + date_exp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        return true;
    }
    
    
    
}
