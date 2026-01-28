package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.basics

import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions.courseName
import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions.topLvelFunction

fun main() {
    variableDemo()
}

fun variableDemo() {
//    val name: String = "Raj" OR
     val name = "Raj"
    println(name)

//    name = "Ravi" // Error: Val cannot be reassigned
//    "Using val means the reference cannot be changed, but the object it points to can be mutable."
    var age: Int = 25
    println(age)
    age = 26
    println(age)
//    var means the reference can be changed. The object it points to can also be mutable.

    val salary = 50000L
    println(salary)

    val course = "Kotlin for Beginners"
    println("this is course name $course and the course length is ${course.length} hourse")

    val multiline = " ABC \n DEF \n GHI "
    println(multiline)

    val multiline1 = """
        ABC
        DEF
        GHI
    """.trimIndent()
    println(multiline1)

    // calling topLvelFunction
    val num = topLvelFunction();
    println(num)
    val courseName = courseName
    println(courseName)


}