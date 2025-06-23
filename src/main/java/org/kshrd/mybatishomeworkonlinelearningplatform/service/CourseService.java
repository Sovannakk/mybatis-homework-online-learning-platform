package org.kshrd.mybatishomeworkonlinelearningplatform.service;

import org.kshrd.mybatishomeworkonlinelearningplatform.model.Course;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.CourseRequest;

import java.util.List;

public interface CourseService {
    Course addNewCourse(CourseRequest courseRequest);

    Course findCourseById(Long courseId);

    Course updateCourseById(Long courseId, CourseRequest courseRequest);

    void removeCourseById(Long courseId);

    List<Course> findAllCourses(Integer offset, Integer limit);
}
