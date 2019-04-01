package com.cours.ebenus.maven.ebenus.factory;

import com.cours.ebenus.maven.ebenus.dao.impl.*;
import com.cours.ebenus.maven.ebenus.dao.interfaces.*;

public class DaoFactory extends AbstractDaoFactory {

    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return new UtilisateurDao();
    }

    @Override
    public IRoleDao getRoleDao() {
        return new RoleDao();
    }

    @Override
    public IAdresseDao getAdresseDao() { return new AdresseDao();  }

    @Override
    public IArticleCommandeDao getArticleCommandeDao(){ return new ArticleCommandeDao();  }

    @Override
    public ICommandeDao getCommandeDao() { return new CommandeDao(); }

    @Override
    public IProduitDao getProduitDao(){ return new ProduitDao(); }
}
