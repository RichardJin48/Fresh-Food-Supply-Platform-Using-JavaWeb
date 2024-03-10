-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cdut
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ann`
--

DROP TABLE IF EXISTS `ann`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ann` (
  `ann_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `content` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL,
  `release_time` timestamp NULL DEFAULT NULL,
  `modified_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ann_id`),
  UNIQUE KEY `ann_ann_id_uindex` (`ann_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ann`
--

LOCK TABLES `ann` WRITE;
/*!40000 ALTER TABLE `ann` DISABLE KEYS */;
INSERT INTO `ann` VALUES (1,'Big Sale','The promotion will continue until June.','2022-09-23 09:13:24','2023-05-23 00:53:15');
/*!40000 ALTER TABLE `ann` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beh`
--

DROP TABLE IF EXISTS `beh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beh` (
  `beh_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `product_id` bigint NOT NULL,
  `beh_count` int DEFAULT NULL,
  `beh_time` timestamp NOT NULL,
  `beh_type` int NOT NULL,
  PRIMARY KEY (`beh_id`),
  UNIQUE KEY `beh_beh_id_uindex` (`beh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beh`
--

LOCK TABLES `beh` WRITE;
/*!40000 ALTER TABLE `beh` DISABLE KEYS */;
INSERT INTO `beh` VALUES (42,1,8,0,'2023-03-14 00:29:46',1),(51,1,11,0,'2023-04-19 01:36:15',1),(52,1,5,0,'2023-04-19 01:59:04',1),(53,1,10,0,'2023-05-23 00:40:11',1),(55,1,14,0,'2023-05-23 01:25:20',1);
/*!40000 ALTER TABLE `beh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `addr` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sign` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `question` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `answer` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_username_uindex` (`username`),
  UNIQUE KEY `customer_customer_id_uindex` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'jzc','7a20603b2321e5ad941810026e02d280','Richard','Male','13348970531','CDUT','I love IPD!','1','cdut'),(2,'xsw','202cb962ac59075b964b07152d234b70','Anthony','Male','','123','123',NULL,NULL),(3,'zzz','81dc9bdb52d04dc20036dbd8313ed055','Wade','Male','','1234','1234',NULL,NULL),(6,'lyx','b7c25fc37f23767029042320a5724ab0','Casper','Male','','543','9876543',NULL,NULL),(7,'jzc2','7a20603b2321e5ad941810026e02d280','jzc','Male','13348970531','Jin Niu','123456789',NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_card` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `dept` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_id_card_uindex` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'Richard','12','7a20603b2321e5ad941810026e02d280','IT','Male',20,'13348970531'),(2,'Anthony','123','202cb962ac59075b964b07152d234b70','Big Data','Male',20,'123'),(4,'Edward','1234','81dc9bdb52d04dc20036dbd8313ed055','Development','Male',20,'789'),(6,'Beryl','09876','6531401f9a6807306651b87e44c05751','Finance','Male',20,'789');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_master`
--

DROP TABLE IF EXISTS `order_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_master` (
  `order_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `customer_id` int unsigned NOT NULL,
  `product_id` bigint unsigned NOT NULL,
  `shipping_user` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `order_money` decimal(8,2) NOT NULL,
  `product_amount` int DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shipping_time` timestamp NULL DEFAULT NULL,
  `receive_time` timestamp NULL DEFAULT NULL,
  `order_status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_master`
--

LOCK TABLES `order_master` WRITE;
/*!40000 ALTER TABLE `order_master` DISABLE KEYS */;
INSERT INTO `order_master` VALUES (30,'1-8-d',1,8,'123','123','123',5.00,5,'2023-03-12 06:18:51','2023-04-03 06:26:21','2023-04-03 06:26:31',4),(31,'1-7-23',1,7,'123','123','123',12.00,6,'2023-03-12 06:19:28',NULL,NULL,0),(32,'1-8-22',1,8,'123','123','123',3.00,3,'2023-03-12 06:19:29',NULL,NULL,1),(34,'1-8-d',1,8,'123','123','123',2.00,2,'2023-03-21 11:35:27',NULL,NULL,1),(35,'1-7-25',1,7,'123','123','123',6.00,3,'2023-03-21 11:38:43',NULL,NULL,1),(36,'1-8-24',1,8,'123','123','123',1.00,1,'2023-04-04 00:25:38','2023-04-03 06:25:03','2023-04-03 06:25:51',3),(37,'1-10-d',1,10,'1','1','1',2.20,1,'2023-03-22 10:29:40','2023-04-04 00:26:05','2023-04-04 00:26:28',4),(38,'1-12-d',1,12,'123','123','123',12.00,1,'2023-04-03 07:16:29',NULL,NULL,1),(39,'1-12-d',1,12,'Casper','123456','113',12.00,1,'2023-05-16 04:22:43',NULL,NULL,1),(40,'1-12-26',1,12,'123','123','123',36.00,3,'2023-05-23 00:47:16',NULL,NULL,1),(41,'1-4-30',1,4,'Richard','13348970531','CDUT',12.25,1,'2023-05-23 00:47:58','2023-05-23 00:45:07','2023-05-23 00:48:34',4),(42,'1-11-29',1,11,'Richard','13348970531','CDUT',68.00,2,'2023-05-23 00:43:27','2023-05-23 00:44:45','2023-05-23 00:45:24',2);
/*!40000 ALTER TABLE `order_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `category_id` bigint unsigned NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `publish_status` tinyint NOT NULL DEFAULT '0',
  `weight` float DEFAULT NULL,
  `production_date` datetime NOT NULL,
  `descript` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int unsigned NOT NULL DEFAULT '0',
  `sales_volume` int unsigned NOT NULL DEFAULT '0',
  `recommend` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `indate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `pic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (4,'Chicken',3,12.25,1,1.1,'2022-11-02 00:00:00','This is a chicken.',999,2,'Yes','2022-09-24 01:13:46','2023-05-22 23:41:39','static/images/1684798899335_chicken.jpg'),(5,'Pork',3,25.00,1,1.1,'2022-11-11 00:00:00','This is pork.',1000,1,'No','2022-09-24 01:09:12','2023-05-22 23:38:35','static/images/1684798715474_t01ed1cf8536f704c84.jpg'),(6,'Carrot',5,1.25,1,1.1,'2022-11-22 00:00:00','These are carrots.',1230,1,'No','2022-09-24 01:09:14','2023-05-22 23:42:17','static/images/1684798686586_carrot.jpg'),(7,'Potato',5,2.00,1,1234,'2022-12-01 00:00:00','These are potatoes.',12348,231,'No','2022-09-24 01:11:25','2023-05-22 23:41:06','static/images/1684798523584_potatoes.jpg'),(8,'Cabbage',5,1.00,1,123,'2022-12-06 00:00:00','These are cabbages.',1231,1237,'Yes','2022-09-24 03:56:01','2023-05-22 23:42:33','static/images/1684774084221_cabbage-04.jpg'),(10,'Apple',1,2.20,1,12,'2022-11-01 00:00:00','These are apple.',999,1,'Yes','2023-03-22 10:27:57','2023-05-22 23:43:00','static/images/1684771983659_屏幕截图 2023-05-12 122648.png'),(11,'Fish',2,34.00,1,1234,'2022-11-01 00:00:00','This is a fish.',1232,2,'Yes','2023-04-03 02:58:34','2023-05-22 23:40:08','static/images/1684773702632_t011badf2f0d0bcd187.jpg'),(12,'Frozen Dumplings',4,12.00,1,123,'2023-01-01 00:00:00','These are frozen dumplings.',118,5,'Yes','2023-04-03 02:59:19','2023-05-22 23:39:56','static/images/1684774028609_01fe9959ee0207a801202b0c06ef90.jpg@2o.jpg'),(13,'Shrimp',2,20.00,1,12,'2023-05-01 00:00:00','This is a shrimp.',1234,0,'No','2023-05-23 00:21:06','2023-05-23 00:21:15','static/images/1684801275271_01a2a25c1b542ea8012029ace1b5db.jpg@1280w_1l_2o_100sh.jpg'),(14,'Ice Cream',4,4.00,1,5,'2023-05-02 00:00:00','This is an ice cream.',1234,0,'Yes','2023-05-23 00:23:12','2023-05-23 00:23:48','static/images/1684801428334_688832.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `category_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `category_status` tinyint NOT NULL DEFAULT '1',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (3,'Meat',1,'2023-04-03 02:45:16'),(5,'Vegetable',1,'2023-04-03 02:45:06');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `cart_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int unsigned NOT NULL,
  `product_id` bigint unsigned NOT NULL,
  `product_amount` int NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-10 18:18:47
