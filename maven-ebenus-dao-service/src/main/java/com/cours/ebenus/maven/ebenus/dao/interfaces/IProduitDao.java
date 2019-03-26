package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.Produit;

import java.util.List;

public interface IProduitDao {

    public List<Produit> findAll();

    public Produit findProduitById(int idProduit);

    public Produit findProduitByReference(String reference);

    public Produit createProduit(Produit Produit);

    public Produit updateProduit(Produit Produit);

    public boolean deleteProduit(Produit Produit);
}
