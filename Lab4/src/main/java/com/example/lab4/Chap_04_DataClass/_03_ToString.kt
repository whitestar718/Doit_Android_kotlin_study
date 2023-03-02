package com.example.lab4.Chap_04_DataClass

// data 클래스는 toString을 이용하면 내용물을 쉽게 확인할 수 있다.
fun main() {
    class NonDataClass40(val name: String, val email: String, val age: Int)
    data class DataClass40(val name: String, val email: String, val age: Int)

    val non = NonDataClass("Eun", "A@a.com", 10)
    val data = DataClass40("Eun", "A@a.com", 10)
    println("non data calss toString: ${non.toString()}")
    println("data class toString: ${data.toString()}")
}