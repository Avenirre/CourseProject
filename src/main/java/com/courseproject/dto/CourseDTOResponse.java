package com.courseproject.dto;

import com.courseproject.enums.DifficultyLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Course information")
public class CourseDTOResponse {

    @Schema(description = "Course ID", example = "1")
    private long id;

    @Schema(description = "Course title", example = "Java for Beginners")
    private String title;

    @Schema(description = "Course description", example = "Basic Java course for newcomers to programming")
    private String description;

    @Schema(description = "Course image URL", example = "https://example.com/images/java-course.jpg")
    private String imageUrl;

    @Schema(description = "Course difficulty level", example = "BEGINNER")
    private DifficultyLevelEnum difficultyLevel;

    @Schema(description = "Course publication status", example = "true")
    private boolean published;

    @Schema(description = "Course creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Course last update date")
    private LocalDateTime updatedAt;

    @Schema(description = "Estimated course duration in hours", example = "40")
    private Integer estimatedDurationHours;
}
