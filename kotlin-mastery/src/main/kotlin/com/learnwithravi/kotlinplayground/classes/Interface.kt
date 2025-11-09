package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions.courseName

interface CourseRepository{
    // getById takes id as input parameters and returns the Course
    fun getById( id: Int) : Course
    var isCoursePersited : Boolean
    fun save( course : Course) :Int{
        println(course)
        isCoursePersited = true
        return course.id;
    }
}


class SqlCourseRepository : CourseRepository{
    override var isCoursePersited: Boolean = false
    override fun getById(id: Int): Course {
        return Course(
            id ,
            "Learning Kotlin with Springboot",
            "RK"
        )
    }

}


class NoSqlRepository : CourseRepository{
    override fun getById(id: Int): Course {
        return Course(11, "Java JEE Course", "JavaTechie")
    }
    override var isCoursePersited: Boolean = false
    override fun save(course : Course) : Int {
        println("THe course is saved through NoSqlRepository")
        isCoursePersited = true
        return course.id
    }

}


fun main() {

    val repository = SqlCourseRepository();
    val course = repository.getById( 1)
    println(course)
 var   course2 = Course(
        22,
        "The Kotling Course for beginners!!",
        "RK"
    )

    var id = repository.save(course2);
    println("The save course id is : ${id}")

    var noSqlRepository = NoSqlRepository()
    noSqlRepository.save(course2)
    println("Is the course persited ${noSqlRepository.isCoursePersited}")

}