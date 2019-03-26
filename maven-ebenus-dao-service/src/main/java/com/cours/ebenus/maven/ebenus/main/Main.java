package com.cours.ebenus.maven.ebenus.main;

import com.cours.ebenus.maven.ebenus.dao.entities.*;
import com.cours.ebenus.maven.ebenus.dao.impl.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class Main {

    private static final Log log = LogFactory.getLog(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UtilisateurDao userdao = new UtilisateurDao();
        RoleDao roledao = new RoleDao();
        ProduitDao pdao = new ProduitDao();
        AdresseDao adao = new AdresseDao();
        CommandeDao cdao = new CommandeDao();

//        List<Utilisateur> users = userdao.findAllUtilisateurs();
//        System.out.println("FIND ALL USERS ");
//        for(Utilisateur user : users){
//            System.out.println(user);
//        }
//        System.out.println("FIND BY ID : " + userdao.findUtilisateurById(1));
//        System.out.println("FIND BY PRENOM : " + userdao.findUtilisateursByPrenom("Nicolas"));
//        System.out.println("FIND BY PRENOM : " + userdao.findUtilisateursByPrenom("cce"));
//        System.out.println("FIND BY STRING ROLE : " + userdao.findUtilisateursByIdentifiantRole("Administrateur"));
//        Utilisateur user = new Utilisateur("mme", "Cece", "Ann", "cece@gmail.com", "pass", null);
//        user = userdao.createUtilisateur(user);
//        System.out.println(user.getIdUtilisateur());
//        user.setCivilite("Mme");
//        user.setVersion(1);
//        userdao.updateUtilisateur(user);
//        userdao.deleteUtilisateur(user);
//
//        List<Role> roles = roledao.findAll();
//        for(Role role: roles){
//            System.out.println(role);
//        }
//        System.out.println("FIND BY ID : " + roledao.findRoleById(1));
//        System.out.println("FIND BY IDENTIFIANT : " + roledao.findRoleByIdentifiant("Vendeur"));
//
//        Role role = new Role("okok", "okoko");
//        role = roledao.createRole(role);
//        System.out.println(role);
//        role.setDescription("coucou");
//        System.out.println(roledao.updateRole(role));
//        roledao.deleteRole(role);
//
//        List<Produit> produits = pdao.findAllProduits();
//        for(Produit p: produits){
//            System.out.println(p);
//        }
//
//        Produit pd = new Produit("REF-MY-PD", 25.6, "Bougie parfumée", "Petite bougie très jolie qui sent la vanille", 1000);
//        pd = pdao.createProduit(pd);
//        System.out.println(pd.getReference());
//        pd.setReference("REF-BOUGIE-PARF");
//        pd.setPrix(12.99);
//        System.out.println(pdao.updateProduit(pd));
//
//        Produit pd1 = pdao.findProduitById(36);
//        Produit pd2 = pdao.findProduitById(37);
//        Produit pd3 = pdao.findProduitById(38);
//
//        System.out.println(pdao.deleteProduit(pd));
//        System.out.println(pdao.deleteProduit(pd1));
//        System.out.println(pdao.deleteProduit(pd2));
//        System.out.println(pdao.deleteProduit(pd3));

//        List<Adresse> adresses = adao.findAll();
//        for(Adresse a: adresses){
//            System.out.println(a);
//        }

//        System.out.println("ALL ADRESSES" +adao.findUserAllAdresses(userdao.findUtilisateurById(1)));
//        System.out.println("MAIN ADRESSES" +adao.findUserMainAdresse(userdao.findUtilisateurById(1)));

//        Adresse addr = new Adresse(2, "Avenue des Marronniers", "94600", "Choisy Le Roi", "France", "P", "F", 1);
//        System.out.println(adao.createAdresse(addr));

//        Adresse addr = adao.findAdresseById(41);
//        addr.setRue("7 avenue des marronniers");
//        System.out.println(adao.updateAdresse(addr));
//        System.out.println(adao.deleteAdresse(addr));
//
//        Adresse addr1 = adao.findAdresseById(42);
//        System.out.println(adao.deleteAdresse(addr1));

//        List<Commande> commandes = cdao.findAll();
//        for(Commande cmd: commandes){
//            System.out.println(cmd);
//        }

//        System.out.println(cdao.findCommandeByUser(userdao.findUtilisateurById(12)));

//        Commande cmd = new Commande(900.0, 11, 22, "T");
//        cmd = cdao.createCommande(cmd);
//        System.out.println(cmd);
//        cmd.setTotalCommande(230.0);
//        cmd.setStatut("V");
//        cdao.updateCommande(cmd);

//        System.out.println(cdao.deleteCommande(cdao.findCommandeById(622)));
//        System.out.println(cdao.deleteCommande(cdao.findCommandeById(623)));
//        System.out.println(cdao.deleteCommande(cdao.findCommandeById(624)));
//        System.out.println(cdao.deleteCommande(cdao.findCommandeById(625)));

    }
}
