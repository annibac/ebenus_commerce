package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IArticleCommandeDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.util.List;

public class ArticleCommandeDao extends AbstractDao<ArticleCommande> implements IArticleCommandeDao {


    private static final Log log = LogFactory.getLog(RoleDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public ArticleCommandeDao() {
        super(ArticleCommande.class);
    }

    public List<ArticleCommande> findAll(){
        return null;
    }

    public ArticleCommande findCommandeById(int idCommande){
        return null;
    }

    public List<ArticleCommande> findCommandeByUser(Utilisateur user){
        return null;
    }

    public List<ArticleCommande> findProduitByReference(String reference){
        return null;
    }

    public ArticleCommande createCommande(ArticleCommande articlecommande){
        return null;
    }

    public ArticleCommande updateCommande(ArticleCommande articlecommande){
        return null;
    }

    public boolean deleteCommande(ArticleCommande articlecommande){
        return false;
    }

}
