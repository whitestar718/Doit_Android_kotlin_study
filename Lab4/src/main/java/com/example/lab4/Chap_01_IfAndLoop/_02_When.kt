package com.example.lab4.Chap_01_IfAndLoop

// Switch case -> When이라는 예약어를 이용해야 한다. 좀 더 파워풀하다.

fun main() {
    var data = 10

    // 방법1. 정수값으로 데이터를 주는 경우 (자바에서는 이것만 먹힌다)
    when (data) {
        10 -> println("data is 10")
        20 -> println("data is 20")
        else -> {
            println("data is not valid data")
        }
    }

    // 방법2. 아무 데이터 타입으로 조건 주기
    var data2: String = "hello"
    when (data2) {
        "hello" -> println("hello is printed")
        "wolrd" -> println("world")
        else -> {
            println("else")
        }
    }
    
    // 방법3. 다양한 유형의 데이터
    var data3: Any = 20
    when (data3) {
        is String -> println("data is String")
        20, 30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }

    // 4. 데이터를 명시하지 않는 경우
    var data4 = 10
    when {
        data4 <= 10 -> println("data is under 10")
        data > 100 -> println("data is > 100")
        else -> println("아.. 몰라.")
    }

    // 5. when도 expression으로 쓸 수 있다.
    var data5 = 10
    val result5 = when (data5) {
        10 -> "data is 10"
        20 -> "data is 20"
        else -> "data is else"
    }
    println("when expression result: ${result5}")
}