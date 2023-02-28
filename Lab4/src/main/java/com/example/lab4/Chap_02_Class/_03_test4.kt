package com.example.lab4.Chap_02_Class


// 자바 스타일
class User42 (name:String, count:Int){
    var name: String
    var count: Int
    init{
        this.name = name
        this.count = count
    }
    fun someFun(){
        // println("${name}, ${count}")// 에러난다.
    }
}

// 코틀린 스타일
class User43(val name:String, val count:Int){
    fun someFn(){
        println("${name}, ${count}")
    }

}

fun main() {
    val user42 = User42("sisi", 3)
    val user43 = User43("aaa", 55)
    user43.someFn()
}