package org.kshrd.mybatishomeworkonlinelearningplatform.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.exception.NotFoundException;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Student;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.StudentRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.repository.StudentCourseRepository;
import org.kshrd.mybatishomeworkonlinelearningplatform.repository.StudentRepository;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.CourseService;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final CourseService courseService;

        @Override
        public Student addNewStudent(StudentRequest studentRequest) {
            Long studentId = studentRepository.addNewStudent(studentRequest);
            for (long courseId : studentRequest.getCoursesId()) {
                courseService.findCourseById(courseId);
                studentCourseRepository.insertStudentIdAndCourseIdIntoStudentCourse(studentId, courseId);
            }
            return findStudentById(studentId);
        }

    @Override
    public Student findStudentById(Long studentId) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            throw new NotFoundException("Student with ID " + studentId + " not found.");
        }
        return student;
    }

    @Override
    public Student updateInfoStudentById(Long studentId, StudentRequest studentRequest) {
        findStudentById(studentId);

        Long stuId = studentRepository.updateInfoStudentById(studentId, studentRequest);
        studentCourseRepository.deleteStudentIdAndCourseIdFromStudentCourseByStudentId(stuId);

        for (long courseId : studentRequest.getCoursesId()) {
            courseService.findCourseById(courseId);
            studentCourseRepository.insertStudentIdAndCourseIdIntoStudentCourse(stuId, courseId);
        }

        return findStudentById(studentId);
    }

    @Override
    public void removeStudentById(Long studentId) {
        findStudentById(studentId);
        studentRepository.removeStudentById(studentId);
    }

    @Override
    public List<Student> findAllStudents(Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        return studentRepository.findAllStudents(offset, limit);
    }
}