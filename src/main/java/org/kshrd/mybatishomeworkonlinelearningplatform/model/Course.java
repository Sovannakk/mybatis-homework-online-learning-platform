package org.kshrd.mybatishomeworkonlinelearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private Long courseId;
    private String courseName;
    private String description;
    private Instructor instructor;
}
