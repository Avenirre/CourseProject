package com.courseproject.dto;


import com.courseproject.enums.DifficultyLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Schema(description = "Course creation or update request")
public record CourseDTORequest(
        @NotBlank(message = "Title is required")
        @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
        @Schema(description = "Course title", example = "Java for Beginners")
        String title,

        @Size(max = 1000, message = "Description cannot exceed 1000 characters")
        @Schema(description = "Course description", example = "Basic Java course for newcomers to programming")
        String description,

        @Schema(description = "Course image URL", example = "https://example.com/images/java-course.jpg")
        String imageUrl,

        @Schema(description = "Course difficulty level", example = "BEGINNER")
        DifficultyLevelEnum difficultyLevel,

        @Schema(description = "Course publication status", example = "true")
        boolean published,

        @Schema(description = "Estimated course duration in hours", example = "40")
        Integer estimatedDurationHours
) {}
