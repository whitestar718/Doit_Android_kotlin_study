package com.example.lab4.Chap_02_Class

// 최종 목적은 주 생성자까지 실행하는 것이다.

class SubCon{
    constructor(name:String){
        println("니 이름이 뭐니")
    }
    
    constructor(name:String, count:Int){
        print("숫자를 선언하지")
    }
}

// 주생성자와 보조생성자를 같이 쓰는 경우
// 둘다 쓰려면, 반드시 주생성자와 보조 생성자와의 관계를 명시 해줘야 한다.
class User51(name:String){
    constructor(name:String, count:Int): this(name){

    }
}

// 보조 생성자가 여럿일 경우 연결 방법
class User52(name: String){
    constructor(name:String, count:Int):this(name){
        println("sub constructor 1")
    }

    constructor(name:String, count:Int, email:String):this(name, count){
        println("sub constructor 2")
    }
}

fun main() {
    val user1 = SubCon("kkang")
    val user2 = SubCon("eun", 4)
    val user3 = User52("asdf", 3, "nono@hanmir.com")
}