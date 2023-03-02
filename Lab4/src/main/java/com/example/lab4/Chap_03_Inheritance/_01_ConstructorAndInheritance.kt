package com.example.lab4.Chap_03_Inheritance

open class Super { // 상속할 수 있게 open 키워드 이용
}

class Sub: Super() { // Super를 상속받아 Sub 클래스 선언

}
// 괄호를 쓰는 이유? -> 부모의 생성자를 가져오기 위해서!


// -------------------------------------------------------------

// 매개변수가 있는 상위 클래스의 생성자 호출
open class Super2(name: String) {
}
class Sub2(name:String): Super2(name){
}

// 하위 클래스에 보조생성자만 있는 경우, 상위 클래스의 생성자 호출
open class Super3(name:String){}
class Sub3: Super3{
    constructor(name:String): super(name){

    }
}
