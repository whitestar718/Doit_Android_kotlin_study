package com.example.lab4.Chap_05_ObjectAndCompanion

// 오브젝트 클래스 = 익명 클래스 (클래스명은 없고, 바디만 있다)
// 선언과 동시에 생성이 된다.
val obj = object {
    var data = 10
    fun some(){
        println("data: $data")
    }
}

// ★★★ 타입을 지정한 오브젝트 클래스 (이걸 많이 쓰게 된다)
open class Super {
    open var data = 10
    open fun some() {
        println("I am some() : $data")
    }
}

val obj51 = object : Super() {
    override var data = 20
    override fun some() {
        println("I am object some(): $data")
    }
}

fun main() {
    // obj는 Any 타입이 지정이 된다. Any타입은 맴버 변수 없다.
    // obj.data = 20 // 에러
    // obj.some() // error
}