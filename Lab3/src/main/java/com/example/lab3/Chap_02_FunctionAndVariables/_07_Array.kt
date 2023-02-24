package com.example.lab3.Chap_02_FunctionAndVariables

fun main() {
    // 1. 배열 선언하는 법. <General> 꺽쇠 안에는 general type이 할당된다.
    val data71: Array<Int> = Array(3, {0})
    data71[0] = 10
    data71[1] = 20
    data71.set(2, 30)

    println(data71[2])
    println("""
        array size: ${data71.size}
        array data" ${data71[0]}, ${data71[1]}, ${data71[2]}
    """.trimIndent())
}