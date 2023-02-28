package com.example.lab4.Chap_02_Class

// 생성자의 매개변수를 다른 함수에서 사용하는 예 (자바 스타일)
class User21(name:String, count:Int){
    var name: String
    var count: Int

    init{
        this.name = name
        this.count = count
    }
}

// ★★★ 생성자의 매개변수를 클래스의 맴버 변수로 바로 선언하는 법
class User22(val name:String, val count:Int){
    fun someFun(){
        println("${name}, ${count}")
    }
}

// ★★★★
// 원래 매개변수는 variable이 안되지만, 생성자에서 주생성자만! 가능하다.
// 보조 생성자도 불가하다.