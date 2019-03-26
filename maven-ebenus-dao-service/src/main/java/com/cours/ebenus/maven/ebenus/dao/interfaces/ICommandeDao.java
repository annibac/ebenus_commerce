package com.cours.ebenus.maven.ebenus.dao.interfaces;

import com.cours.ebenus.maven.ebenus.dao.entities.Commande;
import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;

import java.util.List;

public interface ICommandeDao {

    public List<Commande> findAll();

    public Commande findCommandeById(int idCommande);

    public List<Commande> findCommandeByUser(Utilisateur user);

    public Commande createCommande(Commande commande);

    public Commande updateCommande(Commande commande);

    public boolean deleteCommande(Commande commande);
}
