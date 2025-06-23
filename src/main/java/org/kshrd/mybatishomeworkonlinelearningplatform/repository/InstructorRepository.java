package org.kshrd.mybatishomeworkonlinelearningplatform.repository;

import org.apache.ibatis.annotations.*;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Instructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("INSERT INTO instructors(instructor_name, email) VALUES (#{instructor.instructorName}, #{instructor.email}) RETURNING *")
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name")
    })
    Instructor addNewInstructor(@Param("instructor") InstructorRequest instructorRequest);

    @Select("SELECT * FROM instructors WHERE instructor_id = #{instructorId}")
    @ResultMap("instructorMapper")
    Instructor findInstructorById(Long instructorId);

    @Select("UPDATE instructors SET instructor_name = #{instructor.instructorName}, email = #{instructor.email} WHERE instructor_id = #{instructorId} RETURNING *")
    @ResultMap("instructorMapper")
    Instructor updateInfoInstructorById(Long instructorId, @Param("instructor") InstructorRequest instructorRequest);

    @Delete("DELETE FROM instructors WHERE instructor_id = #{instructorId}")
    void removeInstructorById(Long instructorId);

    @Select("SELECT * FROM instructors OFFSET #{offset} LIMIT #{limit}")
    @ResultMap("instructorMapper")
    List<Instructor> findAllInstructors(Integer offset, Integer limit);
}
