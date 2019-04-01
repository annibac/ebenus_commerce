package com.cours.ebenus.maven.ebenus.factory;

import com.cours.ebenus.maven.ebenus.dao.impl.RoleDao;
import com.cours.ebenus.maven.ebenus.dao.impl.UtilisateurDao;
import com.cours.ebenus.maven.ebenus.dao.interfaces.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractDaoFactory {

    public static String className = AbstractDaoFactory.class.getName();
    private static final Log log = LogFactory.getLog(AbstractDaoFactory.class);

    public enum FactoryDaoType {

        JDBC_DAO_FACTORY;
    }

    public abstract IUtilisateurDao getUtilisateurDao();

    public abstract IRoleDao getRoleDao();

    public abstract IAdresseDao getAdresseDao();

    public abstract IArticleCommandeDao getArticleCommandeDao();

    public abstract ICommandeDao getCommandeDao();

    public abstract IProduitDao getProduitDao();

    /**
     * Méthode pour récupérer une factory de DAO
     *
     * @param daoType
     * @return AbstractDaoFactory
     */
    public static AbstractDaoFactory getFactory(FactoryDaoType daoType) {
        return new DaoFactory();
    }

}
