package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.Produit;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IProduitDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class ProduitDao extends AbstractDao<Produit> implements IProduitDao {

    private static final Log log = LogFactory.getLog(ProduitDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public ProduitDao() {
        super(Produit.class);
    }

    private Produit createProduitFromDb(ResultSet rs){
        try {
            Produit produit = new Produit();
            produit.setIdProduit(rs.getInt("idProduit"));
            produit.setReference(rs.getString("reference"));
            produit.setPrix(rs.getDouble("prix"));
            produit.setNom(rs.getString("nom"));
            produit.setDescription(rs.getString("description"));
            produit.setStock(rs.getInt("stock"));
            produit.setActive(rs.getInt("active"));
            produit.setMarquerEffacer(rs.getInt("marquerEffacer"));
            produit.setVersion(rs.getInt("version"));
            return produit;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Produit> findAll(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM produit";
            ResultSet rs = stmt.executeQuery(sql);
            List<Produit> produits = new ArrayList<Produit>();
            while(rs.next()){
                Produit produit = createProduitFromDb(rs);
                produits.add(produit);
            }
            rs.close();
            stmt.close();
            return produits;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Produit findProduitById(int idProduit){
        try {
            String sql = "SELECT * FROM produit WHERE idProduit = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduit);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produit prod = createProduitFromDb(rs);
                closeSqlResources(stmt, rs);
                return prod;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Produit findProduitByReference(String reference){
        try {
            String sql = "SELECT * FROM produit WHERE reference = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, reference);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produit prod = createProduitFromDb(rs);
                closeSqlResources(stmt, rs);
                return prod;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement setAttributes(PreparedStatement stmt, Produit produit){
        try {
            stmt.setString(1, produit.getReference());
            stmt.setDouble(2, produit.getPrix());
            stmt.setString(3, produit.getNom());
            stmt.setString(4, produit.getDescription());
            stmt.setInt(5, produit.getStock());
            stmt.setInt(6, produit.getActive());
            stmt.setInt(7, produit.getMarquerEffacer());
            stmt.setInt(8, produit.getVersion());
            return stmt;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Produit createProduit(Produit produit){
        try {
            String sql = "INSERT INTO produit(reference, prix, nom, description, stock, active, marquerEffacer, version) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, produit);
            stmt.executeUpdate();

            String get_sql = "SELECT * from produit where reference= ? AND nom = ? AND description = ?";
            PreparedStatement pstmt = conn.prepareStatement(get_sql);
            pstmt.setString(1, produit.getReference());
            pstmt.setString(2, produit.getNom());
            pstmt.setString(3, produit.getDescription());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
                produit.setIdProduit(rs.getInt("idProduit"));
            return produit;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public Produit updateProduit(Produit produit){
        try {
            String sql = "UPDATE produit SET reference = ? , prix = ? , nom = ? , description = ? , stock = ? , active = ? , marquerEffacer = ? , version = ?  WHERE idProduit = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, produit);
            if(stmt != null){
                stmt.setInt(9, produit.getIdProduit());
                stmt.executeUpdate();
                return produit;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public boolean deleteProduit(Produit produit){
        try {
            String sql = "DELETE FROM produit where idProduit = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produit.getIdProduit());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
