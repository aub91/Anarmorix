INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22162', 'Paimpol');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('35238', 'Rennes');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22278', 'Saint-Brieuc');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22070', 'Guingamp');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22195', 'Pleubian');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22113', 'Lannion');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22168', 'Perros-Guirrec');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22127', 'Lezardrieux');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22362', 'Tréguier');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('22214', 'Pouezec');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('87085', 'Limoges');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('06088', 'Nice');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('33063', 'Bordeaux');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('17300', 'La Rochelle');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('56034', 'Carnac');
INSERT INTO `ville` (`codeInsee`, `nom`) VALUES ('74173', 'Megève');

INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (1, '22500');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (2, '35000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (3, '22000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (4, '22200');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (5, '22610');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (6, '22300');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (7, '22700');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (8, '22740');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (9, '22220');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (10, '22470');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (11, '87000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (12, '06000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (13, '33000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (14, '17000');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (15, '56340');
INSERT INTO `codepostal`(`id`, `codePostal`) VALUES (16, '74120');

INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (1, '22162');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (2, '35238');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (3, '22278');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (4, '22070');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (5, '22195');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (6, '22113');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (7, '22168');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (8, '22127');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (9, '22362');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (10,'22214');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (11,'87085');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (12,'06088');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (13,'33063');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (14,'17300');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (15,'56034');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES (16,'74173');

INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (1, '48.772258', '-3.036797', 35, 'Chemin de Kerpuns', 1, '22162');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (2, '48.774040', '-3.037591', 1, 'ZA de Kerpuns', 1, '22162');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (3, '48.779062', '3.051375', 15, 'rue Becot', 1, '22162');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (4, '48.782303', '-3.059167', 1, 'Rue Gardenn Toul Ar Verzhid', 1, '22162');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (5, '48.106397', '-1.687554', 12, 'rue Redon', 2, '35238');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (6, '48.507373', '-2.770301', 22, 'boulevard Carnot', 3, '22278');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (7, '48.565012', '-3.157254', 15, 'rue Paul Girard', 4, '22070');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (8, '48.851137', '-3.121430', 7, 'rue Saint-Andtoine', 5, '22195');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (9, '48.746868', '-3.450450', 30, 'Cote du Rest', 6, '22113');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (10, '48.809021', '-3.465362', 49, 'Rue de Toul al Lan', 7, '22168');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (11, '48.785996', '-3.108771', 4, 'Rue de Traou an Dour', 8, '22127');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (12, '48.785926', '-3.223703', 27, 'Rue Chateaubriand', 9, '22362');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (13, '48.740593', '-2.964513', 27, 'Poul Rouzigou', 10, '22214');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (14, '45.838292', '1.249233', 16, 'Rue Marc Antoine Muret', 11, '87085');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (15, '43.703757', '7.264550', 22, 'Rue d Angleterre', 12, '06088');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (16, '44.846476', '-0.597124', 71, 'Rue de Caudéran', 13, '33063');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (17, '46.159375', '-1.163280', 36, 'avenue Jeau Guiton', 14, '17300');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (18, '47.593167', '-3.066101', 36, 'chemin de Kerluir', 15, '56034');
INSERT INTO `adresse`(`id`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES (19, '45.852200', '6.632303', 3164, 'Route Edmond de Rothschild', 16, '74173');

INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', 1, '4711D', NULL, '00026', '422260208', 'Dyomedea SARL', 1, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', 2, '4711D', NULL, '00026', '422260208', 'Hobbesecration SARL', 2, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', 3, '4711D', NULL, '00026', '422260208', 'Gramsci SARL', 3, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 4, '4711D', NULL, '00026', '422260208', 'Kantbuymelove SARL', 4, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 5, '4711D', NULL, '00026', '422260208', 'Kropotkine SARL', 5, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 6, '4711D', NULL, '00026', '422260208', 'Onnyvoitgoethe SARL', 6, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 7, '4711D', NULL, '00026', '422260208', 'Célestin SARL', 15, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 8, '4711D', NULL, '00026', '422260208', 'Norbert SARL', 16, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 9, '4711D', NULL, '00026', '422260208', 'Johnny SARL', 17, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 10, '4711D', NULL, '00026', '422260208', 'Shop SARL', 18, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 11, '4711D', NULL, '00026', '422260208', 'Anatole SARL', 19, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', 12, '4711D', NULL, '00026', '422260208', 'Jennifer SARL', 14, NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('SocieteDeLivraison', 13, '4711D', NULL, '00026', '422260208', 'Michel SARL', 7, NULL);

INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (1, '2017-09-03 00:00:00', '2017-09-04 00:00:00', NULL, 1);
INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (2, '2017-09-04 00:00:00', '2017-09-05 00:00:00', NULL, 2);
INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (3, '2017-09-05 00:00:00', '2017-09-06 00:00:00', NULL, 3);

INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (NULL, 'test', NULL, NULL, NULL);

INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (1, 'Fruits', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (2, 'Charcuterie', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (3, 'Autres boissons alcoolisées', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (4, 'Fruits rouges', 1);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (5, 'Pâté/Terrine', 2);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (6, 'Bière', 3);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (7, 'Fraise', 4);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (8, 'Pâté', 5);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (9, 'Bière blonde', 6);

INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '5.50');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '10.00');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '20.00');

INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (1, NULL, 'Fraise gariguette', NULL, 1, 1);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (2, NULL, 'Pâté de campagne', NULL, 1, 1);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (3, NULL, 'Bière blonde sans gluten', NULL, 1, 1);

INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (1, 'kilogramme');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (2, 'litre');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (3, 'pièce');

INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Bouteille', 1, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Vrac', NULL, NULL, 1);

INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`) VALUES (NULL, NULL, '25.00', '50.00', NULL, 2, 1);
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`) VALUES (NULL, NULL, '10.00', '50.00', NULL, 1, 3);
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`) VALUES (NULL, NULL, '10.00', '50.00', NULL, 2, 2);

INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 1);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (2, 2);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (3, 3);

INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (1, 'Lundi', 4);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (2, 'Mardi', 4);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (3, 'Mercredi', 4);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (4, 'Jeudi', 4);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (5, 'Vendredi', 4);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (6, 'Lundi', 5);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (7, 'Mardi', 5);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (8, 'Mercredi', 5);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (9, 'Jeudi', 5);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (10, 'Vendredi', 5);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (11, 'Lundi', 6);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (12, 'Mardi', 6);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (13, 'Mercredi', 6);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (14, 'Jeudi', 6);
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (15, 'Vendredi', 6);

INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (1, '20h', '14h', 'Après-midi', 1);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (2, '19h', '8h', 'Journée', 2);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (3, '19h', '8h', 'Journée', 3);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (4, '19h', '8h', 'Journée', 4);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (5, '19h', '8h', 'Journée', 5);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (6, '19h', '8h', 'Journée', 6);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (7, '19h', '8h', 'Journée', 7);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (8, '19h', '8h', 'Journée', 8);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (9, '19h', '8h', 'Journée', 9);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (10, '19h', '8h', 'Journée', 10);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (11, '19h', '8h', 'Journée', 11);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (12, '19h', '8h', 'Journée', 12);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (13, '19h', '8h', 'Journée', 13);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (14, '19h', '8h', 'Journée', 14);
INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES (15, '12h30', '8h', 'Matin', 15);


insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (1, 1, null, '2017-09-18 00:00:00', '2017-08-17 00:00:00', null, 'jj.grandarbre@mail.fr', null, 'Grandarbre', 'aaa', 'Jean-Jacques', '0666666666', null,'grandarbre' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (2, 2, null, '2016-12-17 00:00:00', '2017-08-17 00:00:00', null, 'guillaumedemachaut@mailoo.org', null, 'Gramsci', 'aaa', 'Aubin', '0666666666', null,'Renéshinycastle' , 'Producteur', null, null, 1);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (3, 3, null, '2017-01-14 00:00:00', '2017-08-17 00:00:00', null, 'jamesosterberg@zaclys.org', null, 'Kropotkine', 'aaa', 'Alexandre', '0666666666', null,'Marbeufmiroton' , 'Producteur', null, null, 2);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (4, 4, null, '2017-02-10 00:00:00', '2017-08-17 00:00:00', null, 'loureed@gandi.org', null, 'Luxemburg', 'aaa', 'Christina', '0666666666', null,'Platontondubled' , 'Producteur', null, null, 3);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (5, 5, null, '2017-03-05 00:00:00', '2017-08-17 00:00:00', null, 'archangelocorelli@vivaldi.org', null, 'Considérant', 'aaa', 'Eloi', '0666666666', null,'Diogeneegoiste' , 'Employe', 4, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (6, 6, null, '2017-04-11 00:00:00', '2017-08-17 00:00:00', null, 'marcbolan@openmailbox.com', null, 'Blanqui', 'aaa', 'Fousseynou', '0666666666', null,'Spinozeabond' , 'Employe', 5, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (7, 7, null, '2017-05-18 00:00:00', '2017-08-17 00:00:00', null, 'sergioleone@autistici.org', null, 'Marx', 'aaa', 'Joel', '0666666666', null,'Marxisterique' , 'Employe', 6, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (8, 8, null, '2017-06-23 00:00:00', '2017-08-17 00:00:00', null, 'patrickdewaere@mailoo.org', null, 'Bakounine', 'aaa', 'Mouloud', '0666666666', null,'Onnyvoitgoethe' , 'Livreur', null, 13, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (9, 9, null, '2017-07-04 00:00:00', '2017-08-17 00:00:00', null, 'samcooke@fastmail.com', null, 'Michel', 'aaa', 'Cunégonde', '0666666666', null,'Kantbuymelove' , 'Livreur', null, 13, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (10, 10, null, '2017-07-29 00:00:00', '2017-08-17 00:00:00', null, 'carlhall@posteo.fr', null, 'Proudhon', 'aaa', 'Norbert', '0666666666', null,'Hobbesecration' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (11, 11, null, '2017-08-12 00:00:00', '2017-08-17 00:00:00', null, 'anadiplose@mailoo.org', null, 'Fourier', 'aaa', 'Athanase', '0666666666', null,'Genevoixdughetto' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (12, 12, null, '2017-08-16 00:00:00', '2017-08-17 00:00:00', null, 'épenthèse@autistici.org', null, 'Brassens', 'aaa', 'Eugène', '0666666666', null,'Keplerdelateci' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (13, 1, null, '2017-09-11 00:00:00', '2017-08-17 00:00:00', null, 'hyperchleuasme@zaclys.fr', null, 'Thoreau', 'aaa', 'Celestin', '0666666666', null,'Bergsonindaplace' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (14, 2, null, '2017-09-13 00:00:00', '2017-08-17 00:00:00', null, 'synecdoque@openmailbox.com', null, 'Bloy', 'aaa', 'Achille', '0666666666', null,'Funkstergauss' , 'Client', null, null, null);
insert into `adherent` (`id`, `id_adresse`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `id_image`, `mail`, `id_motif_desinscription`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `type_adherent`, `id_relais`, `id_societe`, `id_exploitation`) values (15, 3, null, '2017-09-18 00:00:00', '2017-08-17 00:00:00', null, 'épanorthose@ovh.fr', null, 'Scarlatti', 'aaa', 'Gustave', '0666666666', null,'Wildcatgalileo' , 'Client', null, null, null);

INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22070', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22113', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22127', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22162', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22168', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22195', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22214', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22278', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('22362', 13);
INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES ('35238', 13);

commit;
