package com.learnwithravi.kotlinspring.controller

import com.learnwithravi.kotlinspring.DTO.InstructorDTO
import com.learnwithravi.kotlinspring.service.InstructorService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/instructor")
@Validated
class InstructorController(val instructorService: InstructorService) {



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createInstructor(@RequestBody instructorDTO: InstructorDTO): InstructorDTO {
        return instructorService.createInstructor(instructorDTO)
    }

}