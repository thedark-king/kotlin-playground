package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.functions

import java.time.LocalDate

// Function Syntax
// fun function_name ( parameters ) : return_type {
//      // function body
//      return value
// }

//UNIT is similar to void in other languages
// If the function does not return any value then we can skip the return type as Unit is default
fun printName(name : String) : Unit{
//    println("name is : $name")
}

fun addition(a : Int, b: Int) : Int{
    return a+b
}
fun addition_approch1(a: Int, b: Int) = a+b

fun printPersonDetails(
    name : String,
    email : String = "not available",
    dob : LocalDate = LocalDate.now() ){
    println("The name is : $name, the email is : $email, the date of birth is : $dob")
}




fun main() {

/*    printName("Ravi")
    val sum = addition(2,3)
    println("Total sum is : $sum")

    val sum1 = addition_approch1(5,7)
    println("Total sum using approach 1 is : $sum1")*/
    printPersonDetails("Ravi") //default values will be used for email and dob
    printPersonDetails("Ravi", "testuser@gmail.com", LocalDate.of(1990,5,12))
    printPersonDetails(name = "Ravi", dob = LocalDate.of(1990,5,12)) //named arguments and email will use default value
    printPersonDetails(dob = LocalDate.of(1990,5,12), name = "Ravi") //named arguments can be in any order
}