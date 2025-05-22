-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: agrohelp
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `planta`
--

DROP TABLE IF EXISTS `planta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planta` (
  `idPlanta` int NOT NULL AUTO_INCREMENT,
  `nomePlanta` varchar(200) DEFAULT NULL,
  `texturaSoloIdeial` varchar(200) DEFAULT NULL,
  `tempoIrrigacao` int DEFAULT NULL,
  `tempoColheita` int DEFAULT NULL,
  `condicaoColheita` varchar(200) DEFAULT NULL,
  `relevoIdeial` varchar(200) DEFAULT NULL,
  `climaIdeal` varchar(200) DEFAULT NULL,
  `estadoRecomendado` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idPlanta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planta`
--

LOCK TABLES `planta` WRITE;
/*!40000 ALTER TABLE `planta` DISABLE KEYS */;
INSERT INTO `planta` VALUES (1,'Soja','Média a argilosa',7,120,'Grãos maduros com teor de umidade de 13% a 15%','Plano a levemente ondulado','Temperaturas entre 20°C e 30°C, sem geadas','MT, PR, GO, SP'),(2,'Milho','Solo arenoso ou franco-argiloso',10,120,'Grãos secos e firmes, com a casca durificada','Plano','Temperaturas entre 18°C e 30°C, com boa radiação solar','MT, GO, MS, BA'),(3,'Tomate','Solo leve e bem drenado, com pH de 6 a 6,8',5,90,'Frutos firmes e de cor vermelha intensa, com pouco defeito','Plano ou levemente ondulado','Temperaturas entre 18°C e 25°C, sem geadas','SP, MG, PR');
/*!40000 ALTER TABLE `planta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-22  9:16:27
