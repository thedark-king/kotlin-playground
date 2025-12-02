package com.learnwithravi.kotlinspring.DTO

import com.learnwithravi.kotlinspring.entity.Course
import jakarta.validation.constraints.NotBlank


data class InstructorDTO(
    val id: Int?,
    @get:NotBlank(message = "Instructor name must not be blank")
    val name: String
)