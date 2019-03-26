package com.cours.ebenus.maven.ebenus.dao.entities;

import java.util.Objects;

public class Adresse {
    private Integer idAdresse;
    private Integer idUtilisateur;
    private String rue;
    private String codePostal;
    private String ville;
    private String pays;
    private String statut = "P";
    private String typeAdresse;
    private Integer principale;
    private Integer version = 0;

    public Adresse(){

    }

    public Adresse(Integer idUtilisateur, String rue, String codePostal, String ville, String pays, String statut, String typeAdresse, Integer principale){
        this.idUtilisateur = idUtilisateur;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.statut = statut;
        this.typeAdresse = typeAdresse;
        this.principale = principale;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTypeAdresse() {
        return typeAdresse;
    }

    public void setTypeAdresse(String typeAdresse) {
        this.typeAdresse = typeAdresse;
    }

    public Integer getPrincipale() {
        return principale;
    }

    public void setPrincipale(Integer principale) {
        this.principale = principale;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse)) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(getIdAdresse(), adresse.getIdAdresse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAdresse());
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "idAdresse=" + idAdresse +
                ", idUtilisateur=" + idUtilisateur +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", statut='" + statut + '\'' +
                ", typeAdresse='" + typeAdresse + '\'' +
                ", principale=" + principale +
                '}';
    }
}
