package com.example.lab4.Chap_03_Inheritance

// public, internal, protected, private
// 코틀린에서 기본은 public 이다.

// 접근 제한자 사용 예
open class Super31 {
    var publicData = 10
    protected var protectedData = 20
    private var privateData = 30
}

class Sub31: Super31(){
    fun subFun(){
        publicData++ // 성공
        protectedData++ // 성공
        // privateData++ // 에러
    }
}

fun main() {
    val obj = Super31()
    obj.publicData++ // 성공
    // obj.protectedData++ // 에러
    // obj.privateData++ // 에러
}