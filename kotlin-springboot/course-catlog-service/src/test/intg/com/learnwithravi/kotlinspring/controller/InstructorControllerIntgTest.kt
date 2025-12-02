package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.DTO.CourseDTO
import com.learnwithravi.kotlinspring.DTO.InstructorDTO
import com.learnwithravi.kotlinspring.repository.CourseRepository
import com.learnwithravi.kotlinspring.repository.InstructorRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("prod")
@AutoConfigureWebTestClient
class InstructorControllerIntgTest() {

    @Autowired
    lateinit var instructorRepository: InstructorRepository

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun createInstructor(){
        var instructorDTO = InstructorDTO( null, "Rakesh")
        val saveCourseDTO = webTestClient
            .post()
            .uri("/v1/instructor")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(InstructorDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertNotNull(saveCourseDTO!!.id !=null)
    }
}