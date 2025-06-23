package org.kshrd.mybatishomeworkonlinelearningplatform.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

    @NotNull
    @NotBlank
    private String studentName;

    @NotNull
    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format"
    )
    @Schema(defaultValue = "example@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotEmpty
    private List<Long> coursesId;
}
