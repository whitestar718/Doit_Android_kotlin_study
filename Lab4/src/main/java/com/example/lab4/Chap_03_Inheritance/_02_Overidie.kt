package com.example.lab4.Chap_03_Inheritance

// 상속 관계인 두 클래스
open class Super21 {
    var superData21 = 10
    fun superFun21(){
        println("I am superFun21:${superData21}")
    }
}

class Sub21: Super21(){
}

// 오버라이드 -> 여기도 상속 가능하게 하려면, open을 써야 한다.
open class Super22{
    open var someData = 10
    open fun someFun22() {
        println("I am super class somefun:${someData}")
    }
}

// 오버라이드 할 때는 override 예약어를 붙여줘야 한다.
class Sub22:Super22(){
    override var someData = 20
    override fun someFun22(){
        println("I am subclass function: ${someData}")
    }
}

fun main() {
    val obj = Sub22()
    obj.someFun22()
}