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

    // 2. 여러가지 배열 (자바 호환성 때문에 만들어둔 거라서, 굳이 코틀린에서 사용 안해도 됨)
    // BooleanArray, ByteArray, CharArray, DoubleArray, FloatArray, IntArray ...
    val data72 = arrayOf<Int>(10, 20, 30)
    val data73 = booleanArrayOf(true, false, true)
    println(data72[0])
    println(data73[1])
}