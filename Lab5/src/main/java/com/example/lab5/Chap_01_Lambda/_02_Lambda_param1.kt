package com.example.lab5.Chap_01_Lambda
// 매개변수가 1개면 예약어 it을 쓰면, 자동으로 해당 매개변수를 지정할 수 있다.

fun main() {
    // 원래 구문
    val some = {no:Int -> println(no)}

    // it 예약어를 쓰는 경우
    // val some24 = (Int) -> Unit = {println(it)} // 왜 안되냐..
    // some2(10)
}