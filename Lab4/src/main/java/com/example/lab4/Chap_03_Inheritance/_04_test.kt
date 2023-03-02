package com.example.lab4.Chap_03_Inheritance

open class Super41{
    var publicData = 10
    protected  var protectedData = 10
    private var privateData = 10

    open var someData = 10
    open fun someFun() {}
}

class Sub41: Super41(){
    override var someData = 10
    override fun someFun() {
        publicData++
        protectedData++
        // privateData++ // 에러
    }
}

fun main() {
    val obj = Sub41()
    obj.publicData++
    // obj.protectedData++// 상속 관계가 없어서 그렇다.
    // 당연히 private도 에러가 난다.
}