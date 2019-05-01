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
  `idcoalizione` int(10) unsigned DEFAULT NULL,
  `progressivo_manifesto` int(10) unsigned DEFAULT NULL,
  `progressivo` int(10) unsigned DEFAULT NULL,
  `progressivo_coalizione` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fl_liste_tipo_elezione_idx` (`idtipoelezione`),
  KEY `fk_coalizioni_liste_idx` (`idcoalizione`),
  CONSTRAINT `fk_coalizioni_liste` FOREIGN KEY (`idcoalizione`) REFERENCES `liste` (`id`),
  CONSTRAINT `fl_liste_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liste`
--

LOCK TABLES `liste` WRITE;
/*!40000 ALTER TABLE `liste` DISABLE KEYS */;
INSERT INTO `liste` VALUES (13,1,'Partito Democratico','P.D.',NULL,NULL,NULL,NULL),(14,1,'Lega Nord','LEGA',NULL,NULL,NULL,NULL),(15,1,'Fratelli d\'Italia ','F.D.I',NULL,NULL,NULL,NULL),(16,1,'Movimento 5 Stelle','5 Stelle',NULL,NULL,NULL,NULL),(17,1,'+ Europa','+ Europa',NULL,NULL,NULL,NULL),(18,1,'Forza Italia','Forza Italia',NULL,NULL,NULL,NULL),(19,1,'Movimento Democratico Popolare','M.D.P.',NULL,NULL,NULL,NULL),(20,1,'Sininistra Italiana','S.I.',NULL,NULL,NULL,NULL),(21,1,'Potere al Popolo','P. P.',NULL,NULL,NULL,NULL),(22,1,'Partito Comunista Italiano','P.C.I.',NULL,NULL,NULL,NULL),(23,1,'Forza Nuova','F.N.',NULL,NULL,NULL,NULL),(24,1,'Movimento Sociali Italiano','M.S.I.',NULL,NULL,NULL,NULL),(25,1,'Partito Liberale Italiano ','P.L.I.',NULL,NULL,NULL,NULL);
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

-- Dump completed on 2019-05-01 20:47:18
