/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.maven.ebenus.dao.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ConnectionHelper {

    private static final Log log = LogFactory.getLog(ConnectionHelper.class);
    public final static String className = ConnectionHelper.class.getName();

    public static void closeSqlResources(PreparedStatement preparedStatement, ResultSet result) {
        try{
            result.close();
            if(preparedStatement!=null)
                preparedStatement.close();
        }catch(SQLException se){
            System.out.println(se);
        }
    }
}
