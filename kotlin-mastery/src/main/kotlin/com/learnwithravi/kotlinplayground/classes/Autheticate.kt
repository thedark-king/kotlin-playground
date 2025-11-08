package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

object Autheticate {

    fun authentication(userName: String, password: String) {
        println("The user autheticated for the Username: $userName")
    }
}


fun main() {
    Autheticate.authentication("Jhon", "abc")
}