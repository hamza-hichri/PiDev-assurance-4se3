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
public class Offres {
    private int ID;
    private String Prix;
    private String Date_de_recep;

    public Offres() {
        
        
    }

    public Offres(int ID, String Prix, String Date_de_recep) {
        this.ID = ID;
        this.Prix = Prix;
        this.Date_de_recep = Date_de_recep;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String Prix) {
        this.Prix = Prix;
    }

    public String getDate_de_recep() {
        return Date_de_recep;
    }

    public void setDate_de_recep(String Date_de_recep) {
        this.Date_de_recep = Date_de_recep;
    }

    @Override
    public String toString() {
        return "Offres{" + "ID=" + ID + ", Prix=" + Prix + ", Date_de_recep=" + Date_de_recep + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.ID;
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
        final Offres other = (Offres) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    
}