package com.example.lab5.Chap_02_NullSafty

val data1:String = "hello"
val data2:String? = null

fun main() {
    println("data length: ${data2?.length ?:0}")
}