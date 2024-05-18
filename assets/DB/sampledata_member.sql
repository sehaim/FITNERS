-- -----------------------------------------------------
-- Table `SSAFIT`.`Member`
-- SAMPLE DATA
-- -----------------------------------------------------

-- 싸피 7반 1 멤버 추가
-- 유저 1 ~ 14 / admin0003
INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0001", 1, 1),
("ssafy0002", 1, 1),
("ssafy0003", 1, 1),
("ssafy0004", 1, 1),
("ssafy0005", 1, 1),
("ssafy0006", 1, 1),
("ssafy0007", 1, 1),
("ssafy0008", 1, 1),
("ssafy0009", 1, 1),
("ssafy0010", 1, 1),
("ssafy0011", 1, 1),
("ssafy0012", 1, 1),
("ssafy0013", 1, 1),
("ssafy0014", 1, 1),
("admin0003", 1, 1);

-- 싸피 7반 2 멤버 추가
-- 유저 15 ~ 28 / admin0004
INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0015", 2, 1),
("ssafy0016", 2, 1),
("ssafy0017", 2, 1),
("ssafy0018", 2, 1),
("ssafy0019", 2, 1),
("ssafy0020", 2, 1),
("ssafy0021", 2, 1),
("ssafy0022", 2, 1),
("ssafy0023", 2, 1),
("ssafy0024", 2, 1),
("ssafy0025", 2, 1),
("ssafy0026", 2, 1),
("ssafy0027", 2, 1),
("ssafy0028", 2, 1),
("admin0004", 2, 1);


-- 6630 멤버 추가
INSERT INTO Member (user_id, club_id, access)
VALUES
("ssafy0011", 3, 1),
("ssafy0017", 3, 1),
("ssafy0018", 3, 1),
("ssafy0025", 3, 1),
("admin0003", 3, 1);

-- 아침부터 모하닝 멤버 추가
INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0002", 4, 1),
("ssafy0005", 4, 1),
("ssafy0006", 4, 1),
("ssafy0010", 4, 1),
("ssafy0015", 4, 1),
("ssafy0023", 4, 1),
("admin0004", 4, 1);

-- 7반 자치회 멤버 추가
INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0015", 5, 1),
("ssafy0018", 5, 1),
("admin0003", 5, 1);

-- 가입 요청중 데이터 추가
INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0003", 3, 0),
("ssafy0003", 4, 0),
("ssafy0014", 5, 0);