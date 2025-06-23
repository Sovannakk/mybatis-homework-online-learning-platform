package org.kshrd.mybatishomeworkonlinelearningplatform.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Instructor {
    private Long instructorId;
    private String instructorName;
    private String email;
}
