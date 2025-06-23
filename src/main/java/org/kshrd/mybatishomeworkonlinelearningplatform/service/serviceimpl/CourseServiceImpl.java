package org.kshrd.mybatishomeworkonlinelearningplatform.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.exception.NotFoundException;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Course;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.CourseRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.repository.CourseRepository;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.CourseService;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorService instructorService;

    @Override
    public Course addNewCourse(CourseRequest courseRequest) {
        instructorService.findInstructorById(courseRequest.getInstructorId());
        return courseRepository.addNewCourse(courseRequest);
    }

    @Override
    public Course findCourseById(Long courseId) {
        Course course = courseRepository.findCourseById(courseId);
        if (course == null) {
            throw new NotFoundException("Course with ID " + courseId + " not found.");
        }
        return course;
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest courseRequest) {
        findCourseById(courseId);
        instructorService.findInstructorById(courseRequest.getInstructorId());
        return courseRepository.updateCourseById(courseId, courseRequest);
    }

    @Override
    public void removeCourseById(Long courseId) {
        findCourseById(courseId);
        courseRepository.removeCourseById(courseId);
    }

    @Override
    public List<Course> findAllCourses(Integer offset, Integer limit) {
        offset = (offset - 1) * limit;
        return courseRepository.findAllCourses(offset, limit);
    }
}
