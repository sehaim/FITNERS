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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `board_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `view_cnt` int DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`board_id`),
  KEY `fk_Board_User1` (`user_id`),
  CONSTRAINT `fk_Board_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'2024 베스트짐 레슨 모집 여름 이벤트❗️','“Let the results speak”\n결과로 증명하라\n\n2024 베스트짐 레슨 모집 여름 이벤트❗️\n\n✅수년간 쌓아온 경험과 데이터를 통해 보다 실패가 없는 방향으로 트레이닝을 시켜드릴 목적으로 레슨 모집을 합니다\n\n✅선수반/비선수반으로 레슨을 모집합니다\n✅선수반 주 2~3회, 주말반, 경력자 온라인\n2024년 상반기 4월, 5월 대회 출전을 목표로 트레이닝을 시작합니다. 전반적인 시합 계획과 종목 선택, 주기별 트레이닝 방법론을 바탕으로 바디컨디션 체크 및 개개인의 맞춘 영양을 설계하고 실행합니다. 종목에 따른 대회규정과, 규정포즈까지 체크하며 피크위크(peak Week)의 수분 조절/밴딩/로딩까지 선수분들이 무대에 오르는 순간까지 함께 합니다.\n\n모집종목 : 보디빌딩 ,피지크, 클래식, 스포츠모델( 남, 여)\n\n✅비 선수반\n바디프로필 준비, 벌크업, 린매스업, 다이어트 등 개인의 목적에 따라 지도합니다. 직장인, 학생 등을 대상으로 개인에게 맞는 올바른 운동방법과 영양 섭취 타이밍을 지도하여 개개인의 목적 에 도달할 수 있도록 하는 퍼스널 트레이닝으로 본인의 체형에 필요한 운동 방식을 트레이닝을 통해 배워가실 수 있습니다.\n\n✅여름 이벤트\n- 레슨비 : 회당 88,000원 -> 회당 55,000원\n- 레슨장소 : 역삼 베스트짐\n- 레슨신청방법 : 문자 카톡 인스타DM\n\n@the_best_mjkim\n\n#역삼 더베스트 #정성을다하여\n\n레슨문의 상담 자유롭게 문의주시면 친절하게 답변도와드리겠습니다.','admin0001',5216,'2024-05-21 13:13:02'),(2,'프렌즈 FC 팀원 모집','프렌즈 FC 팀원 모집 ❗️\n\n모집팀  (축구팀/풋살팀) :  축구팀/풋살팀\n창단연도 :  2017년\n연령대 :  20~30대\n활동지역(또는 주운동장) :  관악 ㆍ동작 ㆍ서초\n구장상태(맨땅/인조잔디/천연잔디) :  인조잔디\n\n활동시간 :  토요일 11시~15시\n회원수 : 약 50명\n월회비 :  2만원\n가입비 :  15만원, 유니폼지급\n\n- 아침운동하면서 서로 가족같은 분위기로 다치지않게 매너있게 축구하는 팀 입니다. \n- 실력 상관 없이 관심있으신분은 아래 번호 혹은 카카오톡으로 연락주세요\n\n카카오톡 : FCfriendsseoul\n\n전화번호 : 010-123-4567','admin0006',124,'2024-05-21 16:29:17'),(3,'판교 직장인 운동메이트 구해요!','안녕하세요!\n\n저는 판교에서 일하고 있는 직장인입니다. 요즘 앉아서 일하는 시간이 많다 보니 살이 너무 많이 쪄서 운동을 하려고 하는데 혼자 운동하려니 동기부여도 잘 안 되고, 재미도 없더라고요. 그래서 같이 운동할 메이트를 구해보려고 합니다!\n\n운동 장소: 판교 주변 헬스장이나 공원\n운동 시간: 평일 저녁 7시 이후나 주말 오전 시간대\n운동 종류: 헬스장에서 웨이트나 조깅, 간단한 홈트 등 다양하게 생각 중이에요\n\n저도 운동을 막 시작하는 단계라, 초보자 분들도 환영합니다! 서로 으쌰으쌰하며 동기부여도 하고, 즐겁게 운동할 수 있었으면 좋겠어요. 관심 있으신 분들은 댓글 남겨주시거나, 오픈카톡 링크로 들어와 주세요!\n\n오픈카톡 : https://open.kakao.com/o/g12345abc\n\n많은 참여 부탁드려요~!','user0005',143,'2024-05-21 16:44:27'),(4,'헬스 초보자를 위한 효과적인 운동 루틴과 팁(1)!','안녕하세요, 저는 베스트짐 역삼점에서 트레이너로 근무하고 있는 김민준이라고 합니다!\n\n오늘은 헬스를 막 시작하신 분들을 위해 효과적인 운동 루틴과 팁을 공유해드리려고 합니다. 저희 센터에서 회원님들이 많이 궁금해하시는 내용들을 정리해봤으니, 도움이 되셨으면 좋겠어요!\n\n1. 운동 루틴\n\n먼저, 초보자를 위한 주 3일 헬스 루틴을 소개합니다.\n\n월/수/금\n\n워밍업 (5-10분): 러닝머신이나 사이클\n스쿼트 (3세트 x 12회): 하체 근력 강화\n벤치프레스 (3세트 x 10회): 가슴 근력 강화\n데드리프트 (3세트 x 10회): 전신 근력 강화\n덤벨 로우 (3세트 x 12회): 등 근력 강화\n숄더 프레스 (3세트 x 12회): 어깨 근력 강화\n바이셉 컬 (3세트 x 15회): 이두근 강화\n트라이셉 익스텐션 (3세트 x 15회): 삼두근 강화\n마무리 유산소 (15-20분): 러닝머신이나 사이클\n2. 운동 팁\n\n정확한 자세를 유지하세요: 잘못된 자세로 운동하면 부상의 위험이 높아집니다. 초보자는 특히 트레이너나 헬스 유튜브 채널을 통해 정확한 자세를 배우는 것이 중요해요.\n\n천천히 시작하세요: 처음부터 무리한 무게를 들기보다는, 가벼운 무게로 시작해 점차 늘려가는 것이 좋습니다. 근육이 적응할 시간을 주세요.\n\n휴식을 충분히 취하세요: 근육은 운동 중이 아닌 휴식 중에 성장합니다. 충분한 수면과 휴식을 통해 회복 시간을 가지세요.\n\n균형 잡힌 식사를 하세요: 운동만큼 중요한 것이 식사입니다. 단백질, 탄수화물, 지방을 균형 있게 섭취하세요. 운동 후 단백질 보충도 잊지 마세요!\n\n일관성을 유지하세요: 헬스는 꾸준함이 중요합니다. 규칙적으로 운동하고, 꾸준히 이어가는 것이 가장 큰 성공 비결입니다.\n\n3. 추천 운동 앱과 유튜브 채널\n\n앱: MyFitnessPal, Nike Training Club, StrongLifts 5x5\n유튜브 채널: ScottHermanFitness, ATHLEAN-X, FitnessBlender\n마무리\n\n처음 시작하는 헬스가 어렵고 막막하게 느껴질 수 있지만, 위의 루틴과 팁을 참고하시면 조금 더 수월하게 운동을 이어갈 수 있을 거예요. 모두 건강하고 즐거운 운동 생활 하시길 바랍니다!','admin0001',2242,'2024-05-21 16:50:49');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club` (
  `club_id` int NOT NULL AUTO_INCREMENT,
  `club_name` varchar(45) NOT NULL,
  `club_description` varchar(200) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`club_id`),
  KEY `fk_Club_User1` (`user_id`),
  CONSTRAINT `fk_Club_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,'BEST 01','역삼 베스트짐 평일 저녁 그룹PT 1반 - 김민준','admin0001'),(2,'BEST 02','역삼 베스트짐 평일 저녁 그룹PT 2반 - 김민준','admin0001'),(3,'BEST 03','역삼 베스트짐 주말 오전 그룹PT 1반 - 김민준','admin0001'),(4,'365 GYM 01','365 GYM 논현점 월수금 오전 필라테스 그룹레슨 - 김하린','admin0002'),(5,'365 GYM 03','365 GYM 논현점 평일 저녁 필라테스 그룹레슨 - 정소윤','admin0003'),(6,'잠실 수영장 새벽반 1','월수금 새벽반 그룹 강습','admin0004'),(7,'판교 테니스 클럽','판교 테니스 클럽 정기 멤버십','admin0005'),(8,'프렌즈 FC','서울시 관악구 프렌즈 FC','admin0006');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `club_schedule`
