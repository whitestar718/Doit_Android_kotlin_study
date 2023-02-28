package com.example.lab3.Chap_02_FunctionAndVariables

fun main() {
    fun some09(data1: Int, data2:Int = 20):Int{
        return data1 + data2
    }

    println(some09(10))
    println(some09(10, 20))
    println(some09(data2=20, data1=10))

    // Array
    val data91 = Array<Int>(3, {0})
    data91[0] = 10
    data91[1] = 20
    data91.set(2, 30)
    println("${data91[0]} ${data91[2]}")

    val data92 = arrayOf<Int>(10, 20, 30)
    println(data92[1])


    // list
    var list = listOf<String>("one", "Two", "three") // immutable
    var list93 = mutableListOf<String>("a", "b", "c")
}