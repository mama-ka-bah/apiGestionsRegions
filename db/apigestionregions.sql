-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 14 août 2022 à 05:35
-- Version du serveur : 10.4.19-MariaDB
-- Version de PHP : 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `apigestionregions`
--

-- --------------------------------------------------------

--
-- Structure de la table `avoirhabitant`
--

CREATE TABLE `avoirhabitant` (
  `id` bigint(20) NOT NULL,
  `annee` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `avoirhabitant`
--

INSERT INTO `avoirhabitant` (`id`, `annee`) VALUES
(1, 2017),
(2, 2018),
(3, 2019),
(4, 2020),
(5, 2021),
(6, 2022);

-- --------------------------------------------------------

--
-- Structure de la table `habitants`
--

CREATE TABLE `habitants` (
  `id` bigint(20) NOT NULL,
  `nbre_habitant` bigint(20) DEFAULT NULL,
  `id_avoirhabitant_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `habitants`
--

INSERT INTO `habitants` (`id`, `nbre_habitant`, `id_avoirhabitant_id`) VALUES
(1, 1000, 1),
(2, 500, 2),
(3, 2500, 3),
(4, 256000, 4),
(5, 106000, 5);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`) VALUES
(1, 'MALI'),
(2, 'GUINEE'),
(3, 'SENEGAL'),
(4, 'COTE D\'IVOIRE'),
(5, 'CONGO'),
(6, 'BURKINA'),
(7, 'NIGER');

-- --------------------------------------------------------

--
-- Structure de la table `regions`
--

CREATE TABLE `regions` (
  `id` bigint(20) NOT NULL,
  `code_region` varchar(15) DEFAULT NULL,
  `domaine_activite` varchar(15) DEFAULT NULL,
  `langue_majoritaire` varchar(100) DEFAULT NULL,
  `superficie` varchar(150) DEFAULT NULL,
  `idpays_id` bigint(20) DEFAULT NULL,
  `nb_habitant_id` bigint(20) DEFAULT NULL,
  `nom_region` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `regions`
--

INSERT INTO `regions` (`id`, `code_region`, `domaine_activite`, `langue_majoritaire`, `superficie`, `idpays_id`, `nb_habitant_id`, `nom_region`) VALUES
(1, '1', 'Agriculture', 'Bambara', '100KM²', 1, 1, 'KAYS'),
(2, '1', 'Agriculture', 'Bambara', '100KM²', 1, 3, 'KAYS'),
(3, '3', 'Agriculture', 'Bambara', '240KM²', 1, 5, 'SIKASSO'),
(4, '3', 'Agriculture', 'Bambara', '240KM²', 1, 3, 'SIKASSO'),
(5, '3', 'Agriculture', 'Bambara', '240KM²', 1, 4, 'SIKASSO'),
(6, '4', 'INDUSTRIE', 'Bambara', '150KM²', 1, 2, 'KOUTIALA'),
(7, '4', 'INDUSTRIE', 'Bambara', '150KM²', 1, 2, 'KOUTIALA');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avoirhabitant`
--
ALTER TABLE `avoirhabitant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `habitants`
--
ALTER TABLE `habitants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjw3360pkbopdoqhwtncq89cuv` (`id_avoirhabitant_id`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `regions`
--
ALTER TABLE `regions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh5njs78gp64y57mmo41s4ybpy` (`idpays_id`),
  ADD KEY `FKhtcgyr1ymn2jcdkenve5st79r` (`nb_habitant_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `avoirhabitant`
--
ALTER TABLE `avoirhabitant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `habitants`
--
ALTER TABLE `habitants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `regions`
--
ALTER TABLE `regions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `habitants`
--
ALTER TABLE `habitants`
  ADD CONSTRAINT `FKjw3360pkbopdoqhwtncq89cuv` FOREIGN KEY (`id_avoirhabitant_id`) REFERENCES `avoirhabitant` (`id`);

--
-- Contraintes pour la table `regions`
--
ALTER TABLE `regions`
  ADD CONSTRAINT `FKh5njs78gp64y57mmo41s4ybpy` FOREIGN KEY (`idpays_id`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `FKhtcgyr1ymn2jcdkenve5st79r` FOREIGN KEY (`nb_habitant_id`) REFERENCES `habitants` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
