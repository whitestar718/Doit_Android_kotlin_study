package com.example.lab4.Chap_05_ObjectAndCompanion

// Java의 static에 해당
// Companion 클래스는 객체 생성 없이 바로 클래스 변수에 접근할 수 있다.

class Myclass42{
    var data = 10
    fun some(){
        println(data)
    }
}

class Myclass43{
    companion object {
        var data = 10
        fun some() {
            println(data)
        }
    }
}

fun main() {
    // 컴페니언 클래스를 이용하지 않은 경우 -> 클래스 변수에 바로 접근시 에러발생함
    val obj = Myclass42()
    obj.data = 20
    obj.some()
    // Myclass42.data = 20 // error
    // Myclass42.some()    // error
    
    // 컴페니언 클래스를 이용하는 경우
    Myclass43.data = 20 // 성공!
    Myclass43.some()    // 성공!
}