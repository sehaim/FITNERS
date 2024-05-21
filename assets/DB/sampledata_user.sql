-- -----------------------------------------------------
-- Table `SSAFIT`.`User` 
-- SAMPLE DATA
-- -----------------------------------------------------

-- 일반 사용자 샘플 1
INSERT INTO User (user_id, user_name, user_password, isManager)
VALUES 
("ssafy0001", "권용수", "ssafy0001@", 0),
("ssafy0002", "김기창", "ssafy0002@", 0),
("ssafy0003", "김윤홍", "ssafy0003@", 0),
("ssafy0004", "김재현", "ssafy0004@", 0),
("ssafy0005", "김주형", "ssafy0005@", 0),
("ssafy0006", "김현재", "ssafy0006@", 0),
("ssafy0007", "문선정", "ssafy0007@", 0),
("ssafy0008", "민예림", "ssafy0008@", 0),
("ssafy0009", "박건택", "ssafy0009@", 0),
("ssafy0010", "박희연", "ssafy0010@", 0),
("ssafy0011", "배성진", "ssafy0011@", 0),
("ssafy0012", "서희", "ssafy0012@", 0),
("ssafy0013", "손영준", "ssafy0013@", 0),
("ssafy0014", "송창용", "ssafy0014@", 0),
("ssafy0015", "신승호", "ssafy0015@", 0),
("ssafy0016", "유서현", "ssafy0016@", 0),
("ssafy0017", "육민우", "ssafy0017@", 0),
("ssafy0018", "육예진", "ssafy0018@", 0),
("ssafy0019", "이재영", "ssafy0019@", 0),
("ssafy0020", "이현우", "ssafy0020@", 0),
("ssafy0021", "임가현", "ssafy0021@", 0),
("ssafy0022", "임세하", "ssafy0022@", 0),
("ssafy0023", "최장우", "ssafy0023@", 0),
("ssafy0024", "표다영", "ssafy0024@", 0),
("ssafy0025", "한도형", "ssafy0025@", 0),
("ssafy0026", "한진형", "ssafy0026@", 0),
("ssafy0027", "홍주형", "ssafy0027@", 0),
("ssafy0028", "황민욱", "ssafy0028@", 0);

-- 일반 사용자 샘플 2
INSERT INTO User (user_id, user_name, user_password, isManager)
VALUES 
("user0001", "김서준", "user0001@", 0),
("user0002", "이수민", "user0002@", 0),
("user0003", "박민서", "user0003@", 0),
("user0004", "정예준", "user0004@", 0),
("user0005", "강하윤", "user0005@", 0),
("user0006", "조민준", "user0006@", 0),
("user0007", "윤하린", "user0007@", 0),
("user0008", "임서진", "user0008@", 0),
("user0009", "최지호", "user0009@", 0),
("user0010", "한유준", "user0010@", 0),
("user0011", "배지안", "user0011@", 0),
("user0012", "장서현", "user0012@", 0);


-- 매니저 샘플 1
INSERT INTO User (user_id, user_name, user_password, isManager)
VALUES 
("admin0001", "김민준", "admin0001@", 1),
("admin0002", "이상민", "admin0002@", 1),
("admin0003", "박지훈", "admin0003@", 1),
("admin0004", "정연우", "admin0004@", 1),
("admin0005", "김하린", "admin0005@", 1),
("admin0006", "이도윤", "admin0006@", 1),
("admin0007", "박준서", "admin0007@", 1),
("admin0008", "한서현", "admin0008@", 1),
("admin0009", "김다은", "admin0009@", 1),
("admin0010", "최유진", "admin0010@", 1),
("admin0011", "오승준", "admin0011@", 1),
("admin0012", "임하린", "admin0012@", 1),
("admin0013", "신지후", "admin0013@", 1),
("admin0014", "문수아", "admin0014@", 1),
("admin0015", "정하윤", "admin0015@", 1);
