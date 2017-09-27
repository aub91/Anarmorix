-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 28 sep. 2017 à 01:28
-- Version du serveur :  10.1.26-MariaDB
-- Version de PHP :  7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `anarmorix_bdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

CREATE TABLE `adherent` (
  `type_adherent` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `dateDesinscription` datetime DEFAULT NULL,
  `dateInscription` datetime NOT NULL,
  `dateNaissance` datetime NOT NULL,
  `mail` varchar(150) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `tel1` varchar(20) NOT NULL,
  `tel2` varchar(20) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `id_adresse` int(11) NOT NULL,
  `id_image` int(11) DEFAULT NULL,
  `id_motif_desinscription` int(11) DEFAULT NULL,
  `id_relais` int(11) DEFAULT NULL,
  `id_societe` int(11) DEFAULT NULL,
  `id_exploitation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`type_adherent`, `id`, `dateDesinscription`, `dateInscription`, `dateNaissance`, `mail`, `nom`, `password`, `prenom`, `tel1`, `tel2`, `username`, `id_adresse`, `id_image`, `id_motif_desinscription`, `id_relais`, `id_societe`, `id_exploitation`) VALUES
('Client', 1, NULL, '2017-09-18 00:00:00', '2017-08-17 00:00:00', 'jj.grandarbre@mail.fr', 'Grandarbre', 'aaa', 'Jean-Jacques', '0666666666', NULL, 'grandarbre', 1, NULL, NULL, NULL, NULL, NULL),
('Producteur', 2, NULL, '2016-12-17 00:00:00', '2017-08-17 00:00:00', 'guillaumedemachaut@mailoo.org', 'Gramsci', 'aaa', 'Aubin', '0666666666', NULL, 'Renï¿½shinycastle', 2, NULL, NULL, NULL, NULL, 1),
('Producteur', 3, NULL, '2017-01-14 00:00:00', '2017-08-17 00:00:00', 'jamesosterberg@zaclys.org', 'Kropotkine', 'aaa', 'Alexandre', '0666666666', NULL, 'Marbeufmiroton', 3, NULL, NULL, NULL, NULL, 2),
('Producteur', 4, NULL, '2017-02-10 00:00:00', '2017-08-17 00:00:00', 'loureed@gandi.org', 'Luxemburg', 'aaa', 'Christina', '0666666666', NULL, 'Platontondubled', 4, NULL, NULL, NULL, NULL, 3),
('Employe', 5, NULL, '2017-03-05 00:00:00', '2017-08-17 00:00:00', 'archangelocorelli@vivaldi.org', 'Considï¿½rant', 'aaa', 'Eloi', '0666666666', NULL, 'Diogeneegoiste', 5, NULL, NULL, 4, NULL, NULL),
('Employe', 6, NULL, '2017-04-11 00:00:00', '2017-08-17 00:00:00', 'marcbolan@openmailbox.com', 'Blanqui', 'aaa', 'Fousseynou', '0666666666', NULL, 'Spinozeabond', 6, NULL, NULL, 5, NULL, NULL),
('Employe', 7, NULL, '2017-05-18 00:00:00', '2017-08-17 00:00:00', 'sergioleone@autistici.org', 'Marx', 'aaa', 'Joel', '0666666666', NULL, 'Marxisterique', 7, NULL, NULL, 6, NULL, NULL),
('Livreur', 8, NULL, '2017-06-23 00:00:00', '2017-08-17 00:00:00', 'patrickdewaere@mailoo.org', 'Bakounine', 'aaa', 'Mouloud', '0666666666', NULL, 'Onnyvoitgoethe', 8, NULL, NULL, NULL, 13, NULL),
('Livreur', 9, NULL, '2017-07-04 00:00:00', '2017-08-17 00:00:00', 'samcooke@fastmail.com', 'Michel', 'aaa', 'Cunï¿½gonde', '0666666666', NULL, 'Kantbuymelove', 9, NULL, NULL, NULL, 13, NULL),
('Client', 10, NULL, '2017-07-29 00:00:00', '2017-08-17 00:00:00', 'carlhall@posteo.fr', 'Proudhon', 'aaa', 'Norbert', '0666666666', NULL, 'Hobbesecration', 10, NULL, NULL, NULL, NULL, NULL),
('Client', 11, NULL, '2017-08-12 00:00:00', '2017-08-17 00:00:00', 'anadiplose@mailoo.org', 'Fourier', 'aaa', 'Athanase', '0666666666', NULL, 'Genevoixdughetto', 11, NULL, NULL, NULL, NULL, NULL),
('Client', 12, NULL, '2017-08-16 00:00:00', '2017-08-17 00:00:00', 'ï¿½penthï¿½se@autistici.org', 'Brassens', 'aaa', 'Eugï¿½ne', '0666666666', NULL, 'Keplerdelateci', 12, NULL, NULL, NULL, NULL, NULL),
('Client', 13, NULL, '2017-09-11 00:00:00', '2017-08-17 00:00:00', 'hyperchleuasme@zaclys.fr', 'Thoreau', 'aaa', 'Celestin', '0666666666', NULL, 'Bergsonindaplace', 1, NULL, NULL, NULL, NULL, NULL),
('Client', 14, NULL, '2017-09-13 00:00:00', '2017-08-17 00:00:00', 'synecdoque@openmailbox.com', 'Bloy', 'aaa', 'Achille', '0666666666', NULL, 'Funkstergauss', 2, NULL, NULL, NULL, NULL, NULL),
('Client', 15, NULL, '2017-09-18 00:00:00', '2017-08-17 00:00:00', 'ï¿½panorthose@ovh.fr', 'Scarlatti', 'aaa', 'Gustave', '0666666666', NULL, 'Wildcatgalileo', 3, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `complement_numero` varchar(20) DEFAULT NULL,
  `latitude` varchar(20) DEFAULT NULL,
  `longitude` varchar(20) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `voie` varchar(150) NOT NULL,
  `id_code_postal` int(11) NOT NULL,
  `id_ville` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `complement_numero`, `latitude`, `longitude`, `numero`, `voie`, `id_code_postal`, `id_ville`) VALUES
