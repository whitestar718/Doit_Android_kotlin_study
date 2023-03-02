package com.example.lab4.Chap_04_DataClass

class NonDataClass44(val name:String, val email:String, val age:Int)
data class DataClass44(val name:String, val email:String, val age:Int) {
    lateinit var address: String
    constructor(name:String, email:String, age:Int, address:String): this(name, email, age){
        this.address = address
    }
}

fun main() {
    val non1 = NonDataClass44("eun", "Ss@asd.com", 10)
    val non2 = NonDataClass44("eun", "Ss@asd.com", 10)

    val data1 = DataClass44("eun", "Ss@asd.com", 10, "abc")
    val data2 = DataClass44("eun", "Ss@asd.com", 10, "ccd")

    println("non1, non2: ${non1.equals(non2)}")
    println("data1, data2: ${data1.equals(data2)}")

    // ★★★ 데이터 클래스의 변수를 쉽게 로컬로 할당하기
    val name = data1.name
    val email = data1.email
    val (name1, email1) = data1
    println("$name1, $email1")
}