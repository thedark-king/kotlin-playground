package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.exceptions

fun main() {
    println(nameLength("Dilip"))
    println(nameLength(null))

}
//Nothing always return Exceptions
fun returnNothing() : Nothing {
    throw RuntimeException("Exception")
}
fun nameLength(name: String?): Int? {

//    return try{
//        name!!.length
//    } catch(ex : Exception){
//        println(ex.stackTrace)
//        null
//    } OR
    val result = try{
        name!!.length
    } catch(ex : Exception){
        println(ex.stackTrace)
        null
    }

    return result
}
