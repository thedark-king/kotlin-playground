package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.basics

fun main() {

    val name = "Ramesh"

    val result = if (name.length == 4) {
        println("The name is of 4 characters")
        name.length
    } else {
        println("The name is not of 4 characters")
        name.length
    }

    println(result)
    //1 --> GOLD, 2-> SILVER 3-> BRONZE ELSE NO MEDAL
    var position = 1
//    val medal = if( position == 1){
//        "GOLD"
//    } else if(position == 2){
//        "SILVER"
//    } else if(position == 3){
//        "BRONZE"
//    } else{
//        "NO MEDAL"
//    }
    var medal = when (position) {
        1 -> "GOLD"
        2 -> {
            print("Inside position 2 block ")
            "SILVER"
        }
        3 -> "BRONZE"
        else -> "NO MEDAL"

    }

    print(medal)


}