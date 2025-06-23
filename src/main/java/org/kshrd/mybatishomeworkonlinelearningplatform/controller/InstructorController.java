package org.kshrd.mybatishomeworkonlinelearningplatform.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.Instructor;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request.InstructorRequest;
import org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.response.APIResponse;
import org.kshrd.mybatishomeworkonlinelearningplatform.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<APIResponse<Instructor>> addNewInstructor(@RequestBody @Valid InstructorRequest instructorRequest){
        APIResponse<Instructor> response = APIResponse
                .<Instructor>builder()
                .message("The instructor has been successfully added.")
                .payload(instructorService.addNewInstructor(instructorRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> findInstructorById(@PathVariable("instructor-id") @Positive Long instructorId){
        Instructor instructor = instructorService.findInstructorById(instructorId);
        APIResponse<Instructor> response = APIResponse
                .<Instructor>builder()
                .message("The instructor has been successfully founded.")
                .payload(instructor)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> updateInfoInstructorById(@PathVariable("instructor-id") @Positive Long instructorId, @RequestBody @Valid InstructorRequest instructorRequest){
        APIResponse<Instructor> response = APIResponse
                .<Instructor>builder()
                .message("The instructor has been successfully updated.")
                .payload(instructorService.updateInfoInstructorById(instructorId,instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> removeInstructorById(@PathVariable("instructor-id") @Positive Long instructorId){
        instructorService.removeInstructorById(instructorId);
        APIResponse<Instructor> response = APIResponse
                .<Instructor>builder()
                .message("The instructor has been successfully removed.")
                .payload(null)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Instructor>>> findAllInstructors(@RequestParam(defaultValue = "1") @Positive Integer offset, @RequestParam(defaultValue = "10") @Positive Integer limit){
        APIResponse<List<Instructor>> response = APIResponse
                .<List<Instructor>>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.findAllInstructors(offset, limit))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
