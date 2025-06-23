package org.kshrd.mybatishomeworkonlinelearningplatform.service;

import org.kshrd.mybatishomeworkonlinelearningplatform.model.Student;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student addNewStudent(StudentRequest studentRequest);

    Student findStudentById(Long studentId);

    Student updateInfoStudentById(Long studentId, StudentRequest studentRequest);

    void removeStudentById(Long studentId);

    List<Student> findAllStudents(Integer offset, Integer limit);
}
