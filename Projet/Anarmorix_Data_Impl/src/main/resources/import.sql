INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES (1, 'test', NULL, NULL, NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (1, 'Fruits', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (2, 'Charcuterie', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (3, 'Autres boissons alcoolisées', NULL);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (4, 'Fruits rouges', 1);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (5, 'Pâté/Terrine', 2);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (6, 'Bière', 3);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (7, 'Fraise', 4);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (8, 'Pâté', 5);
INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES (9, 'Bière blonde', 6);
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (1, '5.50');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (2, '10.00');
INSERT INTO `tauxtva` (`id`, `taux`) VALUES (3, '20.00');
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (1, NULL, 'Fraise gariguette', NULL, 1, 1);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (2, NULL, 'Pâté de campagne', NULL, 1, 1);
INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_imageDefaut`, `id_tva`) VALUES (3, NULL, 'Bière blonde sans gluten', NULL, 1, 1);
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (1, 'kilogramme');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (2, 'litre');
INSERT INTO `unitepackaging` (`id`, `unite`) VALUES (3, 'pièce');
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (1, 'Bouteille', 1, NULL, 2);
INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES (2, 'Vrac', NULL, NULL, 1);
insert into adherent (id_adresse, dateDesinscription, dateInscription, dateNaissance, id_image, mail, id_motif_desinscription, nom, password, prenom, tel1, tel2, username, type_adherent) values (1, null, '2017-09-19 00:00:00', '2017-08-17 00:00:00', null, 'jj.grandarbre@mail.fr', null, 'Grandarbre', 'aaa', 'Jean-Jacques', '0666666666', null,'grandarbre' , 'Client')
commit;






