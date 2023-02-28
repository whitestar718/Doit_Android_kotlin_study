package com.example.lab4.Chap_01_IfAndLoop

fun main() {
    var data = 10
    val result = if (data > 0) {
        println("data > 0")
        10
    } else {
        println("data is ??")
        0
    }
    println(result)
    // 아무것도 할당이 안되면 kotlin.Unit이 할당된다.
    // 이것이 기본값이라서 그렇다.

    var data2: Any = 10
    val result3 = when (data2) {
        10 -> "result is 10"
        20 -> 20
        else -> 30
    }
    println(result3)

    var data3 = arrayOf(10, 20, 30)
    for (i in data3.indices) {
        println(data3[i])
    }
    println("=================================")
    for ((index, value) in data3.withIndex()) {
        print(index)
        print(',')
        print(value)
        println()
    }
}