(1, NULL, '48.772258', '-3.036797', 35, 'Chemin de Kerpuns', 1, '22162'),
(2, NULL, '48.774040', '-3.037591', 1, 'ZA de Kerpuns', 1, '22162'),
(3, NULL, '48.779062', '3.051375', 15, 'rue Becot', 1, '22162'),
(4, NULL, '48.782303', '-3.059167', 1, 'Rue Gardenn Toul Ar Verzhid', 1, '22162'),
(5, NULL, '48.106397', '-1.687554', 12, 'rue Redon', 2, '35238'),
(6, NULL, '48.507373', '-2.770301', 22, 'boulevard Carnot', 3, '22278'),
(7, NULL, '48.565012', '-3.157254', 15, 'rue Paul Girard', 4, '22070'),
(8, NULL, '48.851137', '-3.121430', 7, 'rue Saint-Andtoine', 5, '22195'),
(9, NULL, '48.746868', '-3.450450', 30, 'Cote du Rest', 6, '22113'),
(10, NULL, '48.809021', '-3.465362', 49, 'Rue de Toul al Lan', 7, '22168'),
(11, NULL, '48.785996', '-3.108771', 4, 'Rue de Traou an Dour', 8, '22127'),
(12, NULL, '48.785926', '-3.223703', 27, 'Rue Chateaubriand', 9, '22362'),
(13, NULL, '48.740593', '-2.964513', 27, 'Poul Rouzigou', 10, '22214'),
(14, NULL, '45.838292', '1.249233', 16, 'Rue Marc Antoine Muret', 11, '87085'),
(15, NULL, '43.703757', '7.264550', 22, 'Rue d Angleterre', 12, '06088'),
(16, NULL, '44.846476', '-0.597124', 71, 'Rue de Caudï¿½ran', 13, '33063'),
(17, NULL, '46.159375', '-1.163280', 36, 'avenue Jeau Guiton', 14, '17300'),
(18, NULL, '47.593167', '-3.066101', 36, 'chemin de Kerluir', 15, '56034'),
(19, NULL, '45.852200', '6.632303', 3164, 'Route Edmond de Rothschild', 16, '74173');

-- --------------------------------------------------------

--
-- Structure de la table `alea`
--

