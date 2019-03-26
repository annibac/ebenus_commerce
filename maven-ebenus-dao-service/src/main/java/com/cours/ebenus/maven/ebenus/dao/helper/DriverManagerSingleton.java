/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.maven.ebenus.dao.helper;

import com.cours.ebenus.maven.ebenus.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ElHadji
 */
public class DriverManagerSingleton {

    private static final Log log = LogFactory.getLog(DriverManagerSingleton.class);

    public final static String className = DriverManagerSingleton.class.getName();
    // Url de connexion en base de donnée
    private static final String url = Constants.DATABASE_URL;

    // Utilisateur de la base de données
    private static final String user = Constants.DATABASE_USER;

    // Mot de passe de la base de données
    private static final String password = Constants.DATABASE_PASSWORD;

    // Drivers Jdbc
    private static final String jdbcDriver = Constants.JDBC_DRIVER;

    private Connection connection = null;

    private DriverManagerSingleton() {
        try {
            Class.forName(jdbcDriver).newInstance();
            this.connection = DriverManager.getConnection(url, user, password);
        }
        catch(Exception se){
            se.printStackTrace();
        }
    }

    private static class DriverManagerSingletonHolder
    {
        private final static DriverManagerSingleton instance = new DriverManagerSingleton();
    }

    public static DriverManagerSingleton getInstance()
    {
        return DriverManagerSingleton.DriverManagerSingletonHolder.instance;
    }

    public Connection getConnectionInstance() {
        return this.connection;
    }

}
