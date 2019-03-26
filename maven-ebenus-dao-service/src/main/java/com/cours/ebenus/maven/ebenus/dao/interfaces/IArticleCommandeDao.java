package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;

import java.util.List;

public interface IArticleCommandeDao {

    public List<ArticleCommande> findAll();

    public ArticleCommande findCommandeById(int idCommande);

    public List<ArticleCommande> findCommandeByUser(Utilisateur user);

    public List<ArticleCommande> findProduitByReference(String reference);

    public ArticleCommande createCommande(ArticleCommande articlecommande);

    public ArticleCommande updateCommande(ArticleCommande articlecommande);

    public boolean deleteCommande(ArticleCommande articlecommande);
}
