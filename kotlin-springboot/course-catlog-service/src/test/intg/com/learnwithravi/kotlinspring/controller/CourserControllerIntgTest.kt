package com.learnwithravi.kotlinspring

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.util.courseEntityList
import com.learnwithravi.kotlinspring.entity.Course
import com.learnwithravi.kotlinspring.entity.Instructor
import com.learnwithravi.kotlinspring.repository.CourseRepository
import com.learnwithravi.kotlinspring.repository.InstructorRepository
import com.learnwithravi.kotlinspring.util.instructorEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.util.UriComponentsBuilder
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("prod")
@AutoConfigureWebTestClient
class CourserControllerIntgTest(){

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var instructorRepository: InstructorRepository

    @Autowired
    lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setUp(){
        courseRepository.deleteAll()
        instructorRepository.deleteAll()
        var instructor = instructorEntity()
        instructorRepository.save(instructor)

        var courses = courseEntityList(instructor)
        courseRepository.saveAll(courses)

    }

    @Test
    fun createCourse(){
        var instructor = instructorRepository.findAll().first()
       var courseDTO = CourseDTO( null, "Kotlin course for beginners", "development", instructor.id)
        val saveCourseDTO = webTestClient
            .post()
            .uri("/v1/courses/create")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertNotNull(saveCourseDTO!!.id !=null)
    }


    @Test
    fun retriveAllCourses(){

        var courseDTO = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(3, courseDTO!!.size)
    }

    @Test
    fun retriveAllCourses_Byname(){
       var uri= UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("course_name","Springboot")
            .toUriString()

        var courseDTO = webTestClient
            .get()
            .uri(uri)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(2, courseDTO!!.size)
    }

    @Test
    fun updateCourseTest() {
        // pick an existing instructor
        val instructor = instructorRepository.findAll().first()

        // create and save an existing course entity
        val courseEntity = Course(
            null,
            "Build RestFul APis using SpringBoot and Kotlin",
            "Development",
            instructor
        )
        val saved = courseRepository.save(courseEntity)

        // prepare updated DTO (controller expects CourseDTO in request body)
        val updatedCourseDTO = CourseDTO(
            id = null, // controller uses path variable for id
            name = "Build RestFul APis using SpringBoot and Kotlin1",
            category = "Development",
            instructorId = instructor.id
        )

        val updateCourse = webTestClient
            .put()
            .uri("/v1/courses/{course_id}", saved.id)
            .bodyValue(updatedCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Build RestFul APis using SpringBoot and Kotlin1", updateCourse!!.name)
    }

    @Test
    fun deleteCourseTest(){
        val instructor = instructorRepository.findAll().first()
        //existing couse
        var courseEntity = Course(
            null,
            "Build RestFul APis using SpringBoot and Kotlin", "Development",
            instructor
        )
        courseRepository.save(courseEntity)

        webTestClient
            .delete()
            .uri("/v1/courses/{course_id}", courseEntity.id)
            .exchange()
            .expectStatus().isNoContent

        var courseOptional = courseRepository.findById(courseEntity.id!!)
        assertEquals(false, courseOptional.isPresent)
    }
}