CREATE TABLE `alea` (
  `id` int(11) NOT NULL,
  `dateAlea` datetime NOT NULL,
  `description_Autre_Alea` varchar(300) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `alea_lignecmd`
--

CREATE TABLE `alea_lignecmd` (
  `alea_id` int(11) NOT NULL,
  `ligneCmd_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

CREATE TABLE `catalogue` (
  `id` int(11) NOT NULL,
  `dateCreation` datetime NOT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `id_exploitation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`id`, `dateCreation`, `dateDebut`, `dateFin`, `id_exploitation`) VALUES
(1, '2017-09-03 00:00:00', '2017-09-04 00:00:00', NULL, 1),
(2, '2017-09-04 00:00:00', '2017-09-05 00:00:00', NULL, 2),
(3, '2017-09-05 00:00:00', '2017-09-06 00:00:00', NULL, 3);

-- --------------------------------------------------------

--
-- Structure de la table `catalogue_produit`
--

CREATE TABLE `catalogue_produit` (
  `catalogue_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `catalogue_produit`
--

INSERT INTO `catalogue_produit` (`catalogue_id`, `produit_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_categorie_mere` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`, `id_categorie_mere`) VALUES
(1, 'Fruits, lï¿½gumes et fï¿½culents', NULL),
(2, 'Viandes, charcuteries et produits de la mer', NULL),
(3, 'Produits laitiers', NULL),
(4, 'Boissons', NULL),
(5, 'Fruits', 1),
(6, 'Charcuterie', 2),
(7, 'Autres boissons alcoolisï¿½es', 4),
(8, 'Fruits rouges', 5),
(9, 'Pï¿½tï¿½/Terrine', 6),
(10, 'Biï¿½re', 7),
(11, 'Fraise', 8),
(12, 'Pï¿½tï¿½', 9),
(13, 'Biï¿½re blonde', 10);

-- --------------------------------------------------------

--
-- Structure de la table `codepostal`
--

CREATE TABLE `codepostal` (
  `id` int(11) NOT NULL,
  `codePostal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `codepostal`
--

INSERT INTO `codepostal` (`id`, `codePostal`) VALUES
(1, '22500'),
(2, '35000'),
(3, '22000'),
(4, '22200'),
(5, '22610'),
(6, '22300'),
(7, '22700'),
(8, '22740'),
(9, '22220'),
(10, '22470'),
(11, '87000'),
(12, '06000'),
(13, '33000'),
(14, '17000'),
(15, '56340'),
(16, '74120');

-- --------------------------------------------------------

--
-- Structure de la table `codepostal_ville`
--

CREATE TABLE `codepostal_ville` (
  `cp_id` int(11) NOT NULL,
  `ville_codeInsee` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `codepostal_ville`
--

INSERT INTO `codepostal_ville` (`cp_id`, `ville_codeInsee`) VALUES
(1, '22162'),
(2, '35238'),
(3, '22278'),
(4, '22070'),
(5, '22195'),
(6, '22113'),
(7, '22168'),
(8, '22127'),
(9, '22362'),
(10, '22214'),
(11, '87085'),
(12, '06088'),
(13, '33063'),
(14, '17300'),
(15, '56034'),
(16, '74173');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `codeValidation` varchar(20) DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  `dateValidation` datetime DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `id_client` int(11) NOT NULL,
  `id_relais` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `codeValidation`, `dateCreation`, `dateValidation`, `statut`, `id_client`, `id_relais`) VALUES
(1, '12345', '2017-09-07 00:00:00', '2017-09-08 00:00:00', 'TERMINEE', 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `commerce`
--

CREATE TABLE `commerce` (
  `type_commerce` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `codeApe` varchar(20) NOT NULL,
  `iban` varchar(20) DEFAULT NULL,
  `numNic` varchar(20) NOT NULL,
  `numSiren` varchar(20) NOT NULL,
  `raisonSociale` varchar(50) NOT NULL,
  `id_adresse` int(11) NOT NULL,
  `id_image` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commerce`
--

INSERT INTO `commerce` (`type_commerce`, `id`, `codeApe`, `iban`, `numNic`, `numSiren`, `raisonSociale`, `id_adresse`, `id_image`) VALUES
('Exploitation', 1, '4711D', NULL, '00026', '422260208', 'Dyomedea SARL', 1, NULL),
('Exploitation', 2, '4711D', NULL, '00026', '422260208', 'Hobbesecration SARL', 2, NULL),
('Exploitation', 3, '4711D', NULL, '00026', '422260208', 'Gramsci SARL', 3, NULL),
('PointRelais', 4, '4711D', NULL, '00026', '422260208', 'Kantbuymelove SARL', 4, NULL),
('PointRelais', 5, '4711D', NULL, '00026', '422260208', 'Kropotkine SARL', 5, NULL),
('PointRelais', 6, '4711D', NULL, '00026', '422260208', 'Onnyvoitgoethe SARL', 6, NULL),
('PointRelais', 7, '4711D', NULL, '00026', '422260208', 'Cï¿½lestin SARL', 15, NULL),
('PointRelais', 8, '4711D', NULL, '00026', '422260208', 'Norbert SARL', 16, NULL),
('PointRelais', 9, '4711D', NULL, '00026', '422260208', 'Johnny SARL', 17, NULL),
('PointRelais', 10, '4711D', NULL, '00026', '422260208', 'Shop SARL', 18, NULL),
('PointRelais', 11, '4711D', NULL, '00026', '422260208', 'Anatole SARL', 19, NULL),
('PointRelais', 12, '4711D', NULL, '00026', '422260208', 'Jennifer SARL', 14, NULL),
('SocieteDeLivraison', 13, '4711D', NULL, '00026', '422260208', 'Michel SARL', 7, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `horaire`
--

CREATE TABLE `horaire` (
  `id` int(11) NOT NULL,
  `heureFermeture` varchar(20) NOT NULL,
  `heureOuverture` varchar(20) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_jour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `horaire`
--

INSERT INTO `horaire` (`id`, `heureFermeture`, `heureOuverture`, `libelle`, `id_jour`) VALUES
(1, '20h', '14h', 'Aprï¿½s-midi', 1),
(2, '19h', '8h', 'Journï¿½e', 2),
(3, '19h', '8h', 'Journï¿½e', 3),
(4, '19h', '8h', 'Journï¿½e', 4),
(5, '19h', '8h', 'Journï¿½e', 5),
(6, '19h', '8h', 'Journï¿½e', 6),
(7, '19h', '8h', 'Journï¿½e', 7),
(8, '19h', '8h', 'Journï¿½e', 8),
(9, '19h', '8h', 'Journï¿½e', 9),
(10, '19h', '8h', 'Journï¿½e', 10),
(11, '19h', '8h', 'Journï¿½e', 11),
(12, '19h', '8h', 'Journï¿½e', 12),
(13, '19h', '8h', 'Journï¿½e', 13),
(14, '19h', '8h', 'Journï¿½e', 14),
(15, '12h30', '8h', 'Matin', 15);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `chemin` varchar(150) NOT NULL,
  `id_adherent` int(11) DEFAULT NULL,
  `id_commerce` int(11) DEFAULT NULL,
  `id_exploitation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id`, `chemin`, `id_adherent`, `id_commerce`, `id_exploitation`) VALUES
(1, 'resources/img/Fraise.jpg', NULL, NULL, NULL),
(2, 'resources/img/Homard.jpg', NULL, NULL, NULL),
(3, 'resources/img/Huitre.jpg', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `indisponibilite`
--

CREATE TABLE `indisponibilite` (
  `id` int(11) NOT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `dateSaisie` datetime NOT NULL,
  `descriptionAutreIndispo` varchar(300) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_commerce` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `id_recette` int(11) NOT NULL,
  `id_type_produit` int(11) NOT NULL,
  `id_unite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `jourouverture`
--

CREATE TABLE `jourouverture` (
  `id` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `id_pointRelais` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `jourouverture`
--

INSERT INTO `jourouverture` (`id`, `libelle`, `id_pointRelais`) VALUES
(1, 'Lundi', 4),
(2, 'Mardi', 4),
(3, 'Mercredi', 4),
(4, 'Jeudi', 4),
(5, 'Vendredi', 4),
(6, 'Lundi', 5),
(7, 'Mardi', 5),
(8, 'Mercredi', 5),
(9, 'Jeudi', 5),
(10, 'Vendredi', 5),
(11, 'Lundi', 6),
(12, 'Mardi', 6),
(13, 'Mercredi', 6),
(14, 'Jeudi', 6),
(15, 'Vendredi', 6);

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE `lignecommande` (
  `id` int(11) NOT NULL,
  `dateDebutPreparation` datetime DEFAULT NULL,
  `dateFinPreparation` datetime DEFAULT NULL,
  `dateLivraisonPtRel` datetime DEFAULT NULL,
  `dateRetraitProducteur` datetime DEFAULT NULL,
  `dateRetraitPtRel` datetime DEFAULT NULL,
  `quantite_commandee` double NOT NULL,
  `quantite_delivree` double DEFAULT NULL,
  `quantite_livree` double DEFAULT NULL,
  `quantite_preparee` double DEFAULT NULL,
  `id_commande` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_tournee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lignecommande`
--

INSERT INTO `lignecommande` (`id`, `dateDebutPreparation`, `dateFinPreparation`, `dateLivraisonPtRel`, `dateRetraitProducteur`, `dateRetraitPtRel`, `quantite_commandee`, `quantite_delivree`, `quantite_livree`, `quantite_preparee`, `id_commande`, `id_produit`, `id_tournee`) VALUES
(1, '2017-10-08 00:00:00', '2017-10-09 00:00:00', '2017-10-10 00:00:00', '2017-10-10 00:00:00', '2017-10-11 00:00:00', 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `motifdesinscription`
--

CREATE TABLE `motifdesinscription` (
  `id` int(11) NOT NULL,
  `description_Autre_Motif` varchar(300) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `packaging`
--

CREATE TABLE `packaging` (
  `id` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `valeur_unitaire` double DEFAULT NULL,
  `packaging_pere` int(11) DEFAULT NULL,
  `unite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `packaging`
--

INSERT INTO `packaging` (`id`, `libelle`, `valeur_unitaire`, `packaging_pere`, `unite`) VALUES
(1, 'Bouteille', 1, NULL, 2),
(2, 'Vrac', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `dateProduction` datetime DEFAULT NULL,
  `descriptif` varchar(200) DEFAULT NULL,
  `prixUnitaire` decimal(12,2) NOT NULL,
  `quantite` decimal(12,2) NOT NULL,
  `id_image` int(11) DEFAULT NULL,
  `id_packaging` int(11) DEFAULT NULL,
  `id_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `dateProduction`, `descriptif`, `prixUnitaire`, `quantite`, `id_image`, `id_packaging`, `id_type`) VALUES
(1, NULL, NULL, '25.00', '50.00', 1, 2, 1),
(2, NULL, NULL, '10.00', '50.00', 2, 1, 3),
(3, NULL, NULL, '10.00', '50.00', 3, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

CREATE TABLE `recette` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tauxtva`
--

CREATE TABLE `tauxtva` (
  `id` int(11) NOT NULL,
  `taux` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tauxtva`
--

INSERT INTO `tauxtva` (`id`, `taux`) VALUES
(1, '5.50'),
(2, '10.00'),
(3, '20.00');

-- --------------------------------------------------------

--
-- Structure de la table `tournee`
--

CREATE TABLE `tournee` (
  `id` int(11) NOT NULL,
  `dateHeureDebut` datetime DEFAULT NULL,
  `dateHeureFin` datetime DEFAULT NULL,
  `id_livreur` int(11) DEFAULT NULL,
  `id_societe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tournee`
--

INSERT INTO `tournee` (`id`, `dateHeureDebut`, `dateHeureFin`, `id_livreur`, `id_societe`) VALUES
(1, '2017-09-10 09:00:00', '2017-09-10 12:00:00', 8, 13);

-- --------------------------------------------------------

--
-- Structure de la table `typeproduit`
--

CREATE TABLE `typeproduit` (
  `id` int(11) NOT NULL,
  `dureConservation` int(11) DEFAULT NULL,
  `libelle` varchar(50) NOT NULL,
  `uniteConservation` varchar(255) DEFAULT NULL,
  `id_categorie` int(11) NOT NULL,
  `id_imageDefaut` int(11) NOT NULL,
  `id_tva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeproduit`
--

INSERT INTO `typeproduit` (`id`, `dureConservation`, `libelle`, `uniteConservation`, `id_categorie`, `id_imageDefaut`, `id_tva`) VALUES
(1, NULL, 'Fraise gariguette', NULL, 11, 1, 1),
(2, NULL, 'Pï¿½tï¿½ de campagne', NULL, 12, 1, 1),
(3, NULL, 'Biï¿½re blonde sans gluten', NULL, 13, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `unitepackaging`
--

CREATE TABLE `unitepackaging` (
  `id` int(11) NOT NULL,
  `unite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `unitepackaging`
--

INSERT INTO `unitepackaging` (`id`, `unite`) VALUES
(1, 'kilogramme'),
(2, 'litre'),
(3, 'piï¿½ce');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `codeInsee` varchar(255) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`codeInsee`, `nom`) VALUES
('06088', 'Nice'),
('17300', 'La Rochelle'),
('22070', 'Guingamp'),
('22113', 'Lannion'),
('22127', 'Lezardrieux'),
('22162', 'Paimpol'),
('22168', 'Perros-Guirrec'),
('22195', 'Pleubian'),
('22214', 'Pouezec'),
('22278', 'Saint-Brieuc'),
('22362', 'Trï¿½guier'),
('33063', 'Bordeaux'),
('35238', 'Rennes'),
('56034', 'Carnac'),
('74173', 'Megï¿½ve'),
('87085', 'Limoges');

-- --------------------------------------------------------

--
-- Structure de la table `ville_societelivraison`
--

CREATE TABLE `ville_societelivraison` (
  `ville_codeInsee` varchar(255) NOT NULL,
  `societeLivraison_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville_societelivraison`
--

INSERT INTO `ville_societelivraison` (`ville_codeInsee`, `societeLivraison_id`) VALUES
('22070', 13),
('22113', 13),
('22127', 13),
('22162', 13),
('22168', 13),
('22195', 13),
('22214', 13),
('22278', 13),
('22362', 13),
('35238', 13);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Adherent_Adresse` (`id_adresse`),
  ADD KEY `FK_Adherent_Image` (`id_image`),
  ADD KEY `FK_Adherent_Desinscription` (`id_motif_desinscription`),
  ADD KEY `FK_Employe_Relais` (`id_relais`),
  ADD KEY `FK_Livreur_Societe` (`id_societe`),
  ADD KEY `FK_Producteur_Exploitation` (`id_exploitation`);

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Adresse_CodePostal` (`id_code_postal`),
  ADD KEY `FK_Adresse_Ville` (`id_ville`);

--
-- Index pour la table `alea`
--
ALTER TABLE `alea`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `alea_lignecmd`
--
ALTER TABLE `alea_lignecmd`
  ADD KEY `FKgep3wmekxdhwkr1ohob9bchla` (`ligneCmd_id`),
  ADD KEY `FKhrr14jg4rtb14euh72ksti42f` (`alea_id`);

--
-- Index pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Catalogue_Exploitation` (`id_exploitation`);

--
-- Index pour la table `catalogue_produit`
--
ALTER TABLE `catalogue_produit`
  ADD KEY `FK9obx425o4bf6do0wxeqrla1lf` (`produit_id`),
  ADD KEY `FKdanug8gfhol1d4vsjsi5iv3wu` (`catalogue_id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Categorie_Categorie` (`id_categorie_mere`);

--
-- Index pour la table `codepostal`
--
ALTER TABLE `codepostal`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `codepostal_ville`
--
ALTER TABLE `codepostal_ville`
  ADD KEY `FK59qc0uteakj9jo40u0884qg3r` (`ville_codeInsee`),
  ADD KEY `FKsk5j1jvw0a08gguii5kwxm66r` (`cp_id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Commande_Client` (`id_client`),
  ADD KEY `FK_Commande_Relais` (`id_relais`);

--
-- Index pour la table `commerce`
--
ALTER TABLE `commerce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Commerce_Adresse` (`id_adresse`),
  ADD KEY `FK_Commerce_Image` (`id_image`);

--
-- Index pour la table `horaire`
--
ALTER TABLE `horaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Horaire_Jour` (`id_jour`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Image_Adherent` (`id_adherent`),
  ADD KEY `FK_Image_Commerce` (`id_commerce`),
  ADD KEY `FK_Image_Exploitation` (`id_exploitation`);

--
-- Index pour la table `indisponibilite`
--
ALTER TABLE `indisponibilite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Indisponibilite_Commerce` (`id_commerce`);

--
-- Index pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Ingredient_Recette` (`id_recette`),
  ADD KEY `FK_Ingredient_typeProduit` (`id_type_produit`),
  ADD KEY `FK_Ingredient_Unite` (`id_unite`);

--
-- Index pour la table `jourouverture`
--
ALTER TABLE `jourouverture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_JourOuverture_Point_Relais` (`id_pointRelais`);

--
-- Index pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_LigneCommande_Commande` (`id_commande`),
  ADD KEY `FK_LigneCommande_Produit` (`id_produit`),
  ADD KEY `FK_LigneCommande_Tournee` (`id_tournee`);

--
-- Index pour la table `motifdesinscription`
--
ALTER TABLE `motifdesinscription`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `packaging`
--
ALTER TABLE `packaging`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Packaging_PackagingPere` (`packaging_pere`),
  ADD KEY `FK_Packaging_Unite` (`unite`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Produit_Image` (`id_image`),
  ADD KEY `FK_Produit_Packaging` (`id_packaging`),
  ADD KEY `FK_Produit_TypeProduit` (`id_type`);

--
-- Index pour la table `recette`
--
ALTER TABLE `recette`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tauxtva`
--
ALTER TABLE `tauxtva`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `tournee`
--
ALTER TABLE `tournee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Tournee_Livreur` (`id_livreur`),
  ADD KEY `FK_Tournee_SocieteLivraison` (`id_societe`);

--
-- Index pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TypeProduit_Categorie` (`id_categorie`),
  ADD KEY `FK_TypeProduit_Image` (`id_imageDefaut`),
  ADD KEY `FK_TypeProduit_Tva` (`id_tva`);

--
-- Index pour la table `unitepackaging`
--
ALTER TABLE `unitepackaging`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`codeInsee`);

--
-- Index pour la table `ville_societelivraison`
--
ALTER TABLE `ville_societelivraison`
  ADD KEY `FK1jddv59fuxcuia3od7fwp8xhq` (`societeLivraison_id`),
  ADD KEY `FKd59ems0pgw8mopivpmpif3iod` (`ville_codeInsee`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adherent`
--
ALTER TABLE `adherent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `alea`
--
ALTER TABLE `alea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `codepostal`
--
ALTER TABLE `codepostal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `commerce`
--
ALTER TABLE `commerce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `horaire`
--
ALTER TABLE `horaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `indisponibilite`
--
ALTER TABLE `indisponibilite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `jourouverture`
--
ALTER TABLE `jourouverture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `motifdesinscription`
--
ALTER TABLE `motifdesinscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `packaging`
--
ALTER TABLE `packaging`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `recette`
--
ALTER TABLE `recette`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tauxtva`
--
ALTER TABLE `tauxtva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `tournee`
--
ALTER TABLE `tournee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `unitepackaging`
--
ALTER TABLE `unitepackaging`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD CONSTRAINT `FK_Adherent_Adresse` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `FK_Adherent_Desinscription` FOREIGN KEY (`id_motif_desinscription`) REFERENCES `motifdesinscription` (`id`),
  ADD CONSTRAINT `FK_Adherent_Image` FOREIGN KEY (`id_image`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FK_Employe_Relais` FOREIGN KEY (`id_relais`) REFERENCES `commerce` (`id`),
  ADD CONSTRAINT `FK_Livreur_Societe` FOREIGN KEY (`id_societe`) REFERENCES `commerce` (`id`),
  ADD CONSTRAINT `FK_Producteur_Exploitation` FOREIGN KEY (`id_exploitation`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `FK_Adresse_CodePostal` FOREIGN KEY (`id_code_postal`) REFERENCES `codepostal` (`id`),
  ADD CONSTRAINT `FK_Adresse_Ville` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`codeInsee`);

--
-- Contraintes pour la table `alea_lignecmd`
--
ALTER TABLE `alea_lignecmd`
  ADD CONSTRAINT `FKgep3wmekxdhwkr1ohob9bchla` FOREIGN KEY (`ligneCmd_id`) REFERENCES `lignecommande` (`id`),
  ADD CONSTRAINT `FKhrr14jg4rtb14euh72ksti42f` FOREIGN KEY (`alea_id`) REFERENCES `alea` (`id`);

--
-- Contraintes pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `FK_Catalogue_Exploitation` FOREIGN KEY (`id_exploitation`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `catalogue_produit`
--
ALTER TABLE `catalogue_produit`
  ADD CONSTRAINT `FK9obx425o4bf6do0wxeqrla1lf` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FKdanug8gfhol1d4vsjsi5iv3wu` FOREIGN KEY (`catalogue_id`) REFERENCES `catalogue` (`id`);

--
-- Contraintes pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD CONSTRAINT `FK_Categorie_Categorie` FOREIGN KEY (`id_categorie_mere`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `codepostal_ville`
--
ALTER TABLE `codepostal_ville`
  ADD CONSTRAINT `FK59qc0uteakj9jo40u0884qg3r` FOREIGN KEY (`ville_codeInsee`) REFERENCES `ville` (`codeInsee`),
  ADD CONSTRAINT `FKsk5j1jvw0a08gguii5kwxm66r` FOREIGN KEY (`cp_id`) REFERENCES `codepostal` (`id`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK_Commande_Client` FOREIGN KEY (`id_client`) REFERENCES `adherent` (`id`),
  ADD CONSTRAINT `FK_Commande_Relais` FOREIGN KEY (`id_relais`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `commerce`
--
ALTER TABLE `commerce`
  ADD CONSTRAINT `FK_Commerce_Adresse` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `FK_Commerce_Image` FOREIGN KEY (`id_image`) REFERENCES `image` (`id`);

--
-- Contraintes pour la table `horaire`
--
ALTER TABLE `horaire`
  ADD CONSTRAINT `FK_Horaire_Jour` FOREIGN KEY (`id_jour`) REFERENCES `jourouverture` (`id`);

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `FK_Image_Adherent` FOREIGN KEY (`id_adherent`) REFERENCES `adherent` (`id`),
  ADD CONSTRAINT `FK_Image_Commerce` FOREIGN KEY (`id_commerce`) REFERENCES `commerce` (`id`),
  ADD CONSTRAINT `FK_Image_Exploitation` FOREIGN KEY (`id_exploitation`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `indisponibilite`
--
ALTER TABLE `indisponibilite`
  ADD CONSTRAINT `FK_Indisponibilite_Commerce` FOREIGN KEY (`id_commerce`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD CONSTRAINT `FK_Ingredient_Recette` FOREIGN KEY (`id_recette`) REFERENCES `recette` (`id`),
  ADD CONSTRAINT `FK_Ingredient_Unite` FOREIGN KEY (`id_unite`) REFERENCES `unitepackaging` (`id`),
  ADD CONSTRAINT `FK_Ingredient_typeProduit` FOREIGN KEY (`id_type_produit`) REFERENCES `typeproduit` (`id`);

--
-- Contraintes pour la table `jourouverture`
--
ALTER TABLE `jourouverture`
  ADD CONSTRAINT `FK_JourOuverture_Point_Relais` FOREIGN KEY (`id_pointRelais`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `FK_LigneCommande_Commande` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FK_LigneCommande_Produit` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FK_LigneCommande_Tournee` FOREIGN KEY (`id_tournee`) REFERENCES `tournee` (`id`);

--
-- Contraintes pour la table `packaging`
--
ALTER TABLE `packaging`
  ADD CONSTRAINT `FK_Packaging_PackagingPere` FOREIGN KEY (`packaging_pere`) REFERENCES `packaging` (`id`),
  ADD CONSTRAINT `FK_Packaging_Unite` FOREIGN KEY (`unite`) REFERENCES `unitepackaging` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_Produit_Image` FOREIGN KEY (`id_image`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FK_Produit_Packaging` FOREIGN KEY (`id_packaging`) REFERENCES `packaging` (`id`),
  ADD CONSTRAINT `FK_Produit_TypeProduit` FOREIGN KEY (`id_type`) REFERENCES `typeproduit` (`id`);

--
-- Contraintes pour la table `tournee`
--
ALTER TABLE `tournee`
  ADD CONSTRAINT `FK_Tournee_Livreur` FOREIGN KEY (`id_livreur`) REFERENCES `adherent` (`id`),
  ADD CONSTRAINT `FK_Tournee_SocieteLivraison` FOREIGN KEY (`id_societe`) REFERENCES `commerce` (`id`);

--
-- Contraintes pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
  ADD CONSTRAINT `FK_TypeProduit_Categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `FK_TypeProduit_Image` FOREIGN KEY (`id_imageDefaut`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FK_TypeProduit_Tva` FOREIGN KEY (`id_tva`) REFERENCES `tauxtva` (`id`);

--
-- Contraintes pour la table `ville_societelivraison`
--
ALTER TABLE `ville_societelivraison`
  ADD CONSTRAINT `FK1jddv59fuxcuia3od7fwp8xhq` FOREIGN KEY (`societeLivraison_id`) REFERENCES `commerce` (`id`),
  ADD CONSTRAINT `FKd59ems0pgw8mopivpmpif3iod` FOREIGN KEY (`ville_codeInsee`) REFERENCES `ville` (`codeInsee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
