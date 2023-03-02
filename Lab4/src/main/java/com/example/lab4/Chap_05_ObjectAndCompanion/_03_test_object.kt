package com.example.lab4.Chap_05_ObjectAndCompanion

open class Super43{
    open var data1 = 10
    open fun some() {

    }
}

val obj43 = object : Super43() {
    val data = 10
    override var data1 = 10
    override fun some() {
        data1++
    }
}

fun main() {
    obj43.data1++ // Any타입이라서 안된다. 되게 하려면 Super써서 상속받아야 한다.
}