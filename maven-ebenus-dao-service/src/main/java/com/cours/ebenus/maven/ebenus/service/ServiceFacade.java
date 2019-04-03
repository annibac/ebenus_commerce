package com.cours.ebenus.maven.ebenus.service;

import com.cours.ebenus.maven.ebenus.dao.interfaces.*;
import com.cours.ebenus.maven.ebenus.factory.AbstractDaoFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceFacade implements IServiceFacade {
    private static final Log log = LogFactory.getLog(ServiceFacade.class);
    private final AbstractDaoFactory.FactoryDaoType DEFAULT_IMPLEMENTATION = AbstractDaoFactory.FactoryDaoType.JDBC_DAO_FACTORY;

    // On liste toutes les DAO : un DAO pour chaque entité (Utilisateur,Role ect ....)
    private IUtilisateurDao utilisateurDao = null;

    private IRoleDao roleDao = null;

    private IAdresseDao addrDao = null;

    private IArticleCommandeDao artCommandeDao = null;

    private ICommandeDao commandeDao = null;

    private IProduitDao produitDao = null;

    private static ServiceFacade instance = null;

    public static ServiceFacade getInstance() {
        if (instance == null)
            instance = new ServiceFacade();

        return instance;
    }

    public ServiceFacade() {
        // mettre tous les DAO
        utilisateurDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getUtilisateurDao();
        roleDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getRoleDao();
        addrDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getAdresseDao();
        artCommandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getArticleCommandeDao();
        commandeDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getCommandeDao();
        produitDao = AbstractDaoFactory.getFactory(DEFAULT_IMPLEMENTATION).getProduitDao();

    }

    public ServiceFacade(AbstractDaoFactory.FactoryDaoType daoType) {
        // mettre tous les DAO
        utilisateurDao = AbstractDaoFactory.getFactory(daoType).getUtilisateurDao();
        roleDao = AbstractDaoFactory.getFactory(daoType).getRoleDao();
    }

    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }

    @Override
    public IRoleDao getRoleDao() {
        return roleDao;
    }

    @Override
    public IAdresseDao getAdresseDao() { return addrDao; }

    @Override
    public IArticleCommandeDao getArticleCommandeDao() { return artCommandeDao; }

    @Override
    public ICommandeDao getCommandeDao() { return commandeDao; }

    @Override
    public IProduitDao getProduitDao() { return produitDao; }

}
