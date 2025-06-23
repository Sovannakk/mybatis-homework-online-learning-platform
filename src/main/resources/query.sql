-- Instructor Query

INSERT INTO instructors(instructor_name, email) VALUES ('string', 'string@gmail.com') RETURNING *;

SELECT * FROM instructors WHERE instructor_id = 1;

UPDATE instructors SET instructor_name = 'string', email = 'string@gmail.com' WHERE instructor_id = 1 RETURNING *;

DELETE FROM instructors WHERE instructor_id = 1;

SELECT * FROM instructors OFFSET 3 LIMIT 3;

-- Student Query

INSERT INTO students(student_name, email, phone_number) VALUES ('string', 'string@gmail.com', '0123456789') RETURNING *;

SELECT * FROM students WHERE student_id = 10;

UPDATE students SET student_name = 'string', email = 'string@gmail.com', phone_number = '0123456789' WHERE student_id = 1 RETURNING *;

DELETE FROM students WHERE student_id = 1;

SELECT * FROM students OFFSET 3 LIMIT 3;

-- Course Query

INSERT INTO courses(course_name, description, instructor_id) VALUES ('string', 'string', 1) RETURNING *;

SELECT * FROM courses WHERE course_id = 1;

UPDATE courses SET course_name = 'string', description = 'string', instructor_id = '1' WHERE course_id = 1 RETURNING *;

DELETE FROM courses WHERE course_id = 1;

SELECT * FROM courses OFFSET 3 LIMIT 3;

SELECT c.course_id, course_name, description, instructor_id FROM courses c INNER JOIN student_course sc ON c.course_id = sc.course_id WHERE student_id = 1;

-- StudentCourse Query

INSERT INTO student_course(student_id, course_id) VALUES (1, 1);

DELETE FROM student_course WHERE student_id = 1;