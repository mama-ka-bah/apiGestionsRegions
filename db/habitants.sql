-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 17 août 2022 à 19:30
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
-- Structure de la table `habitants`
--

CREATE TABLE `habitants` (
  `id` bigint(20) NOT NULL,
  `nbre_habitant` bigint(20) DEFAULT NULL,
  `id_region_id` bigint(20) DEFAULT NULL,
  `id_avoirhabitant_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `habitants`
--

INSERT INTO `habitants` (`id`, `nbre_habitant`, `id_region_id`, `id_avoirhabitant_id`) VALUES
(1, 2000000, 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `habitants`
--
ALTER TABLE `habitants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt3bg6hafd02afehwphthhspg3` (`id_region_id`),
  ADD KEY `FKjw3360pkbopdoqhwtncq89cuv` (`id_avoirhabitant_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `habitants`
--
ALTER TABLE `habitants`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `habitants`
--
ALTER TABLE `habitants`
  ADD CONSTRAINT `FKjw3360pkbopdoqhwtncq89cuv` FOREIGN KEY (`id_avoirhabitant_id`) REFERENCES `avoirhabitant` (`id`),
  ADD CONSTRAINT `FKt3bg6hafd02afehwphthhspg3` FOREIGN KEY (`id_region_id`) REFERENCES `regions` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
