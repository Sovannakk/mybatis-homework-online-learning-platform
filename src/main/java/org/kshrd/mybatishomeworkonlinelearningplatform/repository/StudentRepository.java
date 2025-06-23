package org.kshrd.mybatishomeworkonlinelearningplatform.repository;

import org.apache.ibatis.annotations.*;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Student;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("INSERT INTO students(student_name, email, phone_number) VALUES (#{student.studentName}, #{student.email}, #{student.phoneNumber}) RETURNING student_id")
    Long addNewStudent(@Param("student") StudentRequest studentRequest);

    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "org.kshrd.mybatishomeworkonlinelearningplatform.repository.CourseRepository.findAllCoursesByStudentId"))
    })
    Student findStudentById(Long studentId);

    @Select("UPDATE students SET student_name = #{student.studentName}, email = #{student.email}, phone_number = #{student.phoneNumber} WHERE student_id = #{studentId} RETURNING student_id")
    Long updateInfoStudentById(Long studentId, @Param("student") StudentRequest studentRequest);

    @Delete("DELETE FROM students WHERE student_id = #{studentId}")
    void removeStudentById(Long studentId);

    @Select("SELECT * FROM students OFFSET #{offset} LIMIT #{limit}")
    @ResultMap("studentMapper")
    List<Student> findAllStudents(Integer offset, Integer limit);
}
