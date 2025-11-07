package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

data class Employee(
    val id: Int = 0,
    val name: String = "")



fun main(){

    val employee = Employee(3, "Ram Raman")
    val employee1 = Employee(3, "Ram Raman1")
    println(employee)
    println("Is employee and employee1 are equal ${employee == employee1} ")
    var employee3 = employee1.copy(id= 4, name = "Ramesh")
    println(employee3)
}