package com.example.lab5.Chap_02_NullSafty

fun some51(data:String?):Int?{
    return data?.length ?: 0
}

fun main() {
    var data: String? = "Eun"
    println("data = ${data?.length ?: -1}")

    data = null
    println("data = ${data?.length ?: -1}")
}