package com.learnwithravi.kotlinbasics.com.learnwithravi.kotlinplayground.classes

class Item() {

    var name: String = ""
    var price: Double = 0.0
        set(value) {
            if (value > 0) {
                field = value
            } else {
                throw IllegalArgumentException("field must be greater than 0")
            }
        }

    constructor(_name: String) : this() {
        name = _name
    }


}


fun main() {

    val item = Item("Iphone")
    println("Item name is ${item.name}")

    item.name = "Iphone 13"
    println("Item name is ${item.name}")

    item.price = -10.0
    println(item.price)
}