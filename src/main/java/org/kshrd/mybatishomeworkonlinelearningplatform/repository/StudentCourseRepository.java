package org.kshrd.mybatishomeworkonlinelearningplatform.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseRepository {
    @Insert("INSERT INTO student_course(student_id, course_id) VALUES (#{studentId}, #{courseId})")
    void insertStudentIdAndCourseIdIntoStudentCourse(Long studentId, Long courseId);

    @Delete("DELETE FROM student_course WHERE student_id = #{studentId}")
    void deleteStudentIdAndCourseIdFromStudentCourseByStudentId(Long studentId);
}
