package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;

import java.util.List;

public interface IArticleCommandeDao {

    public List<ArticleCommande> findAll();

    public ArticleCommande findArticleCommandeById(int idCommande);

    public List<ArticleCommande> findArticleCommandeByUser(Utilisateur user);

    public List<ArticleCommande> findArticleCommandeByReference(String reference);

    public ArticleCommande createArticleCommande(ArticleCommande articlecommande);

    public ArticleCommande updateArticleCommande(ArticleCommande articlecommande);

    public boolean deleteArticleCommande(ArticleCommande articlecommande);
}
