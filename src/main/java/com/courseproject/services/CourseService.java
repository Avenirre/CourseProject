package com.courseproject.services;

import com.courseproject.dto.CourseDTORequest;
import com.courseproject.dto.CourseDTOResponse;
import com.courseproject.entities.CourseEntity;
import com.courseproject.exceptions.CourseAlreadyExistsException;
import com.courseproject.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public CourseDTOResponse createCourse(CourseDTORequest courseRequest) {
        // Check if course with the same title already exists
        if (courseRepository.existsByTitle(courseRequest.getTitle())) {
            throw new CourseAlreadyExistsException("Course with title '" + courseRequest.getTitle() + "' already exists");
        }

        // Map DTO to entity
        CourseEntity courseEntity = mapToEntity(courseRequest);

        // Save to database
        CourseEntity savedCourse = courseRepository.save(courseEntity);

        // Map entity to response DTO
        return mapToResponse(savedCourse);
    }

    private CourseEntity mapToEntity(CourseDTORequest courseRequest) {
        return CourseEntity.builder()
                .title(courseRequest.getTitle())
                .description(courseRequest.getDescription())
                .imageUrl(courseRequest.getImageUrl())
                .difficultyLevel(courseRequest.getDifficultyLevel())
                .published(courseRequest.isPublished())
                .estimatedDurationHours(courseRequest.getEstimatedDurationHours())
                .build();
    }

    private CourseDTOResponse mapToResponse(CourseEntity courseEntity) {
        return CourseDTOResponse.builder()
                .id(courseEntity.getId())
                .title(courseEntity.getTitle())
                .description(courseEntity.getDescription())
                .imageUrl(courseEntity.getImageUrl())
                .difficultyLevel(courseEntity.getDifficultyLevel())
                .published(courseEntity.isPublished())
                .createdAt(courseEntity.getCreatedAt())
                .updatedAt(courseEntity.getUpdatedAt())
                .estimatedDurationHours(courseEntity.getEstimatedDurationHours())
                .build();
    }


}
