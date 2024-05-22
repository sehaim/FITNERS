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
INSERT INTO `board` VALUES (1,'2024 베스트짐 레슨 모집 여름 이벤트❗️','“Let the results speak”\n결과로 증명하라\n\n2024 베스트짐 레슨 모집 여름 이벤트❗️\n\n✅수년간 쌓아온 경험과 데이터를 통해 보다 실패가 없는 방향으로 트레이닝을 시켜드릴 목적으로 레슨 모집을 합니다\n\n✅선수반/비선수반으로 레슨을 모집합니다\n✅선수반 주 2~3회, 주말반, 경력자 온라인\n2024년 상반기 4월, 5월 대회 출전을 목표로 트레이닝을 시작합니다. 전반적인 시합 계획과 종목 선택, 주기별 트레이닝 방법론을 바탕으로 바디컨디션 체크 및 개개인의 맞춘 영양을 설계하고 실행합니다. 종목에 따른 대회규정과, 규정포즈까지 체크하며 피크위크(peak Week)의 수분 조절/밴딩/로딩까지 선수분들이 무대에 오르는 순간까지 함께 합니다.\n\n모집종목 : 보디빌딩 ,피지크, 클래식, 스포츠모델( 남, 여)\n\n✅비 선수반\n바디프로필 준비, 벌크업, 린매스업, 다이어트 등 개인의 목적에 따라 지도합니다. 직장인, 학생 등을 대상으로 개인에게 맞는 올바른 운동방법과 영양 섭취 타이밍을 지도하여 개개인의 목적 에 도달할 수 있도록 하는 퍼스널 트레이닝으로 본인의 체형에 필요한 운동 방식을 트레이닝을 통해 배워가실 수 있습니다.\n\n✅여름 이벤트\n- 레슨비 : 회당 88,000원 -> 회당 55,000원\n- 레슨장소 : 역삼 베스트짐\n- 레슨신청방법 : 문자 카톡 인스타DM\n\n@the_best_mjkim\n\n#역삼 더베스트 #정성을다하여\n\n레슨문의 상담 자유롭게 문의주시면 친절하게 답변도와드리겠습니다.','admin0001',5214,'2024-05-21 13:13:02'),(2,'프렌즈 FC 팀원 모집','프렌즈 FC 팀원 모집 ❗️\n\n모집팀  (축구팀/풋살팀) :  축구팀/풋살팀\n창단연도 :  2017년\n연령대 :  20~30대\n활동지역(또는 주운동장) :  관악 ㆍ동작 ㆍ서초\n구장상태(맨땅/인조잔디/천연잔디) :  인조잔디\n\n활동시간 :  토요일 11시~15시\n회원수 : 약 50명\n월회비 :  2만원\n가입비 :  15만원, 유니폼지급\n\n- 아침운동하면서 서로 가족같은 분위기로 다치지않게 매너있게 축구하는 팀 입니다. \n- 실력 상관 없이 관심있으신분은 아래 번호 혹은 카카오톡으로 연락주세요\n\n카카오톡 : FCfriendsseoul\n\n전화번호 : 010-123-4567','admin0006',124,'2024-05-21 16:29:17'),(3,'판교 직장인 운동메이트 구해요!','안녕하세요!\n\n저는 판교에서 일하고 있는 직장인입니다. 요즘 앉아서 일하는 시간이 많다 보니 살이 너무 많이 쪄서 운동을 하려고 하는데 혼자 운동하려니 동기부여도 잘 안 되고, 재미도 없더라고요. 그래서 같이 운동할 메이트를 구해보려고 합니다!\n\n운동 장소: 판교 주변 헬스장이나 공원\n운동 시간: 평일 저녁 7시 이후나 주말 오전 시간대\n운동 종류: 헬스장에서 웨이트나 조깅, 간단한 홈트 등 다양하게 생각 중이에요\n\n저도 운동을 막 시작하는 단계라, 초보자 분들도 환영합니다! 서로 으쌰으쌰하며 동기부여도 하고, 즐겁게 운동할 수 있었으면 좋겠어요. 관심 있으신 분들은 댓글 남겨주시거나, 오픈카톡 링크로 들어와 주세요!\n\n오픈카톡 : https://open.kakao.com/o/g12345abc\n\n많은 참여 부탁드려요~!','user0005',143,'2024-05-21 16:44:27'),(4,'헬스 초보자를 위한 효과적인 운동 루틴과 팁(1)!','안녕하세요, 저는 베스트짐 역삼점에서 트레이너로 근무하고 있는 김민준이라고 합니다!\n\n오늘은 헬스를 막 시작하신 분들을 위해 효과적인 운동 루틴과 팁을 공유해드리려고 합니다. 저희 센터에서 회원님들이 많이 궁금해하시는 내용들을 정리해봤으니, 도움이 되셨으면 좋겠어요!\n\n1. 운동 루틴\n\n먼저, 초보자를 위한 주 3일 헬스 루틴을 소개합니다.\n\n월/수/금\n\n워밍업 (5-10분): 러닝머신이나 사이클\n스쿼트 (3세트 x 12회): 하체 근력 강화\n벤치프레스 (3세트 x 10회): 가슴 근력 강화\n데드리프트 (3세트 x 10회): 전신 근력 강화\n덤벨 로우 (3세트 x 12회): 등 근력 강화\n숄더 프레스 (3세트 x 12회): 어깨 근력 강화\n바이셉 컬 (3세트 x 15회): 이두근 강화\n트라이셉 익스텐션 (3세트 x 15회): 삼두근 강화\n마무리 유산소 (15-20분): 러닝머신이나 사이클\n2. 운동 팁\n\n정확한 자세를 유지하세요: 잘못된 자세로 운동하면 부상의 위험이 높아집니다. 초보자는 특히 트레이너나 헬스 유튜브 채널을 통해 정확한 자세를 배우는 것이 중요해요.\n\n천천히 시작하세요: 처음부터 무리한 무게를 들기보다는, 가벼운 무게로 시작해 점차 늘려가는 것이 좋습니다. 근육이 적응할 시간을 주세요.\n\n휴식을 충분히 취하세요: 근육은 운동 중이 아닌 휴식 중에 성장합니다. 충분한 수면과 휴식을 통해 회복 시간을 가지세요.\n\n균형 잡힌 식사를 하세요: 운동만큼 중요한 것이 식사입니다. 단백질, 탄수화물, 지방을 균형 있게 섭취하세요. 운동 후 단백질 보충도 잊지 마세요!\n\n일관성을 유지하세요: 헬스는 꾸준함이 중요합니다. 규칙적으로 운동하고, 꾸준히 이어가는 것이 가장 큰 성공 비결입니다.\n\n3. 추천 운동 앱과 유튜브 채널\n\n앱: MyFitnessPal, Nike Training Club, StrongLifts 5x5\n유튜브 채널: ScottHermanFitness, ATHLEAN-X, FitnessBlender\n마무리\n\n처음 시작하는 헬스가 어렵고 막막하게 느껴질 수 있지만, 위의 루틴과 팁을 참고하시면 조금 더 수월하게 운동을 이어갈 수 있을 거예요. 모두 건강하고 즐거운 운동 생활 하시길 바랍니다!','admin0001',2241,'2024-05-21 16:50:49');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22  1:56:36
