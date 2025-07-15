-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: industria_db
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
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `cargo` varchar(25) NOT NULL,
  `id_setor` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_setor` (`id_setor`),
  CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`id_setor`) REFERENCES `setores` (`id_setores`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'João Oliveira','Operador',1),(2,'Lucas Pereira','Motorista',2),(3,'Amanda Silva','Analista de RH',3),(4,'Bruno Santos','Contador',4),(5,'Camila Dias','Publicitária',5),(6,'Fernando Costa','Programador',6),(7,'Carla Ramos','Vendedor',7),(8,'Marcelo Alves','Comprador',8),(9,'Tatiane Lima','Inspetor',9),(10,'Diego Rocha','Técnico',10),(11,'Renata Souza','Advogado',11),(12,'Jéssica Cunha','Auxiliar',12),(13,'Pedro Nunes','Representante',13),(14,'Mariana Tavares','Engenheira',14),(15,'Igor Mendes','Suporte Técnico',15),(16,'Natália Martins','Pesquisadora',16),(17,'Eduardo Gomes','Estoquista',17),(18,'Beatriz Farias','Atendente',18),(19,'Gabriel Henrique','Faxineiro',19),(20,'Lucia Vieira','Instrutora',20);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producao`
--

DROP TABLE IF EXISTS `producao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producao` (
  `id_producao` int NOT NULL AUTO_INCREMENT,
  `id_produtos` int NOT NULL,
  `id_funcionario` int NOT NULL,
  `data_producao` date DEFAULT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id_producao`),
  KEY `id_produtos` (`id_produtos`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `producao_ibfk_1` FOREIGN KEY (`id_produtos`) REFERENCES `produtos` (`id_produtos`),
  CONSTRAINT `producao_ibfk_2` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao`
--

LOCK TABLES `producao` WRITE;
/*!40000 ALTER TABLE `producao` DISABLE KEYS */;
INSERT INTO `producao` VALUES (1,1,1,'2025-06-01',150),(2,2,2,'2025-06-02',120),(3,3,3,'2025-06-03',90),(4,4,4,'2025-06-04',85),(5,5,5,'2025-06-05',100),(6,6,6,'2025-06-06',70),(7,7,7,'2025-06-07',200),(8,8,8,'2025-06-08',110),(9,9,9,'2025-06-09',160),(10,10,10,'2025-06-10',130),(11,11,11,'2025-06-11',95),(12,12,12,'2025-06-12',180),(13,13,13,'2025-06-13',170),(14,14,14,'2025-06-14',140),(15,15,15,'2025-06-15',155),(16,16,16,'2025-06-16',125),(17,17,17,'2025-06-17',135),(18,18,18,'2025-06-18',190),(19,19,19,'2025-06-19',210),(20,20,20,'2025-06-20',175);
/*!40000 ALTER TABLE `producao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produtos` int NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(25) NOT NULL,
  `descricao` varchar(25) NOT NULL,
  PRIMARY KEY (`id_produtos`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Parafuso','Aço 5cm'),(2,'Porca','Latão 2cm'),(3,'Arruela','Metal 3cm'),(4,'Chave Inglesa','Ferramenta grande'),(5,'Martelo','Cabo de madeira'),(6,'Broca','Aço rápido'),(7,'Serra','Lâmina 18cm'),(8,'Alicate','Universal'),(9,'Trena','5 metros'),(10,'Nível','Borracha com bolha'),(11,'Furadeira','500W potência'),(12,'Prego','Caixa 100un'),(13,'Fita Isolante','10 metros'),(14,'Cola Instantânea','10g'),(15,'Parafusadeira','Bateria 12V'),(16,'Lixa','Madeira fina'),(17,'Espátula','Metal 10cm'),(18,'Estilete','Lâmina retrátil'),(19,'Luvas','Tamanho M'),(20,'Capacete','Segurança amarelo');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setores`
--

DROP TABLE IF EXISTS `setores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setores` (
  `id_setores` int NOT NULL AUTO_INCREMENT,
  `nome_setor` varchar(25) NOT NULL,
  `responsavel` varchar(25) NOT NULL,
  PRIMARY KEY (`id_setores`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setores`
--

LOCK TABLES `setores` WRITE;
/*!40000 ALTER TABLE `setores` DISABLE KEYS */;
INSERT INTO `setores` VALUES (1,'Produção','Carlos Silva'),(2,'Logística','Ana Souza'),(3,'RH','Marcos Lima'),(4,'Financeiro','Juliana Ramos'),(5,'Marketing','Paulo Mendes'),(6,'TI','Fernanda Costa'),(7,'Comercial','Rafael Almeida'),(8,'Compras','Luciana Dias'),(9,'Qualidade','Bruno Rocha'),(10,'Manutenção','Isabela Nunes'),(11,'Jurídico','Renato Tavares'),(12,'Expedição','Camila Freitas'),(13,'Vendas','Eduardo Cunha'),(14,'Engenharia','Patrícia Gomes'),(15,'Suporte','Thiago Pinto'),(16,'Pesquisa','Larissa Martins'),(17,'Estoque','Daniel Farias'),(18,'Atendimento','Sofia Carvalho'),(19,'Serviços Gerais','Fábio Henrique'),(20,'Treinamento','Simone Vieira');
/*!40000 ALTER TABLE `setores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-15 18:08:17
