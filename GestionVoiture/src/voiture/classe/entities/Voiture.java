/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiture.classe.entities;

/**
 *
 * @author hamza
 */
public class Voiture {
    private int idV;
    private int CinUtilisateur;
    private String marqueV;
    private String modeleV;
    private String chasisV;
    private String griseV;
    private int nbplaceV;
    private float valeurV;
    private int puissV;
    private int ageV;

    public Voiture() {
    }

    public Voiture(int idV, int CinUtilisateur, String marqueV, String modeleV, String chasisV, String griseV, int nbplaceV, float valeurV, int puissV, int ageV) {
        this.idV = idV;
        this.CinUtilisateur = CinUtilisateur;
        this.marqueV = marqueV;
        this.modeleV = modeleV;
        this.chasisV = chasisV;
        this.griseV = griseV;
        this.nbplaceV = nbplaceV;
        this.valeurV = valeurV;
        this.puissV = puissV;
        this.ageV = ageV;
    }

    public Voiture(int CinUtilisateur, String marqueV, String modeleV, String chasisV, String griseV, int nbplaceV, float valeurV, int puissV, int ageV) {
        this.CinUtilisateur = CinUtilisateur;
        this.marqueV = marqueV;
        this.modeleV = modeleV;
        this.chasisV = chasisV;
        this.griseV = griseV;
        this.nbplaceV = nbplaceV;
        this.valeurV = valeurV;
        this.puissV = puissV;
        this.ageV = ageV;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public int getCinUtilisateur() {
        return CinUtilisateur;
    }

    public void setCinUtilisateur(int CinUtilisateur) {
        this.CinUtilisateur = CinUtilisateur;
    }

    public String getMarqueV() {
        return marqueV;
    }

    public void setMarqueV(String marqueV) {
        this.marqueV = marqueV;
    }

    public String getModeleV() {
        return modeleV;
    }

    public void setModeleV(String modeleV) {
        this.modeleV = modeleV;
    }

    public String getChasisV() {
        return chasisV;
    }

    public void setChasisV(String chasisV) {
        this.chasisV = chasisV;
    }

    public String getGriseV() {
        return griseV;
    }

    public void setGriseV(String griseV) {
        this.griseV = griseV;
    }

    public int getNbplaceV() {
        return nbplaceV;
    }

    public void setNbplaceV(int nbplaceV) {
        this.nbplaceV = nbplaceV;
    }

    public float getValeurV() {
        return valeurV;
    }

    public void setValeurV(float valeurV) {
        this.valeurV = valeurV;
    }

    public int getPuissV() {
        return puissV;
    }

    public void setPuissV(int puissV) {
        this.puissV = puissV;
    }

    public int getAgeV() {
        return ageV;
    }

    public void setAgeV(int ageV) {
        this.ageV = ageV;
    }

    @Override
    public String toString() {
        return "Voiture{" + "idV=" + idV + ", CinUtilisateur=" + CinUtilisateur + ", marqueV=" + marqueV + ", modeleV=" + modeleV + ", chasisV=" + chasisV + ", griseV=" + griseV + ", nbplaceV=" + nbplaceV + ", valeurV=" + valeurV + ", puissV=" + puissV + ", ageV=" + ageV + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idV;
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
        final Voiture other = (Voiture) obj;
        if (this.idV != other.idV) {
            return false;
        }
        return true;
    }
    
    
    
}
