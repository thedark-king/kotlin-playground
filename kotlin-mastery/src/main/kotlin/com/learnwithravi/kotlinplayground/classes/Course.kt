package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

data class Course(
    val id : Int,
    val name : String,
    val author : String,
    val courseCategary: CourseCategary = CourseCategary.DEVELOPMENT
)
enum class CourseCategary {
    DEVELOPMENT,
    MARKETING,
    DESIGN,
    BUSINESS
}

fun main(){

    val course = Course(
        1 ,
        "Learning Kotlin with Springboot",
        "RK"
    )
    val course1 = Course(
        2,
        "Learning Kotlin with Springboot",
        "RK"
    )
    println(course)
    println("The object equality check : ${course == course1}")

    var course3 = course.copy(id= 3,
        author = "Raj")
    println(course3)

    val facebookMarketingCourse = Course(
        2,
        "Zero to Mastery Facebook Marketing",
        "RK",
        CourseCategary.MARKETING
    )
    println(facebookMarketingCourse)
}

