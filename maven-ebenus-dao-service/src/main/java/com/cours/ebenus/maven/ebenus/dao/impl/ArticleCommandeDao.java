package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.ArticleCommande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IArticleCommandeDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class ArticleCommandeDao extends AbstractDao<ArticleCommande> implements IArticleCommandeDao {


    private static final Log log = LogFactory.getLog(RoleDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public ArticleCommandeDao() {
        super(ArticleCommande.class);
    }


    private ArticleCommande createArtFromDb(ResultSet rs){
        try {
            ArticleCommande artCo = new ArticleCommande();
            artCo.setIdArticleCommande(rs.getInt("idArticleCommande"));
            artCo.setIdCommande(rs.getInt("idArticleCommande"));
            artCo.setIdUtilisateur(rs.getInt("idUtilisateur"));
            artCo.setIdAdresse(rs.getInt("idAdresse"));
            artCo.setIdProduit(rs.getInt("idProduit"));
            artCo.setTotalArticleCommande(rs.getDouble("totalArticleCommande"));
            artCo.setReference(rs.getString("reference"));
            artCo.setQuantite(rs.getInt("quantite"));
            artCo.setStatut(rs.getString("statut"));
            artCo.setDateModification(rs.getDate("dateModification"));
            artCo.setVersion(rs.getInt("version"));
            return artCo;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ArticleCommande> findAll(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM articleCommande";
            ResultSet rs = stmt.executeQuery(sql);
            List<ArticleCommande> artCos = new ArrayList<ArticleCommande>();
            while(rs.next()){
                ArticleCommande artCo = createArtFromDb(rs);
                artCos.add(artCo);
            }
            rs.close();
            stmt.close();
            return artCos;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArticleCommande findArticleCommandeById(int idCommande){
        try {
            String sql = "SELECT * FROM articleCommande WHERE idArticleCommande = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCommande);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ArticleCommande artCo = createArtFromDb(rs);
                closeSqlResources(stmt, rs);
                return artCo;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ArticleCommande> findArticleCommandeByUser(Utilisateur user){
        try {
            List<ArticleCommande> commandes = new ArrayList<ArticleCommande>();
            String sql = "SELECT * FROM articleCommande WHERE idUtilisateur = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getIdUtilisateur());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ArticleCommande cmd = createArtFromDb(rs);
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

    public List<ArticleCommande> findArticleCommandeByReference(String reference){
        try {
            String sql = "SELECT * FROM articleCommande WHERE reference = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, reference);
            ResultSet rs = stmt.executeQuery();
            List<ArticleCommande> artCos = new ArrayList<ArticleCommande>();
            while(rs.next()){
                ArticleCommande artCo = createArtFromDb(rs);
                artCos.add(artCo);
            }
            rs.close();
            stmt.close();
            return artCos;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement setAttributes(PreparedStatement stmt, ArticleCommande artCo){
        try {
            stmt.setInt(1, artCo.getIdCommande());
            stmt.setInt(2, artCo.getIdUtilisateur());
            stmt.setInt(3, artCo.getIdAdresse());
            stmt.setInt(4, artCo.getIdProduit());
            stmt.setDouble(5, artCo.getTotalArticleCommande());
            stmt.setString(6, artCo.getReference());
            stmt.setInt(7, artCo.getQuantite());
            stmt.setString(8, artCo.getStatut());
            stmt.setInt(9, artCo.getVersion());
            return stmt;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public ArticleCommande createArticleCommande(ArticleCommande articlecommande){
        try {
            String sql = "INSERT INTO articleCommande(idCommande, idUtilisateur, idAdresse, idProduit, totalArticleCommande, reference, quantite, statut, version, dateModification) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, articlecommande);
            if (stmt != null) {
                stmt.setDate(10, new java.sql.Date(articlecommande.getDateModification().getTime()));
                stmt.executeUpdate();
            }

            String get_sql = "SELECT * from articleCommande where idCommande = ? AND idUtilisateur = ? AND  idAdresse = ? AND  idProduit = ? AND  totalArticleCommande = ? AND  reference = ? AND  quantite = ? AND  statut = ? AND  version  = ? ";
            PreparedStatement pstmt = conn.prepareStatement(get_sql);
            pstmt = setAttributes(pstmt, articlecommande);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
                articlecommande.setIdArticleCommande(rs.getInt("idArticleCommande"));
            return articlecommande;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArticleCommande updateArticleCommande(ArticleCommande articlecommande){
        return null;
    }

    public boolean deleteArticleCommande(ArticleCommande articlecommande){
        return false;
    }

}
