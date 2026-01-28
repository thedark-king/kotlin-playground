package com.learnwithravi.kotlinplayground.collections

import com.learnwithravi.kotlinplayground.dataset.Course
import com.learnwithravi.kotlinplayground.dataset.CourseCategory
import com.learnwithravi.kotlinplayground.dataset.courseList

fun main(){
    val namesListYUsingSequence = listOf("alex", "ben", "chole")
        .asSequence()
        .filter { it.length >= 4 }
        .map { it.uppercase() }
        .toList()
    println("namesListYUsingSequence: $namesListYUsingSequence")

    var devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPEMENT }
    var desPredicate = { c: Course -> c.category == CourseCategory.DESIGN }
    exploreFilterUsingSequence(courseList(), desPredicate)
    val range = 1..1000_000_000

//    range
//        .asSequence()
//        .map { it.toDouble() }
//        .forEach { println(it) }

    collections_nullablity()
}


fun collections_nullablity(){

    var list : MutableList<String>? = null
    list = mutableListOf()
    list?.add("Adam")
    list.forEach {
        println("Value is : ${it.length}")
    }

    var list2 = listOf<String?>("Adam", null , "Chloe")
    list2.forEach { println("list2 Value is : ${it?.length}") }
}


fun exploreFilterUsingSequence(courses: MutableList<Course>, predicate: (Course) -> Boolean) {


    return courses
        .asSequence()
        .filter { predicate.invoke(it) }
        .forEach {
            println("Course : ${it}")
        }


}