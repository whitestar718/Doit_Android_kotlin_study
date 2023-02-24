package com.example.lab3.Chap_02_FunctionAndVariables

import com.example.lab3.Chap_01_Intro.User

// int 타입 추론으로 정의
val data_test1 = 10
var data_test2 = 10

fun myfun(){
    // data_test1 = 10 //에러난다. immutable
    data_test2 = 20 // 바꿀수 있다.
}

// lateinit var data_test3 : Int // error
// 기초데이터 타입은 lateinit 쓸 수 없다.

lateinit var user: User
lateinit var data_test4 : String

val data_test5 by lazy {
    println("in lazy...")
    10
}

fun main(){
    println("main")
    println(data_test5) // in lazy가 프린트 된다.
    println(data_test5) // in lazy가 프린트 되지 않는다.
}