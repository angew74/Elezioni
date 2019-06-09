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
-- Table structure for table `users_sezioni`
--

DROP TABLE IF EXISTS `users_sezioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_sezioni` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned DEFAULT NULL,
  `sezioneid` int(10) unsigned DEFAULT NULL,
  `idtipoelezione` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_sezioni_sezioni_idx` (`sezioneid`),
  KEY `fk_users_sezioni_users_idx` (`userid`),
  KEY `fk_users_sezione_tipoelezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_users_sezione_tipoelezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_users_sezioni_sezioni` FOREIGN KEY (`sezioneid`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_users_sezioni_users` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_sezioni`
--

LOCK TABLES `users_sezioni` WRITE;
/*!40000 ALTER TABLE `users_sezioni` DISABLE KEYS */;
INSERT INTO `users_sezioni` VALUES (26,114,784,1),(27,114,785,1),(28,114,2685,1),(29,114,2686,1),(30,114,2687,1),(31,114,2689,1),(32,114,2690,1);
/*!40000 ALTER TABLE `users_sezioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 19:01:04
