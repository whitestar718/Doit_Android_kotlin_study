package com.example.lab4.Chap_05_ObjectAndCompanion

class Myclass {
    var data = 10
    companion object {
        var data1 = 10
        fun some(){}
    }
}

fun main() {
    Myclass.data1 = 20 // 직접 접근하는게 가능하다.
}