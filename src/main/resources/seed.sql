
CREATE TABLE IF NOT EXISTS Instructor (
    ID SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20) NOT NULL,
    EMAIL VARCHAR(20) NOT NULL,
    JOINING_DATE TIMESTAMP NOT NULL 
);

CREATE TABLE IF NOT EXISTS Course (
    ID SERIAL PRIMARY KEY,
    TITLE VARCHAR(20),
    INSTRUCTOR_ID INT,
    CONSTRAINT FK_INSTRUCTOR FOREIGN KEY(INSTRUCTOR_ID) REFERENCES Instructor(ID)
);

INSERT INTO Instructor(FIRST_NAME, LAST_NAME, EMAIL, JOINING_DATE) VALUES('Muhammad', 'Fahad', 'email', NOW());
INSERT INTO Instructor(FIRST_NAME, LAST_NAME, EMAIL, JOINING_DATE) VALUES('M', 'Fahad', 'email2', NOW());
INSERT INTO Course(TITLE, INSTRUCTOR_ID) VALUES('Course A', 1);
INSERT INTO Course(TITLE, INSTRUCTOR_ID) VALUES('Course B', 1);
INSERT INTO Course(TITLE, INSTRUCTOR_ID) VALUES('Course C', 2);

DROP TABLE Instructor CASCADE;
DROP TABLE Course;
SELECT * FROM Instructor;
SELECT * FROM Course;
DELETE FROM Instructor;