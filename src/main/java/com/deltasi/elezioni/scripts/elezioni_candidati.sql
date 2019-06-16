-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: elezioni
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
-- Table structure for table `candidati`
--

DROP TABLE IF EXISTS `candidati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `candidati` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome_candidato` varchar(200) NOT NULL,
  `cognome_candidato` varchar(200) NOT NULL,
  `sesso_candidato` varchar(1) DEFAULT NULL,
  `progressivo` int(10) unsigned NOT NULL,
  `listaid` int(10) unsigned NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_candidato_lista_progressivo` (`progressivo`,`listaid`,`tipoelezioneid`),
  KEY `fk_candidati_lista_idx` (`listaid`),
  KEY `fk_candidati_tipo_elezione_idx` (`tipoelezioneid`),
  CONSTRAINT `fk_candidati_lista` FOREIGN KEY (`listaid`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_candidati_tipo_elezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidati`
--

LOCK TABLES `candidati` WRITE;
/*!40000 ALTER TABLE `candidati` DISABLE KEYS */;
INSERT INTO `candidati` VALUES (1,'LUCA','ZINGARETTI','M',1,13,1),(2,'MATTEO','RENZI','M',2,13,1),(3,'MATTEO ','SALVINI','M',1,14,1),(4,'SAMANTHA','COZZA','F',2,14,1),(5,'MARIA ELENA','BOSCHI','F',3,13,1),(6,'LUGIA','MARCHINI','F',3,14,1),(7,'GIOVANNA','MELANDRI','F',4,13,1),(8,'ROBERTO','MARONI','M',4,14,1),(9,'NICOLA','ZINGARETTI','M',5,13,1),(10,'PIER LUIGI','BERSANI','M',6,13,1),(11,'WANDA','NARA','F',5,14,1),(16,'ROSY','BINDI','F',7,13,1),(17,'ROBERTO','CALDEROLI','M',6,14,1),(18,'MASSIMO','D\'ALEMA','M',8,13,1),(19,'RENZO','BOSSI','M',7,14,1),(20,'MAURIZIO','CENTOMO','M',8,14,1),(21,'MASSIMO','SMERIGLIO','M',9,13,1),(22,'LUIGI','PAPETTI','M',9,14,1),(23,'ALDA','BALLA','F',10,13,1),(24,'MARINA','MARAFOGLIA','F',10,14,1);
/*!40000 ALTER TABLE `candidati` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 12:15:13
