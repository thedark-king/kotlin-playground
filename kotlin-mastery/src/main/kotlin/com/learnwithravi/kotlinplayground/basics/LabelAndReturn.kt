package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.basics

fun main() {

    for(i in 1..10){
//        println("i : $i")
        if(i ==3) break
    }

    label()

    for(i in 1..10){
        println("i is printing from return loop : $i") //This will print only 1 and 2 and then exit from the main function
        if(i ==3 ) return               // It will not print the statement after this loop i.e END OF PROGRAM will not be printed
    }

    for(j in 1..10){
        println("i is printing from continue loop : $j")
        if(j ==3 ) continue               // It will skip the current iteration when j is 3
    }

    println("END OF PROGRAM")
}

fun label() {
    loop@ for(i in 1..10){  //loop@ is label for the outer loop and innerloop@ is label for inner loop
//        println("i : $i")   //Using label we can break or continue specific loop
        if(i ==3 ) break@loop
        innerloop@ for(j in 1..10){
//            println("j : $j")
            if(j==2) break@innerloop
        }
    }
}
