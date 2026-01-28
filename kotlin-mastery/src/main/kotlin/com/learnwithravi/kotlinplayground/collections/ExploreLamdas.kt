package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.collections

fun calculate(x:Int, y:Int, op:(x:Int, y:Int)-> Int):Int{
    return op(x, y)
}

fun main() {
    var addLamda = {x:Int -> x+x}

    var resultLamda = addLamda(3)

    println(resultLamda)

    var multiplyLamda = {x:Int, y:Int ->
        println("x is $x y is $y")
        x*y
    }
    var resultMultiplication = multiplyLamda(5,5)
    println(resultMultiplication)
    var result = calculate(2,5,{a,b -> a*b}) //OR
    var result1 = calculate(2,5){a,b -> a*b} //If the last argument is lambda then we can pass the value outside () parenthesis
    println("the custom lambda result value is ${result}")
    println("the custom lambda result1 value is ${result1}")

}