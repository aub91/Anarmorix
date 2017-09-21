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

INSERT INTO `codepostal`(`codePostal`) VALUES (22500);
INSERT INTO `codepostal`(`codePostal`) VALUES (35000);
INSERT INTO `codepostal`(`codePostal`) VALUES (22000);
INSERT INTO `codepostal`(`codePostal`) VALUES (22200);
INSERT INTO `codepostal`(`codePostal`) VALUES (22610);
INSERT INTO `codepostal`(`codePostal`) VALUES (22300);
INSERT INTO `codepostal`(`codePostal`) VALUES (22700);
INSERT INTO `codepostal`(`codePostal`) VALUES (22740);
INSERT INTO `codepostal`(`codePostal`) VALUES (22220);
INSERT INTO `codepostal`(`codePostal`) VALUES (22470);
INSERT INTO `codepostal`(`codePostal`) VALUES (87000);
INSERT INTO `codepostal`(`codePostal`) VALUES (06000);
INSERT INTO `codepostal`(`codePostal`) VALUES (33000);
INSERT INTO `codepostal`(`codePostal`) VALUES (17000);
INSERT INTO `codepostal`(`codePostal`) VALUES (56340);
INSERT INTO `codepostal`(`codePostal`) VALUES (74120);

INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('1', '22162');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('2', '35238');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('3', '22278');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('4', '22070');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('5', '22195');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('6', '22113');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('7', '22168');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('8', '22127');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('9', '22362');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('10','22214');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('11','87085');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('12','06088');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('13','33063');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('14','17300');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('15','56034');
INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES ('16','74173');

INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.772258', '-3.036797', '35', 'Chemin de Kerpuns', '1', '22162');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.774040', '-3.037591', '1', 'ZA de Kerpuns', '1', '22162');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.779062', '3.051375', '15', 'rue Becot', '1', '22162');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.782303', '-3.059167', '1', 'Rue Gardenn Toul Ar Verzhid', '1', '22162');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.106397', '-1.687554', '12', 'rue Redon', '2', '35238');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.507373', '-2.770301', '22', 'boulevard Carnot', '3', '22278');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.565012', '-3.157254', '15', 'rue Paul Girard', '4', '22070');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.851137', '-3.121430', '7', 'rue Saint-Andtoine', '5', '22195');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.746868', '-3.450450', '30', 'Cote du Rest', '6', '22113');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.809021', '-3.465362', '49', 'Rue de Toul al Lan', '7', '22168');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.785996', '-3.108771', '4', 'Rue de Traou an Dour', '8', '22127');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.785926', '-3.223703', '27', 'Rue Chateaubriand', '9', '22362');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('48.740593', '-2.964513', '27', 'Poul Rouzigou', '10', '22214');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('45.838292', '1.249233', '16', 'Rue Marc Antoine Muret', '11', '87085');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('43.703757', '7.264550', '22', 'Rue d Angleterre', '12', '06088');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('44.846476', '-0.597124', '71', 'Rue de Caudéran', '13', '33063');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('46.159375', '-1.163280', '36', 'avenue Jeau Guiton', '14', '17300');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('47.593167', '-3.066101', '36', 'chemin de Kerluir', '15', '56034');
INSERT INTO `adresse`(`latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES ('45.852200', '6.632303', '3164', 'Route Edmond de Rothschild', '16', '74173');

INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', NULL, '4711D', NULL, '00026', '422260208', 'Dyomedea SARL', '1', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', NULL, '4711D', NULL, '00026', '422260208', 'Hobbesecration SARL', '2', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('Exploitation', NULL, '4711D', NULL, '00026', '422260208', 'Gramsci SARL', '3', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Kantbuymelove SARL', '4', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Kropotkine SARL', '5', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Onnyvoitgoethe SARL', '6', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Célestin SARL', '15', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Norbert SARL', '16', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Johnny SARL', '17', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Shop SARL', '18', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Anatole SARL', '19', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('PointRelais', NULL, '4711D', NULL, '00026', '422260208', 'Jennifer SARL', '14', NULL);
INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES ('SocieteDeLivraison', NULL, '4711D', NULL, '00026', '422260208', 'Michel SARL', '7', NULL);

INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (NULL, '2017-09-03 00:00:00', '2017-09-04 00:00:00', NULL, '1');
INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (NULL, '2017-09-04 00:00:00', '2017-09-05 00:00:00', NULL, '2');
INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES (NULL, '2017-09-05 00:00:00', '2017-09-06 00:00:00', NULL, '3');

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

INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Lundi', '4');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mardi', '4');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mercredi', '4');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Jeudi', '4');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Vendredi', '4');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Lundi', '5');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mardi', '5');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mercredi', '5');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Jeudi', '5');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Vendredi', '5');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Lundi', '6');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mardi', '6');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Mercredi', '6');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Jeudi', '6');
INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES (NULL, 'Vendredi', '6');

insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (1, null, '2017-09-18 00:00:00', '2017-08-17 00:00:00', null, 'jj.grandarbre@mail.fr', null, 'Grandarbre', 'aaa', 'Jean-Jacques', '0666666666', null,'grandarbre' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (2, null, '2016-12-17 00:00:00', '2017-08-17 00:00:00', null, 'guillaumedemachaut@mailoo.org', null, 'Gramsci', 'aaa', 'Aubin', '0666666666', null,'Renéshinycastle' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (3, null, '2017-01-14 00:00:00', '2017-08-17 00:00:00', null, 'jamesosterberg@zaclys.org', null, 'Kropotkine', 'aaa', 'Alexandre', '0666666666', null,'Marbeufmiroton' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (4, null, '2017-02-10 00:00:00', '2017-08-17 00:00:00', null, 'loureed@gandi.org', null, 'Luxemburg', 'aaa', 'Christina', '0666666666', null,'Platontondubled' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (5, null, '2017-03-05 00:00:00', '2017-08-17 00:00:00', null, 'archangelocorelli@vivaldi.org', null, 'Considérant', 'aaa', 'Eloi', '0666666666', null,'Diogeneegoiste' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (6, null, '2017-04-11 00:00:00', '2017-08-17 00:00:00', null, 'marcbolan@openmailbox.com', null, 'Blanqui', 'aaa', 'Fousseynou', '0666666666', null,'Spinozeabond' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (7, null, '2017-05-18 00:00:00', '2017-08-17 00:00:00', null, 'sergioleone@autistici.org', null, 'Marx', 'aaa', 'Joel', '0666666666', null,'Marxisterique' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (8, null, '2017-06-23 00:00:00', '2017-08-17 00:00:00', null, 'patrickdewaere@mailoo.org', null, 'Bakounine', 'aaa', 'Mouloud', '0666666666', null,'Onnyvoitgoethe' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (9, null, '2017-07-04 00:00:00', '2017-08-17 00:00:00', null, 'samcooke@fastmail.com', null, 'Michel', 'aaa', 'Cunégonde', '0666666666', null,'Kantbuymelove' , 'Professionnel');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (10, null, '2017-07-29 00:00:00', '2017-08-17 00:00:00', null, 'carlhall@posteo.fr', null, 'Proudhon', 'aaa', 'Norbert', '0666666666', null,'Hobbesecration' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (11, null, '2017-08-12 00:00:00', '2017-08-17 00:00:00', null, 'anadiplose@mailoo.org', null, 'Fourier', 'aaa', 'Athanase', '0666666666', null,'Genevoixdughetto' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (12, null, '2017-08-16 00:00:00', '2017-08-17 00:00:00', null, 'épenthèse@autistici.org', null, 'Brassens', 'aaa', 'Eugène', '0666666666', null,'Keplerdelateci' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (1, null, '2017-09-11 00:00:00', '2017-08-17 00:00:00', null, 'hyperchleuasme@zaclys.fr', null, 'Thoreau', 'aaa', 'Celestin', '0666666666', null,'Bergsonindaplace' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (2, null, '2017-09-13 00:00:00', '2017-08-17 00:00:00', null, 'synecdoque@openmailbox.com', null, 'Bloy', 'aaa', 'Achille', '0666666666', null,'Funkstergauss' , 'Client');
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (3, null, '2017-09-18 00:00:00', '2017-08-17 00:00:00', null, 'épanorthose@ovh.fr', null, 'Scarlatti', 'aaa', 'Gustave', '0666666666', null,'Wildcatgalileo' , 'Client');

