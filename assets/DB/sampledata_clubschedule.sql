-- -----------------------------------------------------
-- Table `SSAFIT`.`club_schedule`
-- SAMPLE DATA
-- -----------------------------------------------------

INSERT INTO club_schedule (schedule_id, club_id, schedule)
VALUES 
(1, 1, '2024-05-20 09:00:00'),
(2, 1, '2024-05-21 09:00:00'),
(3, 1, '2024-05-22 09:00:00'),
(4, 1, '2024-05-23 09:00:00'),
(5, 1, '2024-05-24 14:00:00'),
(6, 1, '2024-05-24 16:00:00');

INSERT INTO club_schedule (schedule_id, club_id, schedule)
VALUES 
(7, 2, '2024-05-20 09:00:00'),
(8, 2, '2024-05-21 09:00:00'),
(9, 2, '2024-05-22 09:00:00'),
(10, 2, '2024-05-23 09:00:00'),
(11, 2, '2024-05-24 14:00:00'),
(12, 2, '2024-05-24 16:00:00');

INSERT INTO club_schedule (schedule_id, club_id, schedule)
VALUES 
(13, 4, '2024-05-29 08:00:00'),
(14, 4, '2024-06-05 08:00:00');





INSERT INTO user_schedule (user_id, club_id, schedule)
VALUE ("ssafy0002", 1, '2024-05-24 16:00:00');



SELECT schedule_id, user_schedule.user_id, schedule, club.club_name
FROM User_schedule
JOIN club
ON user_schedule.club_id = club.club_id
WHERE user_schedule.user_id = "ssafy0002";