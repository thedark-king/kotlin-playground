package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.collections


fun main() {
    var mutableListNames = listOf("Alex", "Chole","Ben")
    println("Names: ${mutableListNames}")
    var immutableName = mutableListOf("Alex", "Chole","Ben")
    immutableName.add("Adam")
    println("immutableName: ${immutableName}")
    var mutableSetNames = setOf("Alex", "Chole","Ben")
    mutableSetNames.sorted()
    println("setNames: ${mutableSetNames}")
    var immutableSetName = mutableListOf("Alex", "Chole","Ben")
    immutableSetName.add("Rakesh")
    println("immutableSetName: ${immutableSetName}")

    var imMutableMapNames = mapOf("Dilip" to 10, "Raj" to 11)
    println("nameMap: ${imMutableMapNames}")

    var mutableMapNames = mutableMapOf("Dilip" to 10, "Raj" to 11)
    mutableMapNames["Ramesh"] = 19
    println("nameMap: ${mutableMapNames}")



}