package com.example.lab4.Chap_02_Class

// 주 생성자: 맨 윗줄에 선언되는 부분 (생략 가능)
// 보조 생성자: 대괄호 안에서 선언되는 부분

// 주생성자 선언
class User constructor() { // class User() 라고 해도 무방하다.
}

// 아무것도 선언 안 할 경우 -> 컴파일러가 자동으로 주 생성자를 생성해준다.
class User2 {
}

// 주생성자의 매개변수
class User3(name:String, count:Int){
}

// init 키워드로 주생성자의 본분 지정
class User4(name:String, count:Int){
    init {
        println("Initialize...")
    }
}

// 생성자의 매개변수 범위 -> init에서 매개변수를 쓰는 것은 가능하나, 함수 안에서 실행은 안된다.
class User5(name:String, count:Int){
    init{
        println("${name}, ${count}")
    }
    fun someFun(){
        // println("${name}, ${count}") // 에러 발생
    }
}

fun main() {
    val user = User3("dms", 3)

    // init 실행시
    // init 블록을 쓰는 이유? -> 주 생성자의 실행영역을 확보하기 위해.
    val user4 = User4("은해찬", 5)
}