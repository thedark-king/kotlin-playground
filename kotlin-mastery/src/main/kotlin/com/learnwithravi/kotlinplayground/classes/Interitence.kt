package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

open class User(var Name: String) {

   open var isLoggedIn: Boolean = false
   open fun login() {
        println("Inside login method")
    }

    private fun secret(){
        println("Inside secret method")
    }
    protected open fun logout() {

    }
}

class Student(Name: String) : User(Name){

    override var isLoggedIn: Boolean = true
    override fun login(){
        println("Inside student login")
        super.login()
    }
    companion object{
       const val noOfEnrolledCourse = 10
        fun country() = "USA"
    }
    public override fun logout(){
        println("Inside logout")
    }
}

class Teacher(name: String) : User(name){

}


fun main() {
    var student = Student("John")
    println("The student name is : ${student.Name}")
    student.login()
    println("Logged in value is ${student.isLoggedIn}")
    var country = Student.country()
    println("The country name is : $country")
    println("The number of enrolled courses are ${Student.noOfEnrolledCourse} by ${student.Name} and the residing country is : $country")

    var teacher = Teacher("Raj")
    println("The teacher name is : ${teacher.Name}")
    teacher.login()
    student.logout()
}