package com.learnwithravi.kotlinplayground.collections

import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions.courseName
import com.learnwithravi.kotlinplayground.dataset.Course
import com.learnwithravi.kotlinplayground.dataset.CourseCategory
import com.learnwithravi.kotlinplayground.dataset.KAFKA
import com.learnwithravi.kotlinplayground.dataset.courseList
import java.text.Collator

fun exploreFilter(courses: MutableList<Course>, predicate: (Course) -> Boolean) {

//    courses.filter {
//        it.category == CourseCategory.DEVELOPEMENT
//    }.forEach { course -> println("development course : ${course}") }


//    courses.filter { it.category == CourseCategory.DEVELOPEMENT }
//        .forEach { println("devCourses : ${it}") }
//    println("developmentCourses: ${developmentCourses}")
    courses.filter { predicate.invoke(it) }
        .forEach {
//            println("Course : ${it}")
        }
}


fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {

    courseList.map { it -> it.id.toDouble() }
        .forEach {
            predicate
//            println("the list is ${it}")
        }

    courseList.filter {
        predicate(it)
    }.map { it -> "${it.name} ${it.category}" }
        .forEach {
//            println(it)
        }
}


fun main() {

    var courseList = courseList()
    var devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }
    var desPredicate = { c: Course -> c.category == CourseCategory.DESIGN }

    var developmentcouse = exploreFilter(courseList, devPredicate)
    println("development courses : ${developmentcouse}")
    exploreMap(courseList, desPredicate)

    val list = listOf(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10))

//    var listOfMapResult = list.map { outerlist -> outerlist.map { it.toDouble() } }
//    println("listOfMapResult : ${listOfMapResult}")
//
//    var listOfFlatMapResult = list.flatMap { outerlist -> outerlist.map { it.toDouble() } }
//    println("listOfFlatMapResult : ${listOfFlatMapResult}")
//    var kafkaCourses = exploreFlatMap(courseList, KAFKA)
//    println("kafkaCourses: ${kafkaCourses}")
    exploreHashmap()
}

fun exploreHashmap(){
    val nameAgeMutableMap = mutableMapOf("Dilip" to 1, "Scooby" to 5)

    nameAgeMutableMap.forEach{
        (k,v)->
        println("the key is : ${k} and the value is: ${v}")
    }
    var value = nameAgeMutableMap.getOrElse("Dilip1", {"abc"}) //OR
    var value1 = nameAgeMutableMap.getOrElse("Dilip1") {"abc"}
    var upperCaseNames = nameAgeMutableMap.filterKeys {
        it.length > 5
    }.map { it.key.uppercase() }
    var maxAge = nameAgeMutableMap.maxByOrNull {it.value}

    println("upperCaseNames: $upperCaseNames")
    println("maxAge: $maxAge")

    println(value)
    println(value1)


}
fun exploreFlatMap(courseList: MutableList<Course>, kafka : String) : List<String> {
    var kafkaCourses = courseList.flatMap { courses ->
        var courName = courses.name
        courses.topicsCovered.filter { topics -> topics.contains(kafka) }
            .map { courseName }
    }
    return kafkaCourses
}