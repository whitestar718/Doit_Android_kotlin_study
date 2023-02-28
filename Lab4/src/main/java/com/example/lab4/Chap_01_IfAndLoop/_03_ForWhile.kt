package com.example.lab4.Chap_01_IfAndLoop

fun main() {
    var sum:Int = 0
    for (i in 1..10){
        sum += i
    }
    println(sum)

    // 반복 조건 컬렉션 타입 활용
    var data2 = arrayOf<Int>(10, 20, 30)
    for (i in data2.indices) {
        println(data2[i])
    }

    // 인덱스와 데이터를 가져오는 withIndex() 함수
    var data3 = arrayOf<Int>(30, 40, 50)
    for ((index, value) in data3.withIndex()) {
        print(value)
        if (index !== data3.size-1) print(',')
    }

    // while
    var x = 10
    var sum1 = 0
    while (x < 10) {
        sum += ++x // 이게 되네...
    }
    println(sum)
}