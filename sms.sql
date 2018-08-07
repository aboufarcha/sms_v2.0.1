-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 07 août 2018 à 20:17
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sms`
--

-- --------------------------------------------------------

--
-- Structure de la table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
CREATE TABLE IF NOT EXISTS `privilege` (
  `ID_Privilege` int(11) NOT NULL AUTO_INCREMENT,
  `Titre_Priv_fr` varchar(40) NOT NULL,
  `Titre_Priv_ar` varchar(40) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ID_Privilege`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `privilege`
--

INSERT INTO `privilege` (`ID_Privilege`, `Titre_Priv_fr`, `Titre_Priv_ar`) VALUES
(1, 'Gestion des employées', 'إدارة المستخدمين'),
(6, 'Gestion des spécialités', 'إدارة  التخصصات'),
(4, 'Gestion des professeurs', 'إدارة الأساتذة'),
(5, 'Gestion des étudiants', 'إدارة الطلاب'),
(7, 'Gestion des séances ', 'إدارة الحصص'),
(8, 'Gestion des salles', 'إدارة القاعات'),
(9, 'Gestion de payement', 'إدارة الدفعات');

-- --------------------------------------------------------

--
-- Structure de la table `privilege_management`
--

DROP TABLE IF EXISTS `privilege_management`;
CREATE TABLE IF NOT EXISTS `privilege_management` (
  `ID_Privilege_M` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Admin_FK` int(11) NOT NULL,
  `ID_SPrivi_FK` int(11) NOT NULL,
  PRIMARY KEY (`ID_Privilege_M`),
  KEY `sous_privilege_fk` (`ID_SPrivi_FK`),
  KEY `administrateur_priv_fk` (`ID_Admin_FK`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sous_privilege`
--

DROP TABLE IF EXISTS `sous_privilege`;
CREATE TABLE IF NOT EXISTS `sous_privilege` (
  `ID_Sous_Privilege` int(11) NOT NULL AUTO_INCREMENT,
  `Titre_SPive_fr` varchar(40) NOT NULL,
  `Titre_SPive_ar` varchar(40) CHARACTER SET utf8 NOT NULL,
  `ID_Privilege_FK` int(11) NOT NULL,
  PRIMARY KEY (`ID_Sous_Privilege`),
  KEY `Privilege_FK` (`ID_Privilege_FK`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sous_privilege`
--

INSERT INTO `sous_privilege` (`ID_Sous_Privilege`, `Titre_SPive_fr`, `Titre_SPive_ar`, `ID_Privilege_FK`) VALUES
(1, 'La liste des employés', 'لائحة المستخدمين', 1),
(2, 'Ajouter un employé', 'إضافة مسخدم', 1),
(3, 'Importer des employés', 'إستراد مستخدمين', 1),
(4, 'Exporter des employés', 'تصدير مستخدمين', 1),
(5, 'La liste des spécialités', 'لائحة التخصصات', 6),
(6, 'Ajouter un niveau', 'إضافة مستوى', 6),
(7, 'Supprimer un employé', 'حذف مستخدم', 1),
(8, 'Ajouter une spécialité', 'إضافة تخصص', 6),
(9, 'Supprimer un niveau', 'حذف مستوى', 6),
(10, 'Supprimer une spécialité', 'حذف تخصص', 6),
(11, 'La liste des professeurs', 'لائحة الأساتذة', 4),
(12, 'Ajouter un professeur', 'إضافة أستاذ', 4),
(13, 'Importer des professeurs', 'إستراد الأساتذة', 4),
(14, 'Exporter des professeurs', 'تصدير الأساتذة', 4),
(15, 'Supprimer un professeur', 'حذف أستاذ', 4),
(16, 'La liste des étudiants', 'لائحة الطلاب', 5),
(17, 'Ajouter un étudiant', 'إضافة طالب', 5),
(18, 'Importer des étudiants', 'إستراد الطلاب', 5),
(19, 'Exporter des étudiants', 'تصدير الطلاب', 5),
(20, 'Supprimer un étudiant', 'حذف طالب', 5),
(21, 'La liste des séances', 'لائحة الحصص', 7),
(22, 'Ajouter une séance', 'إضافة حصة', 7),
(23, 'Supprimer une séance', 'حذف حصة', 7),
(24, 'Ajouter une absence', 'إضافة غياب', 7),
(25, 'Supprimer une absence', 'حذف غياب', 7),
(26, 'Modifier une séance', 'تعديل حصة', 7),
(27, 'Modifier un employé', 'تعديل مستخدم', 1),
(28, 'Modifier un étudiant', 'تعديل طالب', 5),
(29, 'Modifier un professeur', 'تعديل أستاذ', 4),
(30, 'Modifier  un niveau', 'تعديل مستوى', 6),
(31, 'Modifier une spécialité', 'تعديل تخصص', 6),
(32, 'La liste des salles', 'لائحة القاعات', 8),
(33, 'Ajouter une salle', 'إضافة قاعة', 8),
(34, 'Modifier une salle', 'تعديل قاعة', 8),
(35, 'Supprimer une salle', 'حذف قاعة', 8),
(36, 'La liste de paiement', 'لائحة الدفعات', 9),
(37, 'Ajouter un paiement', 'إضافة دفعة', 9),
(38, 'Modifier un paiement', 'تعديل دفعة', 9),
(39, 'Supprimer un paiement', 'حذف دفعة', 9);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_Admin` int(11) NOT NULL AUTO_INCREMENT,
  `Num_Inscription` varchar(15) NOT NULL,
  `Date_Inscription` date DEFAULT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `NomAr` varchar(25) NOT NULL,
  `PrenomAr` varchar(25) NOT NULL,
  `Sexe` varchar(6) NOT NULL,
  `LieuNaissance` varchar(30) NOT NULL,
  `DateDeNaissance` date DEFAULT NULL,
  `Nationalite` varchar(25) NOT NULL,
  `Adresse` varchar(80) NOT NULL,
  `Photo` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(70) NOT NULL,
  `Role` varchar(7) NOT NULL,
  `Last_Connect` timestamp NOT NULL,
  PRIMARY KEY (`ID_Admin`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_Admin`, `Num_Inscription`, `Date_Inscription`, `Nom`, `Prenom`, `NomAr`, `PrenomAr`, `Sexe`, `LieuNaissance`, `DateDeNaissance`, `Nationalite`, `Adresse`, `Photo`, `Email`, `Password`, `Role`, `Last_Connect`) VALUES
(1, '', NULL, 'root', 'root', '', '', '', '', NULL, '', '', '', 'root@gmail.com', 'd1f86352cfe8dc273228e3dc122cd32b', 'Admin', '2018-07-30 23:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
