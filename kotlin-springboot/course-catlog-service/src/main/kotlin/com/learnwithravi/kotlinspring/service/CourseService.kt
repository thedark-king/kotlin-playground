package com.learnwithravi.kotlinspring.service

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.entity.Course
import com.learnwithravi.kotlinspring.exception.CourseNotFoundException
import com.learnwithravi.kotlinspring.exception.InstructorNotValidException
import com.learnwithravi.kotlinspring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(
    val courseRepository: CourseRepository,
    val instructorService: InstructorService) {

    companion object : KLogging()

    fun createCourse(courseDTO: CourseDTO): CourseDTO {

       val instructorOptional = instructorService.findByInstructorId(courseDTO.instructorId)
        if(!instructorOptional.isPresent){
            throw InstructorNotValidException("Instructor not valid : ${courseDTO.instructorId}")
        }
        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category, instructorOptional.get())
        }
        courseRepository.save(courseEntity)
//        logger.info { "Saved course is ${courseEntity}" }
        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category, it.instructor?.id)
        }
    }

    fun retriveAllCourses(courseName: String): List<CourseDTO> {

       var course = courseName?.let {
            courseRepository.findCourseByNameContainingIgnoreCase(courseName)
        } ?: courseRepository.findCourseByNameContainingIgnoreCase(courseName)

        return course
            .map{
                CourseDTO(it.id, it.name, it.category)
            }
    }

    fun updateCourse(courseDTO: CourseDTO, courseId: Int): CourseDTO {
        var existingCouse = courseRepository.findById(courseId)

      return  if(existingCouse.isPresent){
            existingCouse.get()
                .let {
                    it.name = courseDTO.name
                    it.category = courseDTO.category
                    courseRepository.save(it)
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("Course with id $courseId not found")
        }
    }

    fun deleteCourse(id: Int) {
        var existingCouse = courseRepository.findById(id)

        if(existingCouse.isPresent){
            courseRepository.deleteById(id)
        } else {
            throw CourseNotFoundException("Course with id $id not found")
        }
    }
}
