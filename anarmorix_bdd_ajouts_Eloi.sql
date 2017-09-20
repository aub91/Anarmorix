-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 19 sep. 2017 à 18:46
-- Version du serveur :  10.1.25-MariaDB
-- Version de PHP :  7.1.7

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
  `dateDesinscription` datetime NOT NULL,
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
('Client', 2, '0000-00-00 00:00:00', '2017-09-19 00:00:00', '2017-08-17 00:00:00', 'jj.grandarbre@mail.fr', 'Grandarbre', 'aaa', 'Jean-Jacques', '0666666666', NULL, 'grandarbre', 1, NULL, NULL, NULL, NULL, NULL);

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
(1, NULL, '0.0001', '0.0001', 1, 'rue Hun', 1, '1');

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

-- --------------------------------------------------------

--
-- Structure de la table `catalogue_produit`
--

CREATE TABLE `catalogue_produit` (
  `catalogue_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_categorie_mere` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(1, '22200');

-- --------------------------------------------------------

--
-- Structure de la table `codepostal_ville`
--

CREATE TABLE `codepostal_ville` (
  `cp_id` int(11) NOT NULL,
  `ville_codeInsee` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `codeValidation` varchar(20) NOT NULL,
  `dateCreation` datetime NOT NULL,
  `dateValidation` datetime NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `id_client` int(11) NOT NULL,
  `id_relais` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `chemin` varchar(150) NOT NULL,
  `description_Autre_Motif` varchar(300) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `id_adherent` int(11) DEFAULT NULL,
  `id_commerce` int(11) DEFAULT NULL,
  `id_exploitation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `packaging`
--

CREATE TABLE `packaging` (
  `packaging` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `valeur_unitaire` double NOT NULL,
  `packaging_pere` int(11) DEFAULT NULL,
  `unite` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `dateProduction` datetime DEFAULT NULL,
  `prixUnitaire` decimal(12,2) NOT NULL,
  `quantite` decimal(12,2) NOT NULL,
  `id_image` int(11) DEFAULT NULL,
  `id_packaging` int(11) DEFAULT NULL,
  `id_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `tournee`
--

CREATE TABLE `tournee` (
  `id` int(11) NOT NULL,
  `dateHeureDebut` datetime DEFAULT NULL,
  `dateHeureFin` datetime DEFAULT NULL,
  `id_livreur` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typeproduit`
--

CREATE TABLE `typeproduit` (
  `id` int(11) NOT NULL,
  `dureConservation` int(11) DEFAULT NULL,
  `libelle` varchar(50) NOT NULL,
  `uniteConservation` varchar(255) DEFAULT NULL,
  `id_imageDefaut` int(11) NOT NULL,
  `id_tva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `unitepackaging`
--

CREATE TABLE `unitepackaging` (
  `id` int(11) NOT NULL,
  `unite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('1', 'Guingamp');

-- --------------------------------------------------------

--
-- Structure de la table `ville_societelivraison`
--

CREATE TABLE `ville_societelivraison` (
  `ville_codeInsee` varchar(255) NOT NULL,
  `societeLivraison_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Index pour la table `packaging`
--
ALTER TABLE `packaging`
  ADD PRIMARY KEY (`packaging`),
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
  ADD KEY `FK_Tournee_Livreur` (`id_livreur`);

--
-- Index pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
  ADD PRIMARY KEY (`id`),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `alea`
--
ALTER TABLE `alea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `codepostal`
--
ALTER TABLE `codepostal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `commerce`
--
ALTER TABLE `commerce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `horaire`
--
ALTER TABLE `horaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `packaging`
--
ALTER TABLE `packaging`
  MODIFY `packaging` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `recette`
--
ALTER TABLE `recette`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tauxtva`
--
ALTER TABLE `tauxtva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tournee`
--
ALTER TABLE `tournee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `unitepackaging`
--
ALTER TABLE `unitepackaging`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `adherent`
--
ALTER TABLE `adherent`
  ADD CONSTRAINT `FK_Adherent_Adresse` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id`),
  ADD CONSTRAINT `FK_Adherent_Desinscription` FOREIGN KEY (`id_motif_desinscription`) REFERENCES `image` (`id`),
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
  ADD CONSTRAINT `FK_Packaging_PackagingPere` FOREIGN KEY (`packaging_pere`) REFERENCES `packaging` (`packaging`),
  ADD CONSTRAINT `FK_Packaging_Unite` FOREIGN KEY (`unite`) REFERENCES `unitepackaging` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_Produit_Image` FOREIGN KEY (`id_image`) REFERENCES `image` (`id`),
  ADD CONSTRAINT `FK_Produit_Packaging` FOREIGN KEY (`id_packaging`) REFERENCES `packaging` (`packaging`),
  ADD CONSTRAINT `FK_Produit_TypeProduit` FOREIGN KEY (`id_type`) REFERENCES `typeproduit` (`id`);

--
-- Contraintes pour la table `tournee`
--
ALTER TABLE `tournee`
  ADD CONSTRAINT `FK_Tournee_Livreur` FOREIGN KEY (`id_livreur`) REFERENCES `adherent` (`id`);

--
-- Contraintes pour la table `typeproduit`
--
ALTER TABLE `typeproduit`
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
