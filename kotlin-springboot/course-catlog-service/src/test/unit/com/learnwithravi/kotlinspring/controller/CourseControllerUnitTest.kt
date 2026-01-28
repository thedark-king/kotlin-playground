package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.controller.CourseController
import com.learnwithravi.kotlinspring.util.courseDTO
import com.learnwithravi.kotlinspring.repository.CourseRepository
import com.learnwithravi.kotlinspring.service.CourseService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertEquals

@WebMvcTest(CourseController::class)
@AutoConfigureWebTestClient
class CourseControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMockk: CourseService

    @MockkBean
    lateinit var courseRepositoryMockk: CourseRepository

    @Test
    fun createCourse() {
        var courseDTO = CourseDTO(null, "Kotlin course for beginners", "development", 1)

        every { courseServiceMockk.createCourse(any()) } returns courseDTO(id = 1)

        val saveCourseDTO = webTestClient
            .post()
            .uri("/v1/courses/create")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertTrue {

            saveCourseDTO!!.id != null
        }
    }

    @Test
    fun getAllCourses(){
        every { courseServiceMockk.retriveAllCourses(any()) }.returnsMany(
               listOf(
                   courseDTO(1),
                   courseDTO(
                       2,
                       name = "Java course for beginners",

                   )
               )
        )

        val responseBody = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertEquals(2, responseBody!!.size)
    }

    @Test
    fun updateCourseTest() {
        val courseId = 1
        val existingCourse = courseDTO(courseId, "Kotlin course for beginners", "development")
        val updatedCourse = courseDTO(courseId, "Advanced Kotlin course", "development")

        every { courseServiceMockk.updateCourse(any(), any()) } returns updatedCourse
        every { courseServiceMockk.updateCourse(any(), eq(courseId)) } returns updatedCourse

        val responseBody = webTestClient
            .put()
            .uri("/v1/courses/{course_id}", courseId)
            .bodyValue(updatedCourse)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Advanced Kotlin course", responseBody!!.name)
    }


    @Test
    fun deleteCourseTest() {
        val courseId = 1

        every { courseServiceMockk.deleteCourse(courseId) } returns Unit

        webTestClient
            .delete()
            .uri("/v1/courses/{course_id}", courseId)
            .exchange()
            .expectStatus().isNoContent
    }

    @Test
    fun createCourse_validation() {
        var courseDTO = CourseDTO(null, "", "", 1)

        every { courseServiceMockk.createCourse(any()) } returns courseDTO(id = 1)

        val response = webTestClient
            .post()
            .uri("/v1/courses/create")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isBadRequest
            .expectHeader().contentType(MediaType.TEXT_PLAIN)
            .expectBody(String::class.java)
            .isEqualTo("Course category must not be blank, Course name must not be blank")
    }

    @Test
        fun createCourse_runtimeException() {
            // Use a valid DTO so validation doesn't short-circuit the request
            val courseDTO = CourseDTO(null, "Kotlin course", "development",1)

            every { courseServiceMockk.createCourse(any()) } throws RuntimeException()
            val errorMessage = "unexpected error occurred"
            val response =     webTestClient
                .post()
                .uri("/v1/courses/create")
                .bodyValue(courseDTO)
                .exchange()
                .expectStatus().is5xxServerError
                .expectHeader().valueEquals("Content-Type", "text/plain;charset=UTF-8")
                .expectBody(String::class.java)
                .isEqualTo(errorMessage)
    }

}