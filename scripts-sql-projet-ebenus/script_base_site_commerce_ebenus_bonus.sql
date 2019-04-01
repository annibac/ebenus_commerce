/* Projet Bonus Ebenus : Base de données: base_site_commerce_ebenus */

SET FOREIGN_KEY_CHECKS = 0; 

CREATE TABLE ModeLivraison (
	idModeLivraison INTEGER PRIMARY KEY AUTO_INCREMENT,
	identifiant VARCHAR(100),
	nom VARCHAR(100),
	description VARCHAR(100),
	prix Double,
	delaisLivraison INTEGER,
	detailsLivraison VARCHAR(100),
	urlApiLivraison VARCHAR(100),
	utilisateurApiLivraison VARCHAR(100),
	motPasseApiLivraison VARCHAR(100),
	urlSuiviColis VARCHAR(100),
	champLibreNumero1 VARCHAR(100),
	champLibreNumero2 VARCHAR(100),
	champLibreNumero3 VARCHAR(100),
	champLibreNumero4 VARCHAR(100),
	active TINYINT(1) DEFAULT 0,
	marquerEffacer  TINYINT(1) DEFAULT 0,
	version INTEGER DEFAULT 1
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
CREATE TABLE ModePaiement (
	idModePaiement INTEGER PRIMARY KEY AUTO_INCREMENT,
	identifiant VARCHAR(100),
	nom VARCHAR(100),
	description VARCHAR(100),
	detailsPaiement VARCHAR(100),
	urlApiModePaiement VARCHAR(100),
	utilisateurApiModePaiement VARCHAR(100),
	motPasseApiModePaiement VARCHAR(100),
	champLibreNumero1 VARCHAR(100),
	champLibreNumero2 VARCHAR(100),
	champLibreNumero3 VARCHAR(100),
	champLibreNumero4 VARCHAR(100),
	active TINYINT(1) DEFAULT 0,
	marquerEffacer  TINYINT(1) DEFAULT 0,
	version INTEGER DEFAULT 1
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
 CREATE TABLE PaiementInformations (
	idPaiementInformations INTEGER PRIMARY KEY AUTO_INCREMENT,
	idCommande INTEGER NOT NULL,
	keyInfo VARCHAR(100),
	valueInfo VARCHAR(100),
	version INTEGER DEFAULT 1,
	CONSTRAINT `FK_PaiementInformations_Commande` FOREIGN KEY (idCommande) referenceS Commande (idCommande) ON DELETE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
 CREATE TABLE LivraisonInformations (
	idLivraisonInformations INTEGER PRIMARY KEY AUTO_INCREMENT,
	idArticleCommande INTEGER NOT NULL,
	keyInfo VARCHAR(100),
	valueInfo VARCHAR(100),
	version INTEGER DEFAULT 1,
	CONSTRAINT `FK_LivraisonInformations_ArticleCommande` FOREIGN KEY (idArticleCommande) referenceS ArticleCommande (idArticleCommande) ON DELETE CASCADE
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
ALTER TABLE Commande
ADD idModePaiement INTEGER,
ADD CONSTRAINT `FK_Commande_ModePaiement` FOREIGN KEY (idModePaiement) REFERENCES ModePaiement (idModePaiement);

ALTER TABLE ArticleCommande
ADD idModeLivraison INTEGER,
ADD CONSTRAINT `FK_ArticleCommande_ModeLivraison` FOREIGN KEY (idModeLivraison) REFERENCES ModeLivraison (idModeLivraison);



/*  Les modes de livraison du site  */ 

INSERT INTO ModeLivraison(identifiant,nom,description,prix,delaisLivraison,urlApiLivraison,utilisateurApiLivraison,motPasseApiLivraison,urlSuiviColis,active) VALUES ('CHRONOPOST','CHRONOPOST','Mode de livraison ChronoPost',15,1,'https://api.chronoposte.net','monUser','*&rxkmar%gg','https://suivi.chronoposte.net',1);
INSERT INTO ModeLivraison(identifiant,nom,description,prix,delaisLivraison,urlApiLivraison,utilisateurApiLivraison,motPasseApiLivraison,urlSuiviColis,active) VALUES ('DHL','DHL','Mode de livraison DHL Express',10,2,'https://api.dhl.net','monUser','*&rxkgfd%gg','https://suivi.dhl.net',1); 
INSERT INTO ModeLivraison(identifiant,nom,description,prix,delaisLivraison,urlApiLivraison,utilisateurApiLivraison,motPasseApiLivraison,urlSuiviColis,active) VALUES ('FEDEX','FEDEX','Mode de livraison Fedex',5,3,'https://api.fedex.net','monUser','*&rxkmes%gg','https://suivi.fedex.net',1);


/*  Les modes de paiement du site  */ 

INSERT INTO ModePaiement(identifiant,nom,description,detailsPaiement,active) VALUES ('CHEQUE','CHEQUE','Mode de paiement par Chèque','Adresse Chèque: Ebenus,10 rue des passeurs, 53 000 Laval-France',1);
INSERT INTO ModePaiement(identifiant,nom,description,detailsPaiement,active) VALUES ('VIREMENT','VIREMENT','Mode de paiement par virement','IBAN : FRXXXXX BBBB BGGG GGCC CCCC CCCC CKKK',1);
INSERT INTO ModePaiement(identifiant,nom,description,urlApiModePaiement,utilisateurApiModePaiement,motPasseApiModePaiement,active) VALUES ('CARTE-BANCAIRE','Carte Bancaire','Mode de paiement par carte bancaire','https://api.ingenico.net','monUser','*&rxôtessr%gg',1);





