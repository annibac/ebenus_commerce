package com.cours.ebenus.maven.ebenus.service;

import com.cours.ebenus.maven.ebenus.dao.interfaces.*;

public interface IServiceFacade {

    public IUtilisateurDao getUtilisateurDao();

    public IRoleDao getRoleDao();

    public IAdresseDao getAdresseDao();

    public IArticleCommandeDao getArticleCommande();

    public ICommandeDao getCommandeDao();

    public IProduitDao getProduitDao();
}
