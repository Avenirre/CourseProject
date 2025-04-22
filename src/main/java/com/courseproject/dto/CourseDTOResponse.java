package com.courseproject.dto;

import com.courseproject.enums.DifficultyLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Course information")
public record CourseDTOResponse(
        @Schema(description = "Course ID", example = "1")
        long id,

        @Schema(description = "Course title", example = "Java for Beginners")
        String title,

        @Schema(description = "Course description", example = "Basic Java course for newcomers to programming")
        String description,

        @Schema(description = "Course image URL", example = "https://example.com/images/java-course.jpg")
        String imageUrl,

        @Schema(description = "Course difficulty level", example = "BEGINNER")
        DifficultyLevelEnum difficultyLevel,

        @Schema(description = "Course publication status", example = "true")
        boolean published,

        @Schema(description = "Course creation date")
        LocalDateTime createdAt,

        @Schema(description = "Course last update date")
        LocalDateTime updatedAt,

        @Schema(description = "Estimated course duration in hours", example = "40")
        Integer estimatedDurationHours
) {}
