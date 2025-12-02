package com.learnwithravi.kotlinspring.repository

import com.learnwithravi.kotlinspring.entity.Instructor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InstructorRepository: CrudRepository<Instructor, Int> {
}