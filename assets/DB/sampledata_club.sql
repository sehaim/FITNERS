-- -----------------------------------------------------
-- Table `SSAFIT`.`Club`
-- SAMPLE DATA
-- -----------------------------------------------------

INSERT INTO Club (club_id, club_name, club_description, user_id)
VALUES 
(1, "SSAFY 7반 1", "7반 화이팅!", "admin0001"), 
(2, "SSAFY 7반 2", "7반 화이팅!", "admin0002"), 
(3, "6630", "6630 Algorithm study", "admin0003"), 
(4, "아침부터 모하닝", "싸피 7반 알고리즘 스터디입니다.", "admin0004"),
(5, "7반 자치회", "싸피 7반 자치회", "admin0003");

SELECT *
FROM club;

SELECT club_id, club_name, club_description, 
(SELECT user_name
FROM user
WHERE user_id = club.user_id) AS user_name
FROM Club;