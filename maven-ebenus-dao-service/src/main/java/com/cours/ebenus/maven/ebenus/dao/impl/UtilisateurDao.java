package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.Role;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.exception.EbenusException;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IUtilisateurDao;
import com.cours.ebenus.maven.ebenus.utils.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class UtilisateurDao extends AbstractDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(UtilisateurDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();
    private static RoleDao roledao = new RoleDao();

    public UtilisateurDao() {
        super(Utilisateur.class);
    }

    private Utilisateur createUserFromDb(ResultSet rs){
        try {
            Utilisateur user = new Utilisateur();
            user.setIdUtilisateur(rs.getInt("idUtilisateur"));
            user.setCivilite(rs.getString("civilite"));
            user.setPrenom(rs.getString("prenom"));
            user.setNom(rs.getString("nom"));
            user.setIdentifiant(rs.getString("user_identifiant"));
            user.setMotPasse(rs.getString("motPasse"));
            user.setDateModification(rs.getDate("dateNaissance"));
            user.setDateCreation(rs.getDate("dateCreation"));
            user.setDateModification(rs.getDate("dateModification"));
            user.setActif(rs.getBoolean("actif"));
            user.setMarquerEffacer(rs.getBoolean("marquerEffacer"));
            user.setVersion(rs.getInt("user_version"));
//            user.setRole(roledao.findRoleById(rs.getInt("idRole")));
            Role role = new Role();
            role.setIdRole(rs.getInt("idRole_role"));
            role.setDescription(rs.getString("description"));
            role.setIdentifiant(rs.getString("role_identifiant"));
            role.setVersion(rs.getInt("role_version"));
            user.setRole(role);
            return user;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Utilisateur> findAll() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant," +
                    " r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u JOIN role r ON u.idRole = r.idRole";
            ResultSet rs = stmt.executeQuery(sql);
            List<Utilisateur> users = new ArrayList<Utilisateur>();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                users.add(user);
            }
            rs.close();
            stmt.close();
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
        try {
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant, r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u join role r ON u.idRole = r.idRole WHERE idUtilisateur = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUtilisateur);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                closeSqlResources(stmt, rs);
                return user;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Utilisateur> findUtilisateursByString(String table, String txt){
        try {
            List<Utilisateur> users = new ArrayList<Utilisateur>();
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant, r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u JOIN role r ON u.idRole = r.idRole AND " + table + " = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, txt);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                users.add(user);
            }
            closeSqlResources(stmt, rs);
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
        return findUtilisateursByString("prenom", prenom);
    }

    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
        return findUtilisateursByString("nom", nom);
    }

    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
        return findUtilisateursByString("u.identifiant", identifiant);
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdRole(int idRole) {
        try {
            List<Utilisateur> users = new ArrayList<Utilisateur>();
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant, r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u JOIN role r ON u.idRole = r.idRole AND idRole = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idRole);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                users.add(user);
            }
            closeSqlResources(stmt, rs);
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole) {
        try {
            List<Utilisateur> users = new ArrayList<Utilisateur>();
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant, r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u JOIN role r ON r.idRole = u.idRole AND r.identifiant = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, identifiantRole);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                users.add(user);
            }
            closeSqlResources(stmt, rs);
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private int generateIdUser(){
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT idUtilisateur FROM utilisateur ORDER BY idUtilisateur DESC LIMIT 0, 1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                return rs.getInt("idUtilisateur")+1;
            }
            return 1;
        } catch (SQLException se){
            return 0;
        }
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
        try {
            if (!findUtilisateurByIdentifiant(user.getIdentifiant()).isEmpty())
                throw new EbenusException(Constants.EXCEPTION_CODE_USER_ALREADY_EXIST);

            String sql = "INSERT INTO utilisateur(idRole, civilite, prenom, nom, identifiant, motPasse,dateNaissance," +
                    "dateCreation, dateModification, actif, marquerEffacer, version) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            int idUser = generateIdUser();
            user.setIdUtilisateur(idUser);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(2, user.getCivilite());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getNom());
            stmt.setString(5, user.getIdentifiant());
            stmt.setString(6, user.getMotPasse());
            if (user.getDateNaissance() != null)
                stmt.setDate(7, new java.sql.Date(user.getDateNaissance().getTime()));
            else
                stmt.setDate(7, new java.sql.Date(new java.util.Date(System.currentTimeMillis()).getTime()));
            stmt.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
            stmt.setBoolean(10, user.isActif());
            stmt.setBoolean(11, user.isMarquerEffacer());
            stmt.setInt(12, user.getVersion());
            if (user.getRole() != null)
                stmt.setInt(1, user.getRole().getIdRole());
            else
                stmt.setInt(1, 3);
            user.setDateCreation(new java.util.Date(System.currentTimeMillis()));
            user.setDateModification(new java.util.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
            return user;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
        try {
            String sql = "UPDATE utilisateur SET idRole = ? , civilite = ? , " +
                    " prenom = ? , nom = ? , identifiant = ? , motPasse = ?" +
                    " , dateNaissance = ? , dateModification = ? , actif = ?" +
                    " , marquerEffacer = ? , version = ? WHERE idUtilisateur = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(12, user.getIdUtilisateur());
            stmt.setString(2, user.getCivilite());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getNom());
            stmt.setString(5, user.getIdentifiant());
            stmt.setString(6, user.getMotPasse());
            if (user.getDateNaissance() != null)
                stmt.setDate(7, new java.sql.Date(user.getDateNaissance().getTime()));
            else
                stmt.setDate(7, new java.sql.Date(new java.util.Date(System.currentTimeMillis()).getTime()));
            stmt.setDate(8, new java.sql.Date(new java.util.Date(System.currentTimeMillis()).getTime()));
            stmt.setBoolean(9, user.isActif());
            stmt.setBoolean(10, user.isMarquerEffacer());
            stmt.setInt(11, user.getVersion());
            if (user.getRole() != null)
                stmt.setInt(1, user.getRole().getIdRole());
            else
                stmt.setInt(1, 3);
            stmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
        try {
            String sql = "DELETE FROM utilisateur where idUtilisateur = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getIdUtilisateur());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode qui vérifie les logs email / password d'un utilisateur dans la
     * base de données
     *
     * @param email L'email de l'utilisateur
     * @param password Le password de l'utilisateur
     * @return L'utilisateur qui tente de se logger si trouvé, null sinon
     */
    @Override
    public Utilisateur authenticate(String email, String password) {
        try {
            String sql = "SELECT *, u.idRole as idRole_user, r.idRole as idRole_role, u.identifiant as user_identifiant, r.identifiant as role_identifiant, u.version as user_version, r.version as role_version FROM utilisateur u JOIN role r ON r.idRole = u.idRole WHERE u.identifiant = ? AND u.motPasse= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Utilisateur user = createUserFromDb(rs);
                closeSqlResources(stmt, rs);
                return user;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

