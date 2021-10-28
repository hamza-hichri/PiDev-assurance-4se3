package edu.esprit.gui;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenouvo
 */
public class Record {
    private final StringProperty CIN;
    private final StringProperty Nom;
    private final StringProperty Prénom;
    private final StringProperty Num_Tel;
    private final StringProperty Email;
  
    public Record(){
        CIN = new SimpleStringProperty(this, "CIN");
        Nom = new SimpleStringProperty(this, "Nom");
        Prénom = new SimpleStringProperty(this, "Prenom");
        Num_Tel = new SimpleStringProperty(this, "Num_Tel");
        Email = new SimpleStringProperty(this, "Email");
        
    }
    public StringProperty CINProperty(){ return CIN;}
    public String getCIN(){return CIN.get();}
    public void setCIN(String newCIN){CIN.set(newCIN);}
    
    public StringProperty NomProperty(){ return Nom;}
    public String getNom(){return Nom.get();}
    public void setNom(String newNom){Nom.set(newNom);}
    
    public StringProperty PrenomProperty(){ return Prénom;}
    public String getPrenom(){return Prénom.get();}
    public void setPrenom(String newPrenom){Prénom.set(newPrenom);}
    
    public StringProperty Num_TelProperty(){ return Num_Tel;}
    public String getNum_Tel(){return Num_Tel.get();}
    public void setNum_Tel(String newNum_Tel){Num_Tel.set(newNum_Tel);}
    
    public StringProperty EmailProperty(){ return Email;}
    public String getEmail(){return Email.get();}
    public void setEmail(String newEmail){Email.set(newEmail);}
    
    
    @Override
    public String toString() {
        return String.format("%s[CIN=%s]", getCIN(),getNom(),getPrenom(),getNum_Tel(),getEmail());
       
    }
    
    
}

