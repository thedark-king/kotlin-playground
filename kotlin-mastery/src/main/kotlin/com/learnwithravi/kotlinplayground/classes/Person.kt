package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

class Person(
    val name: String = "",
    val age: Int = 0,
) {
  var email : String = ""
  var nameLength : Int = 0;
    constructor(_email : String,
        _name : String = "",
        _age : Int = 0) : this(_name, _age){
            email = _email
    }
    init {
        println("Inside init block")
        nameLength = name.length
    }
    fun action() {
        println("Person walks")
    }
}

fun main() {
    /*val person = Person("Raj", 25)

    person.action()
    println("Person name is ${person.name} and age is ${person.age}")


    val person2 = Person(_email = "abc@gmail.com", _name = "Raju", _age = 30)
//        println("Person2 name is ${person2.name} and age is ${person2.age}") */

//    val person3 = Person(_email = "test@gmail.com")
//    println("EmailId is printing from secondary constructor : ${person3.email}")

    val person4 = Person(_email = "abc@gmail.com", _name = "Raj", _age = 22)
    print("The Person name is ${person4.name} and age is ${person4.age} and email is ${person4.email} and nameLength ${person4.nameLength}")

}
