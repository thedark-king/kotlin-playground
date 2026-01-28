package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.scopefuncations

import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes.Course
import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes.CourseCategary

fun exploreApply() {
    //Using Apply you can modify the current object you are using
   var course =  Course(
        1 ,
        "Design Thinking in Kotlin",
        "RK"
    ).apply {
       courseCategary = CourseCategary.DESIGN
    }

//    println("course: $course")
}


fun exploreAlso() {
    var course =  Course(
        1 ,
        "Design Thinking in Kotlin",
        "RK"
    ).apply {
        courseCategary = CourseCategary.DESIGN
    }.also {
//        it.courseCategary = CourseCategary.DESIGN
        println("Course is $it") //After the expression we are printing that we can do it within Also() expression
    }

//    println("course: $course")
}


fun main() {
//    exploreApply()
//    exploreAlso()
//    exploreLet()
//    exploreWith()
    exploreRun()
}


fun exploreRun(){
    var number : MutableList<Int>? = null
    var sum = number.run{
        number = mutableListOf(1,2,3)
        number?.sum()
    }
    println(sum)

    val nameLength = run {
        val name = "Dilip"
        println(name)
        name.length
    }
    println("Run name length is $nameLength")
}

fun exploreWith(){
    //If you have lambda for printing then we can go ahead and use it
    val number = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var result = with(number) {
//       println("Size is ${number.size}") OR
//        println("Size is ${this.size}") OR
        println("Size is ${size}")
         var list = number.plus(0)
//        list.sum() OR
        sum()
    }
    println("With Result is ${result}")
}
fun exploreLet() {
    val number = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    var greaterThenFiveNumber = number.filter { it > 5 }
//    println(greaterThenFiveNumber) OR
    var result = number.filter { it > 5 }.let {
        println(it)
        it.sum()
    }
    println(result)

    var name : String? = null
    var nameResult = name?.let { //We need to handle null values in the let expression
        it.length
    }
    println(nameResult)

    var name1 : String? = "Dilip"
    name1?.let { //We need to handle null values in the let expression
        it.length
        println(it)
    }

}
