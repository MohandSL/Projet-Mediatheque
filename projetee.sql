-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 13 Mars 2022 à 15:31
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetee`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(120) NOT NULL,
  `nomClient` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mdpClient` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `typeClient` int(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `mdpClient`, `typeClient`) VALUES
(1, 'Mohand', '1111', 1),
(2, 'David', '0000', 2);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `idDocument` int(120) NOT NULL,
  `typeDocument` int(4) NOT NULL,
  `nomDocument` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `idClient` int(120) NOT NULL,
  `Durée` float DEFAULT NULL,
  `auteur` varchar(50) DEFAULT NULL,
  `compositeur` varchar(50) DEFAULT NULL,
  `realisateur` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `document`
--

INSERT INTO `document` (`idDocument`, `typeDocument`, `nomDocument`, `idClient`, `Durée`, `auteur`, `compositeur`, `realisateur`) VALUES
(17, 3, 'Max', 0, NULL, 'Sarah Cohen-Scali', NULL, NULL),
(16, 2, 'Fast and Furious', 0, 1.46, NULL, NULL, 'Rob Cohen'),
(14, 2, 'Retour vers le futur', 0, 1.56, NULL, NULL, 'Robert Zemeckis'),
(15, 2, 'The Amazing Spider-Man', 0, 2.16, NULL, NULL, 'Marc Webb'),
(18, 3, 'La vie devant soi', 0, NULL, 'Romain Gary', NULL, NULL),
(19, 3, 'Bible', 0, NULL, 'Dieu', NULL, NULL),
(20, 1, 'Une Souris Verte', 0, 0.02, NULL, 'inconnue', NULL),
(21, 1, 'Despacito', 0, 0.04, NULL, 'Luis Fonsi', NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`idDocument`),
  ADD KEY `idClient` (`idClient`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(120) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `document`
--
ALTER TABLE `document`
  MODIFY `idDocument` int(120) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
