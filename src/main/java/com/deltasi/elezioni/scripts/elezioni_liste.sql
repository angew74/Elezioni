-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elezioni
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `liste`
--

DROP TABLE IF EXISTS `liste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `liste` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `denominazione` varchar(200) NOT NULL,
  `denominazione_breve` varchar(20) NOT NULL,
  `progressivo_manifesto` int(10) unsigned DEFAULT NULL,
  `progressivo` int(10) unsigned DEFAULT NULL,
  `coalizioneid` int(10) unsigned DEFAULT NULL,
  `progressivo_coalizione` int(10) unsigned DEFAULT NULL,
  `sindacoid` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fl_liste_tipo_elezione_idx` (`idtipoelezione`),
  KEY `fk_liste_coalizioni_idx` (`progressivo_coalizione`),
  KEY `fk_liste_coalizioni_idx1` (`coalizioneid`),
  KEY `fk_liste_sindaci_idx` (`sindacoid`),
  CONSTRAINT `fk_liste_coalizioni` FOREIGN KEY (`coalizioneid`) REFERENCES `coalizioni` (`id`),
  CONSTRAINT `fk_liste_sindaci` FOREIGN KEY (`sindacoid`) REFERENCES `sindaci` (`id`),
  CONSTRAINT `fl_liste_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liste`
--

LOCK TABLES `liste` WRITE;
/*!40000 ALTER TABLE `liste` DISABLE KEYS */;
INSERT INTO `liste` VALUES (13,1,'Partito Democratico','P.D.',NULL,NULL,NULL,NULL,NULL),(14,1,'Lega Nord','LEGA',NULL,NULL,NULL,NULL,NULL),(15,1,'Fratelli d\'Italia ','F.D.I',NULL,NULL,NULL,NULL,NULL),(16,1,'Movimento 5 Stelle','5 Stelle',NULL,NULL,NULL,NULL,NULL),(17,1,'+ Europa','+ Europa',NULL,NULL,NULL,NULL,NULL),(18,1,'Forza Italia','Forza Italia',NULL,NULL,NULL,NULL,NULL),(19,1,'Movimento Democratico Popolare','M.D.P.',NULL,NULL,NULL,NULL,NULL),(20,1,'Sininistra Italiana','S.I.',NULL,NULL,NULL,NULL,NULL),(21,1,'Potere al Popolo','P. P.',NULL,NULL,NULL,NULL,NULL),(22,1,'Partito Comunista Italiano','P.C.I.',NULL,NULL,NULL,NULL,NULL),(23,1,'Forza Nuova','F.N.',NULL,NULL,NULL,NULL,NULL),(24,1,'Movimento Sociali Italiano','M.S.I.',NULL,NULL,NULL,NULL,NULL),(25,1,'Partito Liberale Italiano ','P.L.I.',NULL,NULL,NULL,NULL,NULL),(26,4,'Partito Democratico','P.D.',1,1,1,1,1),(27,4,'Verdi','Verdi',2,2,1,2,1),(28,4,'Rosa nel Pugno','Rosa nel Pugno',3,3,1,3,1),(29,4,'+Europa','+Europa',4,4,1,4,1),(30,4,'Movimento Democratico Popolare','M.D.P.',5,5,1,5,1),(31,4,'LEGA Salvini Presidente','LEGA',6,6,4,1,4),(33,4,'Fratelli d\'Italia Alleanza Nazionale','F.D.I. A.N.',7,7,4,2,4),(34,4,'Iorio Sindaco','Iorio Sindaco',8,8,5,1,5),(35,4,'Con Giorgia Meloni Sindaco','Con Giorgia Meloni',9,9,4,3,4),(36,4,'Federazione Popolare per la Libertà','Federazione Popolare',10,10,4,4,4),(37,4,'Italia Cristiana','Italia Cristiana',11,11,12,1,12),(38,4,'Partito Comunista','Partito Comunista',12,12,3,1,2),(39,4,'Movimento 5 Stelle','M5 Stelle',13,13,2,1,2),(40,4,'Codacons con Carlo Rienzi','Codacons',14,14,11,1,11),(41,4,'Assotutela con Emi Maritato','Assotutela',15,15,13,1,13),(42,4,'Casa Pound Italia','Casa Pound',16,16,10,1,10),(43,4,'Sinistra x Roma Fassina Sindaco','Sinistra x Roma',17,17,6,1,6),(50,4,'Movimento x Roma ','Movimento x Roma',18,18,9,1,9),(51,4,'Unione Pensionati','Unione Pensionati',19,19,9,2,9),(52,4,'Grillo Parlante No Euro','Grillo Parlante',20,20,9,3,9),(53,4,'Forza Italia','F.I. ',21,21,7,1,7),(54,4,'Lista Civica con Alfio Marchini','Con Alfio Marchini',22,22,7,2,7),(55,4,'Lista Storace con Alfio Marchini','Lista Storace',23,23,7,3,7),(56,4,'Rivoluzione Cristiana','Riv. Cristiana',24,24,7,4,7),(57,4,'Popolo della Famiglia','Popolo Famiglia',25,25,8,1,8);
/*!40000 ALTER TABLE `liste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 20:03:36
