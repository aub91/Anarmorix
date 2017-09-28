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

INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (1, 'resources/img/Fraise.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (2, 'resources/img/Homard.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (3, 'resources/img/Huitre.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (4, 'resources/img/Andouille_de_guemene.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (5, 'resources/img/artichauts.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (6, 'resources/img/betterave.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (7, 'resources/img/beurre.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (8, 'resources/img/biere.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (9, 'resources/img/carotte.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (10, 'resources/img/chou_fleur.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (11, 'resources/img/chou_romanesco.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (12, 'resources/img/ciboulette.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (13, 'resources/img/Cidre.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (14, 'resources/img/creme-fraiche.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (15, 'resources/img/crevettes grises.jpeg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (16, 'resources/img/crevettes roses.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (17, 'resources/img/Cuisse de poulet.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (18, 'resources/img/Echalotte.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (19, 'resources/img/echine-de-porc.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (20, 'resources/img/granny-smith.jpeg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (21, 'resources/img/Jambon-blanc.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (22, 'resources/img/Jus-de-pomme.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (23, 'resources/img/laitue-verte.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (24, 'resources/img/Maquereaux.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (25, 'resources/img/Moules.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (26, 'resources/img/Nectar-de-poire.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (27, 'resources/img/patebreton.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (28, 'resources/img/Perle-noire.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (29, 'resources/img/persil.jpeg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (30, 'resources/img/poireaux.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (31, 'resources/img/poitrine-de-porc.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (32, 'resources/img/Pomme-de-terre.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (33, 'resources/img/pomme-de-terre rouge.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (34, 'resources/img/pomme-golden.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (35, 'resources/img/poulet.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (36, 'resources/img/saucisson-sec-artisanal.jpg.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (37, 'resources/img/tomates.jpeg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (38, 'resources/img/tourteau.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (39, 'resources/img/viande de boeuf.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (40, 'resources/img/Yaourt.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (41, 'resources/img/Asperge.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (42, 'resources/img/coriandre.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (43, 'resources/img/filetsdesole.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (44, 'resources/img/poivre-de-malabar.jpg', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (45, 'resources/img/seldeguerande.png', NULL, NULL, NULL);
INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (46, 'resources/img/vinblanc.jpg', NULL, NULL, NULL);




<<<<<<< HEAD
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (1, 'Fruits, légumes et épicerie', NULL);
=======
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (1, 'Fruits, l�gumes et �picerie', NULL);
>>>>>>> aubin
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (2, 'Viandes, charcuteries et produits de la mer', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (3, 'Produits laitiers', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (4, 'Boissons', NULL);



INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (5, 'Fruits', 1);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (6, 'Légumes', 1);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (7, 'Epicerie', 1);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (8, 'Viandes', 2);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (9, 'Charcuterie', 2);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (10, 'produits de la mer', 2);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (11, 'fromages', 3);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (12, 'laits', 3);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (13, 'crèmes, beurres et yaourts', 3);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (14, 'vins', 4);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (15, 'autres boissons alcoolisées', 4);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (16, 'boissons non alcoolisées', 4);



INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (17, 'Fruits à pépins', 5);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (18, 'Fruits rouges', 5);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (19, 'Légumes-racines', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (20, 'Légumes-fruits', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (21, 'Légumes-feuilles', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (22, 'Légumes-tubercules', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (23, 'Légumes-bulbes', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (24, 'Légumes-tiges', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (25, 'Légumes-fleurs', 6);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (26, 'Viande rouge', 8);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (27, 'Viande blanche', 8);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (28, 'Saucisses/Jambon', 9);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (29, 'Beurres', 13);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (30, 'Crèmes', 13);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (31, 'Yaourts', 13);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (32, 'Bières', 15);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (33, 'Cidres', 15);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (34, 'Jus de fruits', 16);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (35, 'Fruits de mer', 10);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (36, 'Poissons', 10);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (37, 'Vins blancs', 14);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (38, 'Pâté/Terrine', 9);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (39, 'Epices', 7);




INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (40, 'Pomme', 17);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (41, 'Fraise', 18);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (42, 'Betterave', 19);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (43, 'Artichaut', 24);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (44, 'Carotte', 19);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (45, 'Chou-Fleur', 25);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (46, 'Chou romanesco', 25);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (47, 'Ciboulette', 24);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (48, 'Oignons et échalotes', 23);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (49, 'Tomate', 20);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (50, 'Laitue verte', 21);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (51, 'Persil', 21);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (52, 'Poireau', 24);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (53, 'Pommes de terre', 22);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (54, 'Pommes de terre rouge', 22);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (55, 'Andouille', 28);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (56, 'Crustacés', 35);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (57, 'Mollusques', 35);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (58, 'Beurre demi-sel', 29);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (59, 'Cidres bruts', 33);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (60, 'Bières blondes', 32);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (61, 'Crème fraîche', 30);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (62, 'Crevettes grises', 35);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (63, 'Crevettes roses', 35);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (64, 'Viande de boeuf', 26);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (65, 'Viande de porc', 27);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (66, 'Volaille', 27);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (67, 'Jambon', 28);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (68, 'Jus', 34);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (69, 'Nectar', 34);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (70, 'Salade', 21);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (71, 'Poissons gras', 36);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (72, 'Pâté', 38);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (73, 'Oeufs de poissons', 36);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (74, 'Yaourts aux fruits', 31);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (75, 'Asperges', 25);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (76, 'Coriandres', 39);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (77, 'Poissons blancs', 36);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (78, 'Poivre', 39);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (79, 'Sel', 39);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (80, 'Vins blancs secs', 37);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (81, 'Saucissons', 28);


INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '5.50');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '10.00');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (NULL, '20.00');


INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (1, 'kilogramme');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (2, 'grammes');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (3, 'litre');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (4, 'pièce');

INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Bouteille', 1, NULL, 3);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Bouteille', 0.75, NULL, 3);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Bouteille', 0.5, NULL, 3);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Vrac', 500, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Vrac', 100, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Barquette', 250, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Barquette', 500, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Unité', 1, NULL, 4);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Botte', 250, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Bourriche', 1, NULL, 1);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Tranche', 1, NULL, 4);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Pot', 500, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Boîte', 100, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (NULL, 'Pot', 100, NULL, 2);





INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (1, NULL, 'Fraise gariguette', NULL, 1, 1, 41);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (2, NULL, 'Homard', NULL, 2, 1, 56);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (3, NULL, 'Huître', NULL, 3, 1, 57);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (4, NULL, 'Andouille de Guéméné', NULL, 4, 1, 55);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (5, NULL, 'Artichaut', NULL, 5, 1, 43);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (6, NULL, 'Betterave', NULL, 6, 1, 42);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (7, NULL, 'Beurre au sel de Guérande', NULL, 7, 1, 58);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (8, NULL, 'Bière blonde', NULL, 8, 1, 60);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (9, NULL, 'Carotte', NULL, 9, 1, 44);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (10, NULL, 'Chou-fleur', NULL, 10, 1, 45);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (11, NULL, 'Chou romanesco', NULL, 11, 1, 46);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (12, NULL, 'Ciboulette', NULL, 12, 1, 47);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (13, NULL, 'Cidre', NULL, 13, 1, 59);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (14, NULL, 'Crème fraîche', NULL, 14, 1, 61);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (15, NULL, 'Crevettes grises', NULL, 15, 1, 62);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (16, NULL, 'Crevettes roses', NULL, 16, 1, 63);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (17, NULL, 'Cuisses de poulet', NULL, 17, 1, 66);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (18, NULL, 'Echalotes', NULL, 18, 1, 48);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (19, NULL, 'Echine de porc', NULL, 19, 1, 65);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (20, NULL, 'Pommes Granny-Smith', NULL, 20, 1, 40);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (21, NULL, 'Jambon blanc', NULL, 21, 1, 67);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (22, NULL, 'Jus de pomme', NULL, 22, 1, 68);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (23, NULL, 'Laitue verte', NULL, 23, 1, 50);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (24, NULL, 'Maquereaux', NULL, 24, 1, 71);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (25, NULL, 'Moules', NULL, 25, 1, 57);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (26, NULL, 'Nectar de Poire', NULL, 26, 1, 69);
<<<<<<< HEAD
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (27, NULL, 'Pâté de campagne', NULL, 27, 1, 72);
=======
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (27, NULL, 'P�t� de campagne', NULL, 27, 1, 72);
>>>>>>> aubin
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (28, NULL, 'Persil', NULL, 29, 1, 51);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (29, NULL, 'Poireaux', NULL, 30, 1, 52);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (30, NULL, 'Poitrine de porc', NULL, 31, 1, 65);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (31, NULL, 'Pommes de terre', NULL, 32, 1, 53);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (32, NULL, 'Pommes de terre rouges', NULL, 33, 1, 54);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (33, NULL, 'Pommes golden', NULL, 34, 1, 40);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (34, NULL, 'Saucisson sec artisanal', NULL, 36, 1, 81);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (35, NULL, 'Tomate', NULL, 37, 1, 49);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (36, NULL, 'Tourteau', NULL, 38, 1, 56);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (37, NULL, 'Jarret de boeuf', NULL, 39, 1, 64);
<<<<<<< HEAD
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (38, NULL, 'Yaourt à la chataîgne', NULL, 40, 1, 74);
=======
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (38, NULL, 'Yaourt � la chata�gne', NULL, 40, 1, 74);
>>>>>>> aubin
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (39, NULL, 'Asperge du Blayais', NULL, 41, 1, 75);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (40, NULL, 'Coriandre', NULL, 42, 1, 76);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (41, NULL, 'Filets de sole', NULL, 43, 1, 77);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (42, NULL, 'Poivre gris', NULL, 44, 1, 78);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (43, NULL, 'Sel de Guerande', NULL, 45, 1, 79);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`, `id_categorie`) VALUES (44, NULL, 'Vin blanc Gramsci', NULL, 46, 1, 80);



INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (1, NULL, '3.00', '50.00', 1, 7, 1, 'Les fraises Gramsci, presque aussi rouges que le patron');
<<<<<<< HEAD
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (2, NULL, '25.00', '50.00', 2, 8, 2, 'Des homards sauvages avec une chair de caractère');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (3, NULL, '20.00', '50.00', 3, 10, 3, 'Des huîtres en direct de la baie de Saint-Brieuc');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (4, NULL, '25.00', '50.00', 4, 5, 4, 'Contient suffisament de calories pour résoudre la faim dans le monde');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (5, NULL, '3.00', '50.00', 5, 8, 5, 'Un coeur délicieusement fondant');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (6, NULL, '2.00', '50.00', 6, 5, 6, 'Une betterave du terroir');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (7, NULL, '4.00', '50.00', 7, 6, 7, 'Si ce n''est pas du beurre salé, ce n''est pas du beurre tout court');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (8, NULL, '1.50', '50.00', 8, 3, 8, 'Une vraie blonde, comme la femme du patron');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (9, NULL, '3.00', '50.00', 9, 5, 9, 'On court tous après la carotte Gramsci');
=======
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (2, NULL, '25.00', '50.00', 2, 8, 2, 'Des homards sauvages avec une chair de caract�re');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (3, NULL, '20.00', '50.00', 3, 10, 3, 'Des hu�tres en direct de la baie de Saint-Brieuc');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (4, NULL, '25.00', '50.00', 4, 5, 4, 'Contient suffisament de calories pour r�soudre la faim dans le monde');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (5, NULL, '3.00', '50.00', 5, 8, 5, 'Un coeur d�licieusement fondant');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (6, NULL, '2.00', '50.00', 6, 5, 6, 'Une betterave du terroir');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (7, NULL, '4.00', '50.00', 7, 6, 7, 'Si ce n''est pas du beurre sal�, ce n''est pas du beurre tout court');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (8, NULL, '1.50', '50.00', 8, 3, 8, 'Une vraie blonde, comme la femme du patron');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (9, NULL, '3.00', '50.00', 9, 5, 9, 'On court tous apr�s la carotte Gramsci');
>>>>>>> aubin
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (10, NULL, '2.00', '50.00', 10, 8, 10, 'Une explosion florale pour vos papilles');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (11, NULL, '3.00', '50.00', 11, 8, 11, 'Une explosion florale pour vos papilles');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (12, NULL, '2.50', '50.00', 12, 5, 12, 'Un Gramsci, ciboulette');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (13, NULL, '2.00', '50.00', 13, 2, 13, 'La pomme dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (14, NULL, '5.00', '50.00', 14, 12, 14, 'Le gras, c''est la vie');
<<<<<<< HEAD
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (15, NULL, '9.00', '50.00', 15, 5, 15, 'Des crevettes sauvages avec une chair de caractère');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (16, NULL, '11.00', '50.00', 16, 5, 16, 'Des crevettes sauvages avec une chair de caractère');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (17, NULL, '7.00', '50.00', 17, 8, 17, 'Elevé au grain armoricain');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (18, NULL, '3.00', '50.00', 18, 5, 18, 'Un bulbe de saveurs');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (19, NULL, '8.00', '50.00', 19, 5, 19, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (20, NULL, '3.00', '50.00', 20, 5, 20, 'Un gout délicieusement acidulé');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (21, NULL, '8.00', '50.00', 21, 11, 21, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (22, NULL, '1.00', '50.00', 22, 1, 22, 'La pomme dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (23, NULL, '4.00', '50.00', 23, 8, 23, 'Laitue verte ? Moi j''suis rouge !');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (24, NULL, '6.00', '50.00', 24, 5, 24, 'Du mac étincelant');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (25, NULL, '8.00', '50.00', 25, 10, 25, 'S''accompagnent très bien de poireaux');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (26, NULL, '3.00', '50.00', 26, 1, 26, 'La poire dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (27, NULL, '5.00', '50.00', 27, 12, 27, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (28, NULL, '5.00', '50.00', 29, 5, 28, 'Une bouquet aromatique exquis');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (29, NULL, '7.00', '50.00', 30, 5, 29, 'Pour un kilo de poireaux acheté, un kilo de moules offertes');
=======
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (15, NULL, '9.00', '50.00', 15, 5, 15, 'Des crevettes sauvages avec une chair de caract�re');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (16, NULL, '11.00', '50.00', 16, 5, 16, 'Des crevettes sauvages avec une chair de caract�re');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (17, NULL, '7.00', '50.00', 17, 8, 17, 'Elev� au grain armoricain');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (18, NULL, '3.00', '50.00', 18, 5, 18, 'Un bulbe de saveurs');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (19, NULL, '8.00', '50.00', 19, 5, 19, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (20, NULL, '3.00', '50.00', 20, 5, 20, 'Un gout d�licieusement acidul�');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (21, NULL, '8.00', '50.00', 21, 11, 21, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (22, NULL, '1.00', '50.00', 22, 1, 22, 'La pomme dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (23, NULL, '4.00', '50.00', 23, 8, 23, 'Laitue verte ? Moi j''suis rouge !');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (24, NULL, '6.00', '50.00', 24, 5, 24, 'Du mac �tincelant');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (25, NULL, '8.00', '50.00', 25, 10, 25, 'S''accompagnent tr�s bien de poireaux');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (26, NULL, '3.00', '50.00', 26, 1, 26, 'La poire dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (27, NULL, '5.00', '50.00', 27, 12, 27, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (28, NULL, '5.00', '50.00', 29, 5, 28, 'Une bouquet aromatique exquis');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (29, NULL, '7.00', '50.00', 30, 5, 29, 'Pour un kilo de poireaux achet�, un kilo de moules offertes');
>>>>>>> aubin
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (30, NULL, '6.00', '50.00', 31, 5, 30, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (31, NULL, '2.00', '50.00', 32, 5, 31, 'Cent patates !');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (32, NULL, '2.50', '50.00', 33, 5, 32, 'Cent patates ! version communiste');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (33, NULL, '4.00', '50.00', 34, 5, 33, 'La pomme dans ta face');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (34, NULL, '12.00', '50.00', 36, 8, 34, 'Tout est bon dans le cochon, surtout quand il est breton');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (35, NULL, '3.00', '50.00', 37, 5, 35, 'Les tomates Gramsci, presque aussi rouges que le patron');
<<<<<<< HEAD
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (36, NULL, '9.00', '50.00', 38, 5, 36, 'Des crabes sauvages avec une chair de caractère');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (37, NULL, '8.00', '50.00', 39, 5, 37, 'Un boeuf du terroir armoricain');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (38, NULL, '1.00', '50.00', 40, 14, 38, 'Des chataîgnes du terroir');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (39, NULL, '7.00', '50.00', 41, 9, 39, 'Pour un kilo d''asperges achetées, un kilo de moules offertes');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (40, NULL, '6.00', '50.00', 42, 5, 40, 'Une explosion aromatique');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (41, NULL, '11.00', '50.00', 43, 8, 41, 'Des filets bien raclés de sole');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (42, NULL, '4.00', '50.00', 44, 13, 42, 'Une explosion aromatique');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (43, NULL, '3.00', '50.00', 45, 13, 43, 'La fine fleur du salé');
=======
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (36, NULL, '9.00', '50.00', 38, 5, 36, 'Des crabes sauvages avec une chair de caract�re');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (37, NULL, '8.00', '50.00', 39, 5, 37, 'Un boeuf du terroir armoricain');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (38, NULL, '1.00', '50.00', 40, 14, 38, 'Des chata�gnes du terroir');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (39, NULL, '7.00', '50.00', 41, 9, 39, 'Pour un kilo d''asperges achet�es, un kilo de moules offertes');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (40, NULL, '6.00', '50.00', 42, 5, 40, 'Une explosion aromatique');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (41, NULL, '11.00', '50.00', 43, 8, 41, 'Des filets bien racl�s de sole');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (42, NULL, '4.00', '50.00', 44, 13, 42, 'Une explosion aromatique');
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (43, NULL, '3.00', '50.00', 45, 13, 43, 'La fine fleur du sal�');
>>>>>>> aubin
INSERT INTO `produit` (`id`, `dateProduction`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`, `descriptif`) VALUES (44, NULL, '9.00', '50.00', 46, 2, 44, 'Le vin est blanc, mais rassurez-vous, le patron est bien rouge');


INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 1);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (2, 2);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (3, 3);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 4);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 5);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 6);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 7);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 8);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 9);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 10);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 11);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 12);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 13);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 14);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 15);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 16);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 17);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 18);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 19);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 20);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 21);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 22);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 23);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 24);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 25);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 26);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 27);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 28);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 29);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 30);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 31);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 32);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 33);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 34);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 35);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 36);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 37);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 38);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 39);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 40);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 41);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 42);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 43);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 44);
INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES (1, 45);




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

