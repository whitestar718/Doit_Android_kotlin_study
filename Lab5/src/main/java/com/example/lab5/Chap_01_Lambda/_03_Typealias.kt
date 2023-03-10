package com.example.lab5.Chap_01_Lambda

typealias MyInt = Int
typealias MyFunType = (Int, Int) -> Boolean

fun main() {
    val data1: Int = 10
    val data2: MyInt = 10

    // 매개변수 타입을 생략한 함수 선언
    val someFun31: MyFunType = {no1, no2 ->
        no1 > no2
    } // 람다함수라서 이렇구나.

    // 변수 선언 시 타입 생략
    val somefun32 = { no1: Int, no2: Int ->
        no1 > no2
    }
}