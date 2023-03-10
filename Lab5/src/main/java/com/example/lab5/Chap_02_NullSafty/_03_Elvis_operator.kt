package com.example.lab5.Chap_02_NullSafty

fun main() {
    var data31:String? = "Eun"
    println("data31 length is ${data31?.length ?: -1}")

    data31 = null
    println("data31 length is ${data31?.length ?: -1}")
}