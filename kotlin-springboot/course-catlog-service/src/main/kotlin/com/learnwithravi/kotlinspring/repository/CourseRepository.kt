package com.learnwithravi.kotlinspring.repository

import com.learnwithravi.kotlinspring.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {
    fun findByNameContainingIgnoreCase(name: String): List<Course>

    @Query(value = "SELECT c FROM Course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))" )
    fun findCourseByNameContainingIgnoreCase(name: String): List<Course>
}