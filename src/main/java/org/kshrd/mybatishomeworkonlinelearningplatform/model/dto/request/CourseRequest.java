package org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotNull
    @NotBlank
    private String courseName;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Long instructorId;
}