INSERT INTO `tournee` (`id`, `dateHeureDebut`, `dateHeureFin`, `id_livreur`, `id_societe`) VALUES (1, '2017-09-10 09:00:00', '2017-09-10 12:00:00', 8, 13);
INSERT INTO `tournee` (`id`, `dateHeureDebut`, `dateHeureFin`, `id_livreur`, `id_societe`) VALUES (2, null, null, null, 13);
INSERT INTO `commande` (`id`, `codeValidation`, `dateCreation`, `dateValidation`, `statut`, `id_client`, `id_relais`) VALUES (1, '12345', '2017-09-07 00:00:00', '2017-09-08 00:00:00', 'TERMINEE', 1, 4);
INSERT INTO `commande` (`id`, `codeValidation`, `dateCreation`, `dateValidation`, `statut`, `id_client`, `id_relais`) VALUES (2, null, '2017-09-07 00:00:00', '2017-09-08 00:00:00', 'PRETE', 1, 4);
INSERT INTO `lignecommande` (`id`, `dateDebutPreparation`, `dateFinPreparation`, `dateLivraisonPtRel`, `dateRetraitProducteur`, `dateRetraitPtRel`, `quantite_commandee`, `quantite_delivree`, `quantite_livree`, `quantite_preparee`, `id_commande`, `id_produit`, `id_tournee`) VALUES (1, '2017-09-08 00:00:00', '2017-09-09 00:00:00', '2017-09-10 00:00:00', '2017-09-10 00:00:00', '2017-09-11 00:00:00', 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `lignecommande` (`id`, `dateDebutPreparation`, `dateFinPreparation`, `dateLivraisonPtRel`, `dateRetraitProducteur`, `dateRetraitPtRel`, `quantite_commandee`, `quantite_delivree`, `quantite_livree`, `quantite_preparee`, `id_commande`, `id_produit`, `id_tournee`) VALUES (2, '2017-09-08 00:00:00', '2017-09-09 00:00:00', null, null, null, 2, null, null, 2, 2, 42, 2);
INSERT INTO `lignecommande` (`id`, `dateDebutPreparation`, `dateFinPreparation`, `dateLivraisonPtRel`, `dateRetraitProducteur`, `dateRetraitPtRel`, `quantite_commandee`, `quantite_delivree`, `quantite_livree`, `quantite_preparee`, `id_commande`, `id_produit`, `id_tournee`) VALUES (3, '2017-09-08 00:00:00', '2017-09-09 00:00:00', null, null, null, 2, null, null, 2, 2, 12, 2);
INSERT INTO `lignecommande` (`id`, `dateDebutPreparation`, `dateFinPreparation`, `dateLivraisonPtRel`, `dateRetraitProducteur`, `dateRetraitPtRel`, `quantite_commandee`, `quantite_delivree`, `quantite_livree`, `quantite_preparee`, `id_commande`, `id_produit`, `id_tournee`) VALUES (4, '2017-09-08 00:00:00', '2017-09-09 00:00:00', null, null, null, 2, null, null, 2, 2, 18, 2);
commit;
