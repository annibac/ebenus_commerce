package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.Adresse;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;

import java.util.List;

public interface IAdresseDao {

    public List<Adresse> findAll();

    public Adresse findAdresseById(int idAdresse);

    public List<Adresse> findAdresseByType(String type);

    public Adresse findUserMainAdresse(Utilisateur user);

    public List<Adresse> findUserAllAdresses(Utilisateur user);

    public Adresse createAdresse(Adresse adresse);

    public Adresse updateAdresse(Adresse adresse);

    public boolean deleteAdresse(Adresse adresse);
}
