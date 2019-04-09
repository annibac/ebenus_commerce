package com.cours.ebenus.maven.ebenus.dao.impl;

import com.cours.ebenus.maven.ebenus.dao.entities.Role;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.dao.helper.DriverManagerSingleton;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IRoleDao;
import com.cours.ebenus.maven.ebenus.dao.interfaces.IUtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.cours.ebenus.maven.ebenus.dao.helper.ConnectionHelper.closeSqlResources;

public class RoleDao extends AbstractDao<Role> implements IRoleDao {

    private static final Log log = LogFactory.getLog(RoleDao.class);
    private static Connection conn = DriverManagerSingleton.getInstance().getConnectionInstance();


    public RoleDao() {
        super(Role.class);
    }

    private Role createRoleFromDb(ResultSet rs){
        try {
            Role role = new Role();
            role.setIdRole(rs.getInt("idRole"));
            role.setIdentifiant(rs.getString("identifiant"));
            role.setDescription(rs.getString("description"));
            role.setVersion(rs.getInt("version"));
            return role;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Role> findAll() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM role";
            ResultSet rs = stmt.executeQuery(sql);
            List<Role> roles = new ArrayList<Role>();
            while(rs.next()){
                Role role = createRoleFromDb(rs);
                roles.add(role);
            }
            rs.close();
            stmt.close();
            return roles;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role findRoleById(int idRole) {
        try {
            String sql = "SELECT * FROM role WHERE idRole = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idRole);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Role role = createRoleFromDb(rs);
                closeSqlResources(stmt, rs);
                return role;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role findRoleByIdentifiant(String identifiantRole) {
        try {
            List<Role> roles = new ArrayList<Role>();
            String sql = "SELECT * FROM role WHERE identifiant = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, identifiantRole);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Role role = createRoleFromDb(rs);
                closeSqlResources(stmt, rs);
                return role;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement setAttributes(PreparedStatement stmt, Role role){
        try {
            stmt.setString(1, role.getIdentifiant());
            stmt.setString(2, role.getDescription());
            stmt.setInt(3, role.getVersion());
            return stmt;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


        @Override
    public Role createRole(Role role) {
        try {
            String sql = "INSERT INTO role(identifiant, description, version) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, role);
            stmt.executeUpdate();

            String user_sql = "SELECT * from role where identifiant= ? AND description = ? AND version = ?";
            PreparedStatement pstmt = conn.prepareStatement(user_sql);
            pstmt = setAttributes(pstmt, role);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
                role.setIdRole(rs.getInt("idRole"));
            return role;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Role updateRole(Role role) {
        try {
            String sql = "UPDATE role SET identifiant = ? , description = ? , version = ? WHERE idRole = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = setAttributes(stmt, role);
            if(stmt != null) {
                stmt.setInt(4, role.getIdRole());
                stmt.executeUpdate();
                return role;
            }
            return null;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteRole(Role role) {
        try {
            String sql = "DELETE FROM role where idRole = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, role.getIdRole());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
