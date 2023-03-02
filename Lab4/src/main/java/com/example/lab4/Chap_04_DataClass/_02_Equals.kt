package com.example.lab4.Chap_04_DataClass

// address만 보조생성자를 사용하는 경우
data class DataClass21(val name:String, val email:String, val age:Int){
    lateinit var address: String
    constructor(name:String, email: String, age:Int, address:String):
            this(name, email, age){
                this.address = address
            }
}

fun main() {
    val obj1 = DataClass21("king", "asdf@asdf.net", 20, "Seoul")
    val obj2 = DataClass21("king", "asdf@asdf.net", 20, "Busan")
    println("obj1.equals(obj2): ${obj1.equals(obj2)}")
    // 왜 address가 다른데도 true가 나올까? -> equals함수는 주생성자만 비교하기 때문
}