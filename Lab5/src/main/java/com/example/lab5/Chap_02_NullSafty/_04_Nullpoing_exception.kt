package com.example.lab5.Chap_02_NullSafty

fun some(data:String?): Int {
    return data!!.length
}

fun main() {
    println(some("kkang"))
    println(some(null)) // 에러가 강제로 난다.
}