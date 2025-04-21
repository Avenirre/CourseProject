package com.courseproject.controllers;

import com.courseproject.dto.CourseDTORequest;
import com.courseproject.dto.CourseDTOResponse;
import com.courseproject.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(name = "Course Management", description = "API for course management")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @Operation(summary = "Create a new course", description = "Creates a new course in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course successfully created",
                    content = @Content(schema = @Schema(implementation = CourseDTOResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Course with the same title already exists")
    })
    public ResponseEntity<CourseDTOResponse> createCourse(
            @Valid @RequestBody CourseDTORequest courseRequest) {
        CourseDTOResponse createdCourse = courseService.createCourse(courseRequest);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }
}
