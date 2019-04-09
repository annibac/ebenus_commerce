package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.Adresse;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IAdresseDao;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class AdresseDao extends AbstractDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(AdresseDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public AdresseDao() {
        super(Adresse.class);
    }

    private Adresse createAdresseFromDb(ResultSet rs){
        try {
            Adresse adresse = new Adresse();
            adresse.setIdAdresse(rs.getInt("idAdresse"));
            adresse.setIdUtilisateur(rs.getInt("idUtilisateur"));
            adresse.setRue(rs.getString("rue"));
            adresse.setCodePostal(rs.getString("codePostal"));
            adresse.setVille(rs.getString("ville"));
            adresse.setPays(rs.getString("pays"));
            adresse.setStatut(rs.getString("statut"));
            adresse.setTypeAdresse(rs.getString("typeAdresse"));
            adresse.setPrincipale(rs.getInt("principale"));
            adresse.setVersion(rs.getInt("version"));
            return adresse;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Adresse> findAll(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM adresse";
            ResultSet rs = stmt.executeQuery(sql);
            List<Adresse> adresses = new ArrayList<Adresse>();
            while(rs.next()){
                Adresse adresse = createAdresseFromDb(rs);
                adresses.add(adresse);
            }
            rs.close();
            stmt.close();
            return adresses;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }    }

    @Override
    public Adresse findAdresseById(int idAdresse){
        try {
            String sql = "SELECT * FROM adresse WHERE idAdresse = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAdresse);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Adresse adresse = createAdresseFromDb(rs);
                closeSqlResources(stmt, rs);
                return adresse;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Adresse> findAdresseByType(String type){
        try {
            List<Adresse> adresses = new ArrayList<Adresse>();
            String sql = "SELECT * FROM adresse WHERE typeAdresse = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Adresse adresse = createAdresseFromDb(rs);
                adresses.add(adresse);
            }
            closeSqlResources(stmt, rs);
            return adresses;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Adresse findUserMainAdresse(Utilisateur user){
        try {
            String sql = "SELECT * FROM adresse WHERE idUtilisateur = ? AND principale=0";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getIdUtilisateur());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Adresse adresse = createAdresseFromDb(rs);
                closeSqlResources(stmt, rs);
                return adresse;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Adresse> findUserAllAdresses(Utilisateur user){
        try {
            List<Adresse> adresses = new ArrayList<Adresse>();
            String sql = "SELECT * FROM adresse WHERE idUtilisateur = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getIdUtilisateur());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Adresse adresse = createAdresseFromDb(rs);
                adresses.add(adresse);
            }
            closeSqlResources(stmt, rs);
            return adresses;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement setAttributes(PreparedStatement stmt, Adresse adresse){
        try {
            stmt.setString(1, adresse.getRue());
            stmt.setString(2, adresse.getCodePostal());
            stmt.setString(3, adresse.getVille());
            stmt.setString(4, adresse.getPays());
            stmt.setString(5, adresse.getStatut());
            stmt.setString(6, adresse.getTypeAdresse());
            stmt.setInt(7, adresse.getPrincipale());
            stmt.setInt(8, adresse.getVersion());
            return stmt;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Adresse createAdresse(Adresse adresse){
        try {
            String sql = "INSERT INTO adresse(rue, codePostal, ville, pays, statut, typeAdresse, principale, version, idUtilisateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, adresse);
            if (stmt != null) {
                stmt.setInt(9, adresse.getIdUtilisateur());
                stmt.executeUpdate();
            }

            String user_sql = "SELECT * from adresse where rue = ? AND codePostal = ? AND ville = ? AND pays = ? AND statut = ? AND typeAdresse = ? AND principale = ? AND version = ? AND idUtilisateur = ? ";
            PreparedStatement pstmt = conn.prepareStatement(user_sql);
            pstmt = setAttributes(pstmt, adresse);
            if (pstmt != null) {
                pstmt.setInt(9, adresse.getIdUtilisateur());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next())
                    adresse.setIdAdresse(rs.getInt("idAdresse"));
                return adresse;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Adresse updateAdresse(Adresse adresse){
        try {
            String sql = "UPDATE adresse SET rue = ? , codePostal = ? , ville = ? , pays = ? , statut = ? , typeAdresse = ? , principale = ? , version = ? WHERE idAdresse = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, adresse);
            if(stmt != null) {
                stmt.setInt(9, adresse.getIdAdresse());
                stmt.executeUpdate();
                return adresse;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteAdresse(Adresse adresse){
        try {
            String sql = "DELETE FROM adresse where idAdresse = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, adresse.getIdAdresse());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
