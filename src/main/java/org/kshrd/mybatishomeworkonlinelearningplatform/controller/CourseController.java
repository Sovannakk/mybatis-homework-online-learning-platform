package org.kshrd.mybatishomeworkonlinelearningplatform.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Course;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.CourseRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.response.APIResponse;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<APIResponse<Course>> addNewCourse(@RequestBody @Valid CourseRequest courseRequest){
        APIResponse<Course> response = APIResponse
                .<Course>builder()
                .message("The course has been successfully added.")
                .payload(courseService.addNewCourse(courseRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> findCourseById(@PathVariable("course-id") @Positive Long courseId){
        Course course = courseService.findCourseById(courseId);
        APIResponse<Course> response = APIResponse
                .<Course>builder()
                .message("The course has been successfully founded.")
                .payload(course)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> updateCourseById(@PathVariable("course-id") @Positive Long courseId, @RequestBody @Valid CourseRequest courseRequest){
        APIResponse<Course> response = APIResponse
                .<Course>builder()
                .message("The course has been successfully founded.")
                .payload(courseService.updateCourseById(courseId, courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> removeCourseById(@PathVariable("course-id") @Positive Long courseId){
        courseService.removeCourseById(courseId);
        APIResponse<Course> response = APIResponse
                .<Course>builder()
                .message("The course has been successfully removed.")
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Course>>> findAllCourses(@RequestParam(defaultValue = "1") @Positive Integer offset, @RequestParam(defaultValue = "10") @Positive Integer limit){
        APIResponse<List<Course>> response = APIResponse
                .<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.findAllCourses(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
