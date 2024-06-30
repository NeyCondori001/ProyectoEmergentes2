CREATE DATABASE  IF NOT EXISTS `1111bd_trabajos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `1111bd_trabajos`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: 1111bd_trabajos
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `area1`
--

DROP TABLE IF EXISTS `area1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `area` int DEFAULT NULL,
  `tiempo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `requisitos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ubicacion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion` varchar(400) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area1`
--

LOCK TABLES `area1` WRITE;
/*!40000 ALTER TABLE `area1` DISABLE KEYS */;
INSERT INTO `area1` VALUES (1,'Desarrollador Web',1,'Tiempo completo','Experiencia en HTML/CSS/JavaScript','Ciudad de La Paz','Desarrollo y mantenimiento de aplicaciones web'),(2,'Analista de Datos',1,'Medio tiempo','Conocimientos en análisis estadístico','Ciudad de La Paz','Análisis y visualización de datos para informes internos'),(3,'Ingeniero',1,'medio tiempo','conocimientos en fisica','la paz','para clases '),(4,'Programador',1,'tiempo completo','que sepa alta frontend','la paz','ffefe'),(5,'Programador111',1,'tiempo completo','que sepa alta frontend','la paz','ffefe'),(6,'Programador22222',1,'tiempo completo','que sepa alta frontend','la paz','ffefe'),(7,'Programador222220',1,'tiempo completo','que sepa alta frontend','la paz','ffefe'),(8,'Programador Junior',1,'tiempo completo','que sepa alta frontend','la paz','programador junior en html'),(9,'Programador Junior5555',1,'tiempo completo','que sepa alta frontend','la paz','programador junior en html'),(10,'Doctor',1,'tiempo completo','responsable','la paz','doctor');
/*!40000 ALTER TABLE `area1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area2`
--

DROP TABLE IF EXISTS `area2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `area` int DEFAULT NULL,
  `tiempo` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `requisitos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ubicacion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion` varchar(400) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area2`
--

LOCK TABLES `area2` WRITE;
/*!40000 ALTER TABLE `area2` DISABLE KEYS */;
INSERT INTO `area2` VALUES (1,'Cocinera',2,'Tiempo completo','Experiencia en cocina','La Paz','ayudante de cocina'),(2,'Maestro de construccion',2,'tiempo completo','Conocimientos en obra bruta','Ciudad de La Paz','Se necesita albañil para construccion de una casa'),(3,'ayudante cocina',2,'tiempo completo','que sepa alta cocina','cochabamba','ayudante de cocina para restaurante'),(4,'ayudante de limpieza',2,'tiempo completo','que sepa limpiar bien','santa cruz','ayudante de limpieza para restaurante');
/*!40000 ALTER TABLE `area2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ubicacion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion` varchar(400) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'Pil','Ciudad de La Paz','Empresa líder en proveedor de lacteos.'),(2,'Tigo','Ciudad Cochabamba','Proveedor de servicios de telecomunicaciones en varios países de Latinoamérica.'),(5,'Pollos Copacabana','Teleferico Naranja','Ofrecemos comida rapida, hamburguesas, etc'),(6,'Tigo','Calle potosi','Empresa en telecomunicaciones desde ciudades urbanas a rurales'),(7,'Coca-cola','calle sagarnaga, La Paz','Somos una de las empresas lideres en venta y distribucion de gaseosas.');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimientoempresas`
--

DROP TABLE IF EXISTS `seguimientoempresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimientoempresas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ciudad` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  `empresa_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `empresa_id` (`empresa_id`),
  CONSTRAINT `seguimientoempresas_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `seguimientoempresas_ibfk_2` FOREIGN KEY (`empresa_id`) REFERENCES `empresas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimientoempresas`
--

LOCK TABLES `seguimientoempresas` WRITE;
/*!40000 ALTER TABLE `seguimientoempresas` DISABLE KEYS */;
INSERT INTO `seguimientoempresas` VALUES (1,'Juan','Perez','Calle Principal 123','La Paz','juan.perez@example.com',1234567890,'Deseo adquirir productos lacteos',1,1),(2,'dani','calle','calle las delicias','la paz','calle@gmail.com',0,'deseo atencion de entel',1,1),(8,'Violetta ','Castillo Gomez','calle las delicias 4','la paz 4','vilu@gmail.com',1220210,'solicito atencion en mi internet',16,2);
/*!40000 ALTER TABLE `seguimientoempresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguimientotrabajos`
--

DROP TABLE IF EXISTS `seguimientotrabajos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguimientotrabajos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ciudad` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `celular` int DEFAULT NULL,
  `descripcion1` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion2` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  `area1_id` int DEFAULT NULL,
  `area2_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_id` (`usuario_id`),
  KEY `area1_id` (`area1_id`),
  KEY `area2_id` (`area2_id`),
  CONSTRAINT `seguimientotrabajos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `seguimientotrabajos_ibfk_2` FOREIGN KEY (`area1_id`) REFERENCES `area1` (`id`),
  CONSTRAINT `seguimientotrabajos_ibfk_3` FOREIGN KEY (`area2_id`) REFERENCES `area2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguimientotrabajos`
--

LOCK TABLES `seguimientotrabajos` WRITE;
/*!40000 ALTER TABLE `seguimientotrabajos` DISABLE KEYS */;
INSERT INTO `seguimientotrabajos` VALUES (1,'Juan','Perez','Calle Principal 123','La Paz','Soltero','juan.perez@example.com',1234567890,'Deseo el empleo debido auna falta economica','Trabajo remoto',1,1,1),(3,'dani2222','calle2222','calle las delicias','la paz','soltero','calle@gmail.com',151515,'busco trabajp','sisisiiisisi',3,2,2),(4,'luis','luna','calle las delicias','la paz','soltero','calle@gmail.com',151516,'busco trabajp','sisisiiisisi',1,1,1),(5,'luis GONZALO','luna','calle las delicias','la paz','soltero','calle@gmail.com',121212,'busco trabajp','sisisiiisisi',1,1,1),(6,'dani 700000','calle4','calle las delicias 4','la paz 4','soltero','calle@gmail.com',15165165,'ininjnij','hbubububu',4,2,2),(7,'luis GONZALOZZZZZZZZ','luna','calle las delicias','la paz','soltero','calle@gmail.com',8888888,'FVFRVVR','RBRRGRGR',4,7,4),(8,'luis GONZALOZZZZZZZZ','condori','calle las delicias 4','la paz','soltero','admin@mail.com',6556116,'nucneniue','crrfc444',4,4,3),(9,'luis','mamani','calle las delicias 4','la paz','soltero','luis@hotmail.com',2262626,'Por que necesito ingresos','Trabajo de broso y bancos',14,4,4),(10,'brayan','choque','calle las delicias 4','la paz','soltero','brayan@gmail.com',24563124,'Por que necesito ingresos','Trabaje en teleferico y banco sol',15,4,4),(11,'Violetta ','castillo','calle las delicias 123','cochabamba','soltero','vilu@gmail.com',1651652,'por una necesidad economica','atencion al cliente\r\natencion en banco',16,6,3);
/*!40000 ALTER TABLE `seguimientotrabajos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechanac` date DEFAULT NULL,
  `nombres` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ocupacion` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombreusuario` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'1990-05-15','Juan','Perez','Ingeniero','juan.perez@example.com','contrasena1','juanito','M'),(2,'1985-09-20','Ana','López','Doctora','ana.lopez@example.com','contrasena2','anita','F'),(3,'2024-06-14','dani','calle','Ingeniero','calle@gmail.com','123','danicalle',NULL),(4,'2024-06-06','dani 7888','calle4','Ingeniero agronomo','calle@gmail.com','123','danicalle4',NULL),(5,'2024-06-07','dani 10','calle10','albanil','calle13@gmail.com','123','danicalle13',NULL),(6,'2024-06-04','Richard','Suarez','Estudiante','richi@gmail.com','1234','richi','M'),(7,'2024-06-13','Richard','Suarez','Estudiante','richi@gmail.com','123','danicalle','M'),(8,'2024-05-29','RichardCruz','Suarez','Estudiante','richi@gmail.com','123','danicalle','M'),(9,'2024-06-12','Richard3333','Suarez','Ingeniero agronomo','richi@gmail.com','1234','danicalle','M'),(10,'2024-05-28','richi12','calle','Estudiante','calle@gmail.com','1234','richi','M'),(11,'2024-05-29','richi12','calle','Estudiante','calle@gmail.com','1234','danicalle','M'),(12,'2024-06-12','richi','calle','Estudiante','calle@gmail.com','1234','richi','M'),(13,'2024-06-05','Ale','Condori','Estudiante','ale@gmail.com','1234','ale','F'),(14,'2024-06-12','Luis','Mamani','Estudiante','luis@hotmail.com','1234','luis','M'),(15,'2024-05-29','brayan','choque','Estudiante','brayan@gmail.com','1234','brayan','M'),(16,'1989-06-14','Violetta ','Castillo Gomez','Estudiante','vilu@gmail.com','1234','vilu','F');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database '1111bd_trabajos'
--

--
-- Dumping routines for database '1111bd_trabajos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-30  0:16:38
