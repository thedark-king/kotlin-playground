fun main() {
//.. is a range operator, it defines a range from start to end
    1..10/* for(i in number){
         println(i)
     }*/
//    downTo function to print in reverse order
    val numberReserve = 10 downTo 1
    for (i in numberReserve) {
//        println(i)
//        println("reverse order $i")
    }

//    step function to skip numbers. Now 2 numbers will be skipped
//    expected output 10,8,6,4,2
    for (i in numberReserve step 2) {
//        println(i)
//        println("reverse order $i")
    }

    exploreWhile()
    exploreDoWhile()
}

fun exploreWhile() {
    var number = 0

    while (number < 5) {
        println("number is $number")
        number++
    }
}

fun exploreDoWhile() {
    var number = 0
    do {
        println("The number in do while is $number")
        number++
    } while (number++ < 5)
}
