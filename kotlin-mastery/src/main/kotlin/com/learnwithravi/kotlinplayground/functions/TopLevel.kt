package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions

fun topLvelFunction() : Int {
    return (1..100).random()
}

const val courseName = "Kotlin Programming"

fun main(){

    val num = topLvelFunction();
    println(num)
}