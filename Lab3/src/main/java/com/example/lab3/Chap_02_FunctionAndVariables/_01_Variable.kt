package com.example.lab3.Chap_02_FunctionAndVariables


// var는 variable(변수)를 뜻한다. (mutable)
// val은 value를 뜻한다. (immutable)

val data1 = 10
var data2 = 10

fun main() {
    // data1 = 10 -> 변경 불가능하다. val로 선언되었기 때문
    var data2 = 20
    println(data2) // 변경 가능하다. variable이기 때문.

    var data1: Int = 10 // 타입을 명시해준 경우
    val data3 = 10 // 타입을 추론해서 자동으로 할당된 경우

    // 타입은 : <- 콜론으로 지정해준다.
}