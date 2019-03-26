package com.cours.ebenus.maven.ebenus.dao.entities;

import java.util.Date;
import java.util.Objects;

public class Commande {

    private Integer idCommande;
    private Double totalCommande;
    private Integer idUtilisateur;
    private Integer idAdresse;
    private String statut;
    private Date dateCommande;
    private Date dateModification;
    private Integer version = 0;

    public Commande (){}

    public Commande(Integer idCommande, Double totalCommande, Integer idUtilisateur, Integer idAdresse, String statut, Date dateCommande, Date dateModification, Integer version){
        this.idCommande = idCommande;
        this.totalCommande = totalCommande;
        this.idUtilisateur = idUtilisateur;
        this.idAdresse = idAdresse;
        this.statut = statut;
        this.dateCommande = dateCommande;
        this.dateModification = dateModification;
        this.version = version;
    }

    public Commande(Double totalCommande, Integer idUtilisateur, Integer idAdresse, String statut) {
        this(null, totalCommande, idUtilisateur, idAdresse, statut ,new Date (System.currentTimeMillis()), new Date (System.currentTimeMillis()), 0);
    }


    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Double getTotalCommande() {
        return totalCommande;
    }

    public void setTotalCommande(Double totalCommande) {
        this.totalCommande = totalCommande;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
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
        if (!(o instanceof Commande)) return false;
        Commande commande = (Commande) o;
        return Objects.equals(getIdCommande(), commande.getIdCommande()) &&
                Objects.equals(getIdUtilisateur(), commande.getIdUtilisateur()) &&
                Objects.equals(getIdAdresse(), commande.getIdAdresse()) &&
                Objects.equals(getDateCommande(), commande.getDateCommande());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCommande(), getIdUtilisateur(), getIdAdresse(), getDateCommande());
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", totalCommande=" + totalCommande +
                ", idUtilisateur=" + idUtilisateur +
                ", idAdresse=" + idAdresse +
                ", statut='" + statut + '\'' +
                ", dateCommande=" + dateCommande +
                ", dateModification=" + dateModification +
                ", version=" + version +
                '}';
    }
}
