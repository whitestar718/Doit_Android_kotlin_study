package com.example.lab4.Chap_01_IfAndLoop

fun main() {
    // if ~ else
    var data = 10
    if (data > 0){
        println("data > 0")
    } else {
        println("data <= 0")
    }

    // if ~ else if ~ else
    data = 10
    if (data > 10) {
        println("data > 10")
    } else if (data > 0 && data <= 10) {
        println("data > 0 && data <= 10")
    } else {
        println("else")
    }

    // expression으로 사용하는 if문
    val result = if (data > 10) {
        println("data > 10")
        10
    } else if (data > 0 && data <= 10) {
        println("data > 0 && data <= 10")
        20
    } else {
        println("else")
        30
    }
    println("result: ${result}")
}