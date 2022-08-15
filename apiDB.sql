-- MySQL dump 10.13  Distrib 5.7.39, for Linux (x86_64)
--
-- Host: localhost    Database: apigestionregions
-- ------------------------------------------------------
-- Server version	5.7.39-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avoirhabitant`
--

DROP TABLE IF EXISTS `avoirhabitant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avoirhabitant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `annee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avoirhabitant`
--

LOCK TABLES `avoirhabitant` WRITE;
/*!40000 ALTER TABLE `avoirhabitant` DISABLE KEYS */;
INSERT INTO `avoirhabitant` VALUES (1,2020),(2,2021),(3,2022);
/*!40000 ALTER TABLE `avoirhabitant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitants`
--

DROP TABLE IF EXISTS `habitants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitants` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nbre_habitant` bigint(20) DEFAULT NULL,
  `id_region_id` bigint(20) DEFAULT NULL,
  `id_avoirhabitant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt3bg6hafd02afehwphthhspg3` (`id_region_id`),
  KEY `FKjw3360pkbopdoqhwtncq89cuv` (`id_avoirhabitant_id`),
  CONSTRAINT `FKjw3360pkbopdoqhwtncq89cuv` FOREIGN KEY (`id_avoirhabitant_id`) REFERENCES `avoirhabitant` (`id`),
  CONSTRAINT `FKt3bg6hafd02afehwphthhspg3` FOREIGN KEY (`id_region_id`) REFERENCES `regions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitants`
--

LOCK TABLES `habitants` WRITE;
/*!40000 ALTER TABLE `habitants` DISABLE KEYS */;
INSERT INTO `habitants` VALUES (1,3000000,1,1),(2,3500000,1,2),(3,3900000,1,3),(4,2000000,2,1),(5,2300000,2,2),(6,2800000,2,3),(7,3800000,3,1),(8,3900000,3,2),(9,3980000,3,3);
/*!40000 ALTER TABLE `habitants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pays`
--

DROP TABLE IF EXISTS `pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pays` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pays`
--

LOCK TABLES `pays` WRITE;
/*!40000 ALTER TABLE `pays` DISABLE KEYS */;
INSERT INTO `pays` VALUES (1,'Mali'),(2,'Sénégal');
/*!40000 ALTER TABLE `pays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_region` varchar(255) DEFAULT NULL,
  `domaine_activite` varchar(255) DEFAULT NULL,
  `langue_majoritaire` varchar(255) DEFAULT NULL,
  `nom_region` varchar(255) DEFAULT NULL,
  `superficie` varchar(255) DEFAULT NULL,
  `idpays_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh5njs78gp64y57mmo41s4ybpy` (`idpays_id`),
  CONSTRAINT `FKh5njs78gp64y57mmo41s4ybpy` FOREIGN KEY (`idpays_id`) REFERENCES `pays` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'R1','Agriculture','Bambara','Kayes','400000Km2',1),(2,'R4','Pêche','Bambara','Mopti','300000Km2',1),(3,'R','Commerce','Français','Dakar','200000Km2',2);
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-15 11:07:57
