package com.learnwithravi.kotlinspring.DTO

import com.learnwithravi.kotlinspring.entity.Instructor
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CourseDTO(
    val id : Int?,
    @get:NotBlank(message = "Course name must not be blank")
    var name : String,
    @get:NotBlank(message = "Course category must not be blank")
    var category : String,
    @get:NotNull(message = "instructorId must not be null")
    val instructorId: Int? = null,

) {
}