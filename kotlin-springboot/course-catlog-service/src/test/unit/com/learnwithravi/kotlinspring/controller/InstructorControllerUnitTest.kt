package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.DTO.InstructorDTO
import com.learnwithravi.kotlinspring.service.InstructorService
import com.learnwithravi.kotlinspring.util.courseDTO
import com.learnwithravi.kotlinspring.util.instructorEntity
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient


@WebMvcTest(InstructorController::class)
@AutoConfigureWebTestClient
class InstructorControllerUnitTest {


    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var instructorServiceMockk: InstructorService


    @Test
    fun createInstructor() {
        val instructorRequest = InstructorDTO(null, "Ravi Kumar")
        val savedInstructor = InstructorDTO(1, "Ravi Kumar")
        every { instructorServiceMockk.createInstructor(any()) } returns savedInstructor


        val saveInstructorDTO = webTestClient
            .post()
            .uri("/v1/instructor")
            .bodyValue(instructorRequest)
            .exchange()
            .expectStatus().isCreated
            .expectBody(InstructorDTO::class.java)
            .returnResult()
            .responseBody

    }

    @Test
    fun createInstructor_runtimeException() {
        // Use a valid DTO so validation doesn't short-circuit the request
        var instructorDTO = InstructorDTO(1, "Ravi Kumar")

        every { instructorServiceMockk.createInstructor(any()) } throws RuntimeException()
        val errorMessage = "unexpected error occurred"
        val response =     webTestClient
            .post()
            .uri("/v1/instructor")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().is5xxServerError
            .expectHeader().valueEquals("Content-Type", "text/plain;charset=UTF-8")
            .expectBody(String::class.java)
            .isEqualTo(errorMessage)
    }


}