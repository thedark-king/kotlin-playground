package com.learnwithravi.kotlinspring.service

import com.learnwithravi.kotlinspring.DTO.InstructorDTO
import com.learnwithravi.kotlinspring.entity.Instructor
import com.learnwithravi.kotlinspring.repository.InstructorRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class InstructorService(val instructorRepository: InstructorRepository) {

    fun createInstructor(instructorDTO: InstructorDTO): InstructorDTO {
        val instructor = instructorDTO.let {
            Instructor(it.id, it.name)
        }
        instructorRepository.save(instructor)


        return instructor.let {
            InstructorDTO(it.id, it.name)
        }
    }

    fun findByInstructorId(instructorId: Int?): Optional<Instructor> {
        return instructorRepository.findById(instructorId!!)
    }
}