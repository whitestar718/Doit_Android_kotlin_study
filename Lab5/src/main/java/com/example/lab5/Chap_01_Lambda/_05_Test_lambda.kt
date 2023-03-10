package com.example.lab5.Chap_01_Lambda

fun main() {
    {no:Int -> println(no)}(10) // 가치가 없다.

    // 유추가 가능하면 생략해서 쓸 수 있다.
    val some1 = {no:Int -> println(no)}
    val some2: (Int) -> Unit = {no -> println(no)}
    val some3: (Int) -> Unit = {println(it)}
}