DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50),
                         grade INT,
                         professor_email VARCHAR(100)
);

CREATE TABLE diagnosis (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           student_id BIGINT,
                           status VARCHAR(20),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 테스트 데이터 (비교하기 좋게 3학년, 4학년 섞어서)
INSERT INTO student (name, grade, professor_email) VALUES ('홍길동', 1, 'prof@univ.ac.kr');
INSERT INTO student (name, grade, professor_email) VALUES ('한둘리', 2, 'prof@univ.ac.kr');
INSERT INTO student (name, grade, professor_email) VALUES ('김철수', 3, 'prof@univ.ac.kr');
INSERT INTO student (name, grade, professor_email) VALUES ('이영희', 4, 'prof@univ.ac.kr');
