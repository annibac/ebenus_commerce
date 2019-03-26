package com.cours.ebenus.maven.ebenus.dao.entities;

import java.util.Date;
import java.util.Objects;

public class ArticleCommande {

    private Integer idArticleCommande;
    private Integer idCommande;
    private Integer idUtilisateur;
    private Integer idAdresse;
    private Integer idProduit;
    private Double totalArticleCommande;
    private String reference;
    private Integer quantite;
    private String statut;
    private Date dateModification;
    private Integer version;

    public ArticleCommande() {}

    public ArticleCommande(Integer idArticleCommande, Integer idCommande, Integer idUtilisateur, Integer idAdresse, Integer idProduit, Double totalArticleCommande, String reference, Integer quantite, String statut, Date dateModification, Integer version) {
        this.idArticleCommande = idArticleCommande;
        this.idCommande = idCommande;
        this.idUtilisateur = idUtilisateur;
        this.idAdresse = idAdresse;
        this.idProduit = idProduit;
        this.totalArticleCommande = totalArticleCommande;
        this.reference = reference;
        this.quantite = quantite;
        this.statut = statut;
        this.dateModification = dateModification;
        this.version = version;
    }

    public ArticleCommande( Integer idCommande, Integer idUtilisateur, Integer idAdresse, Integer idProduit, Double totalArticleCommande, String reference, Integer quantite, String statut){
        this(null, idCommande, idUtilisateur, idAdresse, idProduit, totalArticleCommande,reference, quantite, statut, new Date (System.currentTimeMillis()) ,0 );
    }

    public Integer getIdArticleCommande() {
        return idArticleCommande;
    }

    public void setIdArticleCommande(Integer idArticleCommande) {
        this.idArticleCommande = idArticleCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
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

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Double getTotalArticleCommande() {
        return totalArticleCommande;
    }

    public void setTotalArticleCommande(Double totalArticleCommande) {
        this.totalArticleCommande = totalArticleCommande;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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
        if (!(o instanceof ArticleCommande)) return false;
        ArticleCommande that = (ArticleCommande) o;
        return Objects.equals(idArticleCommande, that.idArticleCommande) &&
                Objects.equals(idCommande, that.idCommande) &&
                Objects.equals(idUtilisateur, that.idUtilisateur) &&
                Objects.equals(idAdresse, that.idAdresse) &&
                Objects.equals(idProduit, that.idProduit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticleCommande, idCommande, idUtilisateur, idAdresse, idProduit);
    }

    @Override
    public String toString() {
        return "ArticleCommande{" +
                "idArticleCommande=" + idArticleCommande +
                ", idCommande=" + idCommande +
                ", idUtilisateur=" + idUtilisateur +
                ", idAdresse=" + idAdresse +
                ", idProduit=" + idProduit +
                ", totalArticleCommande=" + totalArticleCommande +
                ", reference='" + reference + '\'' +
                ", quantite=" + quantite +
                ", statut='" + statut + '\'' +
                ", dateModification=" + dateModification +
                ", version=" + version +
                '}';
    }
}
