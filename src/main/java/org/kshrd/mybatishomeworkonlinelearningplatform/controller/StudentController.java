package org.kshrd.mybatishomeworkonlinelearningplatform.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Student;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.StudentRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.response.APIResponse;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<APIResponse<Student>> addNewStudent(@RequestBody @Valid StudentRequest studentRequest){
        APIResponse<Student> response = APIResponse.<Student>
                builder()
                .message("The student has been successfully added.")
                .payload(studentService.addNewStudent(studentRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> findStudentById(@PathVariable("student-id") @Positive Long studentId){
        Student student = studentService.findStudentById(studentId);
        APIResponse<Student> response = APIResponse
                .<Student>builder()
                .message("The student has been successfully founded.")
                .payload(student)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> updateInfoStudentById(@PathVariable("student-id") @Positive Long studentId, @RequestBody @Valid StudentRequest studentRequest){
        APIResponse<Student> response = APIResponse
                .<Student>builder()
                .message("The student has been successfully updated.")
                .payload(studentService.updateInfoStudentById(studentId, studentRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> removeStudentById(@PathVariable("student-id") @Positive Long studentId){
        studentService.removeStudentById(studentId);
        APIResponse<Student> response = APIResponse
                .<Student>builder()
                .message("The student has been successfully removed.")
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Student>>> findAllStudents(@RequestParam(defaultValue = "1") @Positive Integer offset, @RequestParam(defaultValue = "10") @Positive Integer limit){
        APIResponse<List<Student>> response = APIResponse
                .<List<Student>>builder()
                .message("All students have been successfully fetched.")
                .payload(studentService.findAllStudents(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
