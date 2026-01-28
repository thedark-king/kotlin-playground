package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.repository.CourseRepository
import com.learnwithravi.kotlinspring.service.CourseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/courses")
@Validated
class CourseController(val courseService: CourseService, private val courseRepository: CourseRepository) {


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCourse(@Valid @RequestBody courseDTO : CourseDTO): CourseDTO {
        return courseService.createCourse(courseDTO)
    }



    @GetMapping()
    fun retriveAllCourses(
        @RequestParam("course_name", required = false) courseName: String?
    ): List<CourseDTO> {
        return if (!courseName.isNullOrBlank()) {
            courseService.retriveAllCourses(courseName)
        } else {
            // when no filter provided return all courses
            courseService.retriveAllCourses("")
        }
    }

        @PutMapping("/{course_id}")
        @ResponseStatus(HttpStatus.OK)
        fun updateCourse(@RequestBody courseDTO: CourseDTO,
                         @PathVariable("course_id") id: Int): CourseDTO{
            return courseService.updateCourse(courseDTO, id)
        }

        @DeleteMapping("/{course_id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        fun deleteCourse(@PathVariable("course_id") id: Int){
             courseService.deleteCourse(id)
        }
}