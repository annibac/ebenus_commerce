package com.cours.ebenus.maven.ebenus.dao.entities;

import java.util.Objects;

public class Produit {

    private Integer idProduit;
    private String reference;
    private Double prix;
    private String nom;
    private String description;
    private Integer stock;
    private Integer active = 1;
    private Integer marquerEffacer = 0;
    private Integer version = 0;

    public Produit() {
    }

    public Produit(String ref, Double prix, String nom, String description, Integer stock, Integer active, Integer marquerEffacer, Integer version){
        this.reference = ref;
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.active = active;
        this.marquerEffacer = marquerEffacer;
        this.version = version;
    }

    public Produit(String ref, Double prix, String nom, String description, Integer stock){
        this.reference = ref;
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.active = 1;
        this.marquerEffacer = 0;
        this.version = 0;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(Integer marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
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
        if (!(o instanceof Produit)) return false;
        Produit produit = (Produit) o;
        return Objects.equals(getIdProduit(), produit.getIdProduit()) &&
                Objects.equals(getReference(), produit.getReference());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduit(), getReference());
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", active=" + active +
                ", marquerEffacer=" + marquerEffacer +
                ", version=" + version +
                '}';
    }
}