--

DROP TABLE IF EXISTS `club_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club_schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `schedule` datetime NOT NULL,
  `club_id` int NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `fk_Club_schedule_Club1` (`club_id`),
  CONSTRAINT `fk_Club_schedule_Club1` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club_schedule`
--

LOCK TABLES `club_schedule` WRITE;
/*!40000 ALTER TABLE `club_schedule` DISABLE KEYS */;
INSERT INTO `club_schedule` VALUES (41,'2024-05-27 18:00:00',1),(42,'2024-05-29 18:00:00',1),(43,'2024-05-31 18:00:00',1),(44,'2024-05-27 20:00:00',2),(45,'2024-05-29 20:00:00',2),(46,'2024-05-31 20:00:00',2),(47,'2024-05-25 10:00:00',3),(48,'2024-06-01 10:00:00',3),(49,'2024-05-27 07:00:00',4),(50,'2024-05-29 07:00:00',4),(51,'2024-05-31 07:00:00',4),(52,'2024-05-28 20:00:00',5),(53,'2024-05-30 20:00:00',5),(54,'2024-06-01 05:00:00',6),(55,'2024-06-03 05:00:00',6),(56,'2024-06-06 05:00:00',6),(57,'2024-06-01 10:00:00',7),(58,'2024-06-08 10:00:00',7),(59,'2024-05-25 11:00:00',8),(60,'2024-06-08 11:00:00',8);
/*!40000 ALTER TABLE `club_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `user_id` varchar(20) NOT NULL,
  `club_id` int NOT NULL,
  `access` tinyint NOT NULL,
  PRIMARY KEY (`user_id`,`club_id`),
  KEY `fk_Member_Club1` (`club_id`),
  CONSTRAINT `fk_Member_Club1` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Member_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('admin0001',1,1),('admin0001',2,1),('admin0001',3,1),('admin0002',4,1),('admin0003',5,1),('admin0004',6,1),('admin0005',7,1),('admin0006',8,1),('user0001',1,1),('user0001',8,1),('user0002',4,1),('user0002',7,1),('user0003',3,0),('user0003',6,1),('user0003',7,1),('user0004',1,1),('user0004',8,1),('user0005',5,1),('user0006',2,1),('user0006',8,1),('user0007',3,1),('user0007',6,1),('user0008',3,1),('user0008',4,0),('user0009',2,1),('user0009',8,1),('user0010',1,1),('user0010',8,1),('user0011',5,1),('user0011',7,1),('user0012',1,1),('user0012',8,0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_name` varchar(10) NOT NULL,
  `isManager` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin0001','admin0001@','김민준',1),('admin0002','admin0002@','김하린',1),('admin0003','admin0003@','정소윤',1),('admin0004','admin0004@','정연우',1),('admin0005','admin0005@','이승환',1),('admin0006','admin0006@','이도윤',1),('ssafy0001','ssafy0001@','권용수',0),('ssafy0002','ssafy0002@','김기창',0),('ssafy0003','ssafy0003@','김윤홍',0),('ssafy0004','ssafy0004@','김재현',0),('ssafy0005','ssafy0005@','김주형',0),('ssafy0006','ssafy0006@','김현재',0),('ssafy0007','ssafy0007@','문선정',0),('ssafy0008','ssafy0008@','민예림',0),('ssafy0009','ssafy0009@','박건택',0),('ssafy0010','ssafy0010@','박희연',0),('ssafy0011','ssafy0011@','배성진',0),('ssafy0012','ssafy0012@','서희',0),('ssafy0013','ssafy0013@','손영준',0),('ssafy0014','ssafy0014@','송창용',0),('ssafy0015','ssafy0015@','신승호',0),('ssafy0016','ssafy0016@','유서현',0),('ssafy0017','ssafy0017@','육민우',0),('ssafy0018','ssafy0018@','육예진',0),('ssafy0019','ssafy0019@','이재영',0),('ssafy0020','ssafy0020@','이현우',0),('ssafy0021','ssafy0021@','임가현',0),('ssafy0022','ssafy0022@','임세하',0),('ssafy0023','ssafy0023@','최장우',0),('ssafy0024','ssafy0024@','표다영',0),('ssafy0025','ssafy0025@','한도형',0),('ssafy0026','ssafy0026@','한진형',0),('ssafy0027','ssafy0027@','홍주형',0),('ssafy0028','ssafy0028@','황민욱',0),('user0001','user0001@','김서준',0),('user0002','user0002@','이수민',0),('user0003','user0003@','박민서',0),('user0004','user0004@','정예준',0),('user0005','user0005@','강하윤',0),('user0006','user0006@','조민준',0),('user0007','user0007@','윤하린',0),('user0008','user0008@','임서진',0),('user0009','user0009@','최지호',0),('user0010','user0010@','한유준',0),('user0011','user0011@','배지안',0),('user0012','user0012@','장서현',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_schedule`
--

DROP TABLE IF EXISTS `user_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `club_id` int NOT NULL,
  `schedule` datetime NOT NULL,
  PRIMARY KEY (`schedule_id`),
  KEY `fk_User_schedule_User1` (`user_id`),
  KEY `fk_User_schedule_Club1` (`club_id`),
  CONSTRAINT `fk_User_schedule_Club1` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_User_schedule_User1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_schedule`
--

LOCK TABLES `user_schedule` WRITE;
/*!40000 ALTER TABLE `user_schedule` DISABLE KEYS */;
INSERT INTO `user_schedule` VALUES (1,'user0001',1,'2024-05-27 18:00:00'),(2,'user0001',1,'2024-05-29 18:00:00'),(3,'user0001',1,'2024-05-31 18:00:00'),(4,'user0001',8,'2024-06-08 11:00:00'),(5,'user0002',4,'2024-05-27 07:00:00'),(6,'user0002',4,'2024-05-31 07:00:00'),(7,'user0002',7,'2024-06-08 10:00:00'),(8,'user0003',6,'2024-06-03 05:00:00'),(9,'user0003',6,'2024-06-06 05:00:00'),(10,'user0003',7,'2024-06-01 10:00:00'),(11,'user0004',1,'2024-05-27 18:00:00'),(12,'user0004',1,'2024-05-29 18:00:00'),(13,'user0004',1,'2024-05-31 18:00:00'),(14,'user0004',8,'2024-05-25 11:00:00'),(15,'user0004',8,'2024-06-08 11:00:00'),(16,'user0005',5,'2024-05-28 20:00:00'),(17,'user0005',5,'2024-05-30 20:00:00'),(19,'user0006',2,'2024-05-29 20:00:00'),(20,'user0006',2,'2024-05-31 20:00:00'),(21,'user0006',8,'2024-05-25 11:00:00'),(22,'user0006',8,'2024-06-08 11:00:00'),(23,'user0007',3,'2024-06-01 10:00:00'),(25,'user0007',6,'2024-06-06 05:00:00'),(26,'user0008',3,'2024-06-01 10:00:00'),(27,'user0008',3,'2024-05-25 10:00:00'),(28,'user0009',2,'2024-05-29 20:00:00'),(29,'user0009',2,'2024-05-31 20:00:00'),(30,'user0009',2,'2024-05-27 20:00:00'),(31,'user0009',8,'2024-06-08 11:00:00'),(32,'user0010',1,'2024-05-27 18:00:00'),(33,'user0010',1,'2024-05-29 18:00:00'),(34,'user0010',1,'2024-05-31 18:00:00'),(36,'user0010',8,'2024-06-08 11:00:00'),(37,'user0012',1,'2024-05-27 18:00:00'),(38,'user0012',1,'2024-05-29 18:00:00'),(39,'user0012',1,'2024-05-31 18:00:00');
/*!40000 ALTER TABLE `user_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 11:56:59
