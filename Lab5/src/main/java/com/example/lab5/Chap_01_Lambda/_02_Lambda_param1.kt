package com.example.lab5.Chap_01_Lambda
// 매개변수가 1개면 예약어 it을 쓰면, 자동으로 해당 매개변수를 지정할 수 있다.

fun main() {
    // 원래 구문
    val some = {no:Int -> println(no)}

    // it 예약어를 쓰는 경우
    val some24: (Int) -> Unit = {println(it)}
    some24(10)
    // some2(10)

    // 람다함수에서는 리턴 구문을 못쓴다.
    // val some25 = {no1:Int, no2:Int -> return no1 * no2} // 오류!

    // 람다 함수의 반환값은 본문에서 마지막 줄의 실행 결과
    val some26 = {no1:Int, no2:Int ->
        println("in lambda function")
        no1 * no2
    }
    println(some26(20, 50))
}