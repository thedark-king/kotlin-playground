package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.nulls

import javax.naming.Name

data class Movie(
    val id : Int?,
    val name : String
)

fun printName(name: String){
    print("Name is ${name}")
}

fun main() {

    var nullValue : String? = null
    println("value is : ${nullValue}")
//    printName(nullValue!!) // it fails as the nullValue is not assigned any value and it is null
        nullValue?.run {
            printName(this)
        }

    //? is a safe operator
    println("The value is : ${nullValue?.length}") // in Kotlin ? means if the nullValue is non-null then only perform length operation else keep it null

    //In Elvis operator after calling length we add ?: 0 and 0 is default value. If value is not present then it consider the default value is 0
    println("the Elvis operator value : ${nullValue?.length ?: 0}")

//    println(nullValue!!) // non-null assertions !!
//    if(nullValue!=null) {
//        println("the value is : ${nullValue.length}") //Java way of checking if the var is null or not
//    }


    nullValue = "Dilip"
    println("After assigning name the value is : ${nullValue} ")
    //If you want to make var null then speifically we need to add = operator while assigning null value
//    var name : String? = null
    var savedMovie = saveMovie(Movie(null, "Dilip"))

    println("The savedMovie is : ${savedMovie}")
}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id = 1)
}

