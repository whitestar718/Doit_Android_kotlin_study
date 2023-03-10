package com.example.lab5.Chap_01_Lambda

// 일반 함수 선언
fun sum(no1:Int, no2:Int):Int{
    return no1+no2
}

// 람다 함수 선언
val sum = {no1:Int, no2:Int -> no1 + no2}

fun main() {
    // println(sum(10, 20))

    // 람다함수 선언하면서 바로 콜하기
    // println({no1: Int, no2:Int -> no1+no2} (40, 20))

    // 매개변수가 없는 람다 함수
    {println("function call")}
    val sss = {->println("function call")}
    sss()

}