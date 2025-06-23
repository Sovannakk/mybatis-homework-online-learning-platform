CREATE DATABASE online_learning;

CREATE TABLE IF NOT EXISTS instructors
(
    instructor_id   SERIAL PRIMARY KEY,
    instructor_name VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS courses
(
    course_id     SERIAL PRIMARY KEY,
    course_name   VARCHAR(255) NOT NULL,
    description   VARCHAR(255) NOT NULL,
    instructor_id INT          NOT NULL,
    CONSTRAINT instructor_fk FOREIGN KEY (instructor_id) REFERENCES instructors (instructor_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS students
(
    student_id   SERIAL PRIMARY KEY,
    student_name VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    phone_number VARCHAR(10)  NOT NULL
);

CREATE TABLE IF NOT EXISTS student_course
(
    id     SERIAL PRIMARY KEY,
    student_id   INT NOT NULL,
    course_id   INT NOT NULL,
    CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES students (student_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT course_fk FOREIGN KEY (course_id) REFERENCES courses (course_id) ON DELETE CASCADE ON UPDATE CASCADE
);