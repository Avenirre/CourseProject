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
        if (courseRepository.existsByTitle(courseRequest.title())) {
            throw new CourseAlreadyExistsException("Course with title '" + courseRequest.title() + "' already exists");
        }

        // Map DTO to entity
        CourseEntity courseEntity = CourseEntity.builder()
                .title(courseRequest.title())
                .description(courseRequest.description())
                .imageUrl(courseRequest.imageUrl())
                .difficultyLevel(courseRequest.difficultyLevel())
                .published(courseRequest.published())
                .estimatedDurationHours(courseRequest.estimatedDurationHours())
                .build();

        // Save to database
        CourseEntity savedCourse = courseRepository.save(courseEntity);

        // Map entity to response DTO
        return new CourseDTOResponse(
                savedCourse.getId(),
                savedCourse.getTitle(),
                savedCourse.getDescription(),
                savedCourse.getImageUrl(),
                savedCourse.getDifficultyLevel(),
                savedCourse.isPublished(),
                savedCourse.getCreatedAt(),
                savedCourse.getUpdatedAt(),
                savedCourse.getEstimatedDurationHours()
        );
    }
}
