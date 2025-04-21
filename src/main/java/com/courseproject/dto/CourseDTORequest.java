package com.courseproject.dto;


import com.courseproject.enums.DifficultyLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Course creation or update request")
public class CourseDTORequest {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    @Schema(description = "Course title", example = "Java for Beginners")
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Schema(description = "Course description", example = "Basic Java course for newcomers to programming")
    private String description;

    @Schema(description = "Course image URL", example = "https://example.com/images/java-course.jpg")
    private String imageUrl;

    @Schema(description = "Course difficulty level", example = "BEGINNER")
    private DifficultyLevelEnum difficultyLevel;

    @Schema(description = "Course publication status", example = "true")
    private boolean published;

    @Schema(description = "Estimated course duration in hours", example = "40")
    private Integer estimatedDurationHours;

}
