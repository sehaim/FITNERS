-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssafit
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `club_board`
--

DROP TABLE IF EXISTS `club_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club_board` (
  `club_id` int NOT NULL,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`club_id`),
  CONSTRAINT `fk_Club_board_Club1` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club_board`
--

LOCK TABLES `club_board` WRITE;
/*!40000 ALTER TABLE `club_board` DISABLE KEYS */;
INSERT INTO `club_board` VALUES (1,'베스트짐 여름 이벤트 안내!','✅여름 이벤트\n1. 기존회원 레슨비 추가할인\n- 레슨비 : 회당 88,000원 -> 회당 55,000원\n- 기존회원 : 회당 88,000원 -> 회당 45,000원\n\n2. 신규회원 추천 이벤트\n- 신규 회원 3명 추천시 프로틴, 스트랩 증정!\n- 신규 회원 5명 추천시 PT 10회 무료 연장','2024-05-22 02:34:01'),(2,'베스트짐 여름 이벤트 안내!','✅여름 이벤트\n1. 기존회원 레슨비 추가할인\n- 레슨비 : 회당 88,000원 -> 회당 55,000원\n- 기존회원 : 회당 88,000원 -> 회당 45,000원\n\n2. 신규회원 추천 이벤트\n- 신규 회원 3명 추천시 프로틴, 스트랩 증정!\n- 신규 회원 5명 추천시 PT 10회 무료 연장','2024-05-22 02:34:31'),(3,'베스트짐 여름 이벤트 안내!','✅여름 이벤트\n1. 기존회원 레슨비 추가할인\n- 레슨비 : 회당 88,000원 -> 회당 55,000원\n- 기존회원 : 회당 88,000원 -> 회당 45,000원\n\n2. 신규회원 추천 이벤트\n- 신규 회원 3명 추천시 프로틴, 스트랩 증정!\n- 신규 회원 5명 추천시 PT 10회 무료 연장','2024-05-22 02:34:38'),(4,'수업 일정 안내','수업은 매주 월/수/금 오전 7시입니다!\n\n불참시 전날 미리 연락 부탁드립니다 :)','2024-05-22 02:35:39'),(5,'5/24 수업 일정 변경 안내','개인 사정으로 인해 5/24 수업을 5/28 로 변경하였습니다.\n\n5/24 오후 8:00 -> 5/28 오후 8:00','2024-05-22 02:38:53'),(6,'','아직 공지사항이 없습니다.','2024-05-22 02:39:08'),(7,'','아직 공지사항이 없습니다.','2024-05-22 02:41:35'),(8,'시간을 잘 지켜주세요.','안전한 경기 진행을 위해 경기 시작 최소 15분 전에 와서 개인 짐 정리, 스트레칭 진행 후 시작하겠습니다.\n\n추가로 이번주 토요일 5/25 참여 투표 바랍니다!','2024-05-22 02:41:15');
/*!40000 ALTER TABLE `club_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 11:42:15
