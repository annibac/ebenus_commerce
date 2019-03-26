package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.Commande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.ICommandeDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class CommandeDao extends AbstractDao<Commande> implements ICommandeDao {

    private static final Log log = LogFactory.getLog(ProduitDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public CommandeDao() {
        super(Commande.class);
    }

    private Commande createCommandeFromDb(ResultSet rs){
        try {
            Commande cmd = new Commande();
            cmd.setIdCommande(rs.getInt("idCommande"));
            cmd.setTotalCommande(rs.getDouble("totalCommande"));
            cmd.setIdUtilisateur(rs.getInt("idUtilisateur"));
            cmd.setIdAdresse(rs.getInt("idAdresse"));
            cmd.setStatut(rs.getString("statut"));
            cmd.setDateCommande(rs.getDate("dateCommande"));
            cmd.setDateModification(rs.getDate("dateModification"));
            cmd.setVersion(rs.getInt("version"));
            return cmd;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Commande> findAll(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM commande";
            ResultSet rs = stmt.executeQuery(sql);
            List<Commande> commandes = new ArrayList<Commande>();
            while(rs.next()){
                Commande cmd = createCommandeFromDb(rs);
                commandes.add(cmd);
            }
            rs.close();
            stmt.close();
            return commandes;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Commande findCommandeById(int idCommande){
        try {
            String sql = "SELECT * FROM commande WHERE idCommande = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCommande);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Commande cmd = createCommandeFromDb(rs);
                closeSqlResources(stmt, rs);
                return cmd;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Commande> findCommandeByUser(Utilisateur user){
        try {
            List<Commande> commandes = new ArrayList<Commande>();
            String sql = "SELECT * FROM commande WHERE idUtilisateur = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getIdUtilisateur());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Commande cmd = createCommandeFromDb(rs);
                commandes.add(cmd);
            }
            closeSqlResources(stmt, rs);
            return commandes;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement setAttributes(PreparedStatement stmt, Commande cmd){
        try {
            stmt.setDouble(1, cmd.getTotalCommande());
            stmt.setInt(2, cmd.getIdAdresse());
            stmt.setString(3, cmd.getStatut());
            stmt.setInt(4, cmd.getVersion());
            return stmt;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Commande createCommande(Commande commande){
        try {
            Date now_date = new java.sql.Date(commande.getDateCommande().getTime());
            String sql = "INSERT INTO commande(totalCommande, idAdresse, statut,  version, dateCommande, dateModification, idUtilisateur) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, commande);
            if (stmt != null) {
                stmt.setDate(5, now_date);
                stmt.setDate(6, now_date);
                stmt.setInt(7, commande.getIdUtilisateur());
                stmt.executeUpdate();
            }

            String user_sql = "SELECT * from commande where totalCommande = ? AND idAdresse = ? AND statut = ? AND version = ? AND dateCommande = ?  AND dateModification = ? AND idUtilisateur = ? ";
            PreparedStatement pstmt = conn.prepareStatement(user_sql);
            pstmt = setAttributes(pstmt, commande);
            if (pstmt != null) {
                pstmt.setDate(5, now_date);
                pstmt.setDate(6, now_date);
                pstmt.setInt(7, commande.getIdUtilisateur());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next())
                    commande.setIdCommande(rs.getInt("idCommande"));
                return commande;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Commande updateCommande(Commande commande){
        try {
            String sql = "UPDATE commande SET totalCommande = ? , idAdresse = ? , statut = ? , version = ? , dateModification = ?  WHERE idCommande = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, commande);
            if(stmt != null) {
                stmt.setDate(5, new java.sql.Date(commande.getDateCommande().getTime()));
                stmt.setInt(6, commande.getIdCommande());
                stmt.executeUpdate();
                return commande;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCommande(Commande commande){
        try {
            String sql = "DELETE FROM commande where idCommande = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, commande.getIdCommande());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
