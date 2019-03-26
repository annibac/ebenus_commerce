package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurDao {


    public List<Utilisateur> findAll();

    public Utilisateur findUtilisateurById(int idUtilisateur);

    public List<Utilisateur> findUtilisateursByPrenom(String prenom);

    public List<Utilisateur> findUtilisateursByNom(String nom);

    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant);

    public List<Utilisateur> findUtilisateursByIdRole(int idRole);

    public List<Utilisateur> findUtilisateursByIdentifiantRole(String identifiantRole);

    public Utilisateur createUtilisateur(Utilisateur user);

    public Utilisateur updateUtilisateur(Utilisateur user);

    public boolean deleteUtilisateur(Utilisateur user);

    public Utilisateur authenticate(String email, String password);
}
