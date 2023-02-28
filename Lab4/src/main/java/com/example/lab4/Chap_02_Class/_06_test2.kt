package com.example.lab4.Chap_02_Class

class User61(name:String){
    constructor(name:String, count:Int):this(name){
        println("constructor(name:String, count:Int)...")
    }

    // 꼭 폭포처럼 거슬러 올라가지 않아도 된다. 주 생성자만 연결해주면 된다.
    constructor(name:String, count:Int, email:String): this(name){
        println("constructor(name:String, count:Int, email:String)")
    }
}

fun main() {
    val user61 = User61("eun", 4, "aa@a")

}