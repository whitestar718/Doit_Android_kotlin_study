package com.example.lab4.Chap_04_DataClass

// 데이터 클래스 선언
class NonDataClass(val name:String, val email:String, val age:Int){}
data class DataClass(val name:String, val email:String, val age:Int){}


// 데이터 클래스 객체 생성
fun main() {
    val non1 = NonDataClass("eun", "aaa@aaa.com", 10)
    val non2 = NonDataClass("eun", "aaa@aaa.com", 10)

    val data1 = DataClass("eun", "bbb@bbb.com", 10)
    val data2 = DataClass("eun", "bbb@bbb.com", 10)

    // 데이터 비교
    println("non data class equals: ${non1.equals(non2)}")
    println("data class equals: ${data1.equals(data2)}" )

    // 객체(메모리값) 비교 (똑같이 true 나오는데... 뭐지)
    println("non data class equals: ${non1 == non2}")
    println("data class equals: ${data1 == data2}" )
}