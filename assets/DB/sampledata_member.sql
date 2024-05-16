-- -----------------------------------------------------
-- Table `SSAFIT`.`Member`
-- SAMPLE DATA
-- -----------------------------------------------------

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
("admin0001", 1, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0013", 2, 1),
("ssafy0014", 2, 1),
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
("admin0002", 2, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0010", 3, 1),
("ssafy0015", 3, 1),
("ssafy0021", 3, 1),
("admin0003", 3, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0004", 4, 1),
("ssafy0005", 4, 1),
("ssafy0009", 4, 1),
("ssafy0019", 4, 1),
("admin0004", 4, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0004", 4, 1),
("ssafy0005", 4, 1),
("ssafy0009", 4, 1),
("ssafy0019", 4, 1),
("admin0004", 4, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("admin0003", 5, 1);

INSERT INTO Member (user_id, club_id, access)
VALUES 
("ssafy0002", 3, 0),
("ssafy0002", 4, 0),
("ssafy0013", 5, 0);

SELECT count(user_id), club_id, (SELECT club_name FROM club WHERE club_id = member.club_id) AS club_name
FROM member
GROUP BY club_id;

SELECT *
FROM member
WHERE access = 0;

