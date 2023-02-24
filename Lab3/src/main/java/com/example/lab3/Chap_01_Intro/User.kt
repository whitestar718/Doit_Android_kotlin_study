package com.example.lab3.Chap_01_Intro

// Alt + Enter 치면 자동 임포트 된다.
import java.text.SimpleDateFormat
import java.util.*

var data = 10
fun formatData(date: Date): String { // : 콜론 뒤에다 다 타입이다.
    val sdformat = SimpleDateFormat("yyyy-mm-dd")
    return sdformat.format(date)
}

class User {
    var name = "hello"
    fun sayHello(){

    }
}