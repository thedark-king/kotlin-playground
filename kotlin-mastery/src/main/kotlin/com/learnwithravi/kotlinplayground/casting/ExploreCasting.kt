package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.casting

import com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes.Course

fun checkType(type : Any){

    when(type){
        is Course -> println("The type is course and the details are ${type}")
        is String -> println(type.lowercase())
    }

}

fun castNumber(number : Any){

    when(number){
        number as Double -> println("The number is $number")

    }
}


fun main() {
    checkType(Course(1,"Master Java course", "RK"))
    checkType("CHECKING THE CASTING FUNCATION")
    castNumber(1.1)
//    castNumber(1) //Exception will be thrown as we have not handled the type casting

    var number = 1
    var doubleValue = number.toDouble() //Explicite casting
    println(doubleValue)
}