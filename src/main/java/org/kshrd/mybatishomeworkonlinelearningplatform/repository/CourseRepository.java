package org.kshrd.mybatishomeworkonlinelearningplatform.repository;

import org.apache.ibatis.annotations.*;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Course;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("INSERT INTO courses(course_name, description, instructor_id) VALUES (#{course.courseName}, #{course.description}, #{course.instructorId}) RETURNING *")
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.kshrd.mybatishomeworkonlinelearningplatform.repository.InstructorRepository.findInstructorById"))
    })
    Course addNewCourse(@Param("course") CourseRequest courseRequest);

    @Select("SELECT * FROM courses WHERE course_id = #{courseId}")
    @ResultMap("courseMapper")
    Course findCourseById(Long courseId);

    @Select("UPDATE courses SET course_name = #{course.courseName}, description = #{course.description}, instructor_id = #{course.instructorId} WHERE course_id = #{courseId} RETURNING *")
    @ResultMap("courseMapper")
    Course updateCourseById(Long courseId, @Param("course") CourseRequest courseRequest);

    @Delete("DELETE FROM courses WHERE course_id = #{courseId}")
    void removeCourseById(Long courseId);

    @Select("SELECT * FROM courses OFFSET #{offset} LIMIT #{limit}")
    @ResultMap("courseMapper")
    List<Course> findAllCourses(Integer offset, Integer limit);

    @Select("SELECT c.course_id, course_name, description, instructor_id FROM courses c INNER JOIN student_course sc ON c.course_id = sc.course_id WHERE student_id = #{studentId}")
    @ResultMap("courseMapper")
    List<Course> findAllCoursesByStudentId(Long studentId);
}
