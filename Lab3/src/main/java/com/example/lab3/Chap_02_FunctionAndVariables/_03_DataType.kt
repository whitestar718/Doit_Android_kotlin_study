package com.example.lab3.Chap_02_FunctionAndVariables

// 코틀린에서 모든 변수는 객체이다. (Int, Boolean, Double 모두 객체이다)

fun someFun(){
    var data1: Int = 10
    var data2: Int? = null // null 대입 가능

    data1 = data1 + 10
    data1 = data1.plus(10) // 객체의 메서드 이용 가능

    // 기초 타입 객체
    val a1: Byte = 0b00010101
    val a2: Int = 123
    val a3: Short = 123
    val a4: Long = 12344567L
    val a5: Double = 10.0
    val a6: Float = 10.0f
    val a7: Boolean = true

    // 문자와 문자열
    // 자바에서 char 타입이 정수값으로 표현되어 숫자 연산자가 들어가도 되는데, 코틀린에서는 안 먹힌다.
    val a: Char = 'a'
    /*
    if (a==1){

    } // -> 오류발생!
    */
    val str1 = "Hello\nworld"
    val str2 = """
        Hello
        World
    """ // -> 개발자가 넣은 탭이나 줄바꿈 등을 그대로 유지할 수 있어서 편리하다.
    println(str1)
    println(str2)

    // 문자열을 쉽게 삽입하기
    val name: String = "Shushu"
    println("name: $name") // 따로 복잡하게 +로 연결하지 않아도 잘 실행된다.

    // Anytype -> 모든 데이터 타입의 상위 클래스
    val anydata1: Any = 10
    val anydata2: Any = "blabla"

    class User
    val anydata3: Any = User()

    // unit - 반환문이 없는 함수
    fun unitFun():Unit {
        println(10+20)
    }
    unitFun() // Unit을 써서 반환문이 없음을 명시해준 경우

    fun unitFun2() {
        println(10+20)
    }
    unitFun2() // Unit을 명시하지 않아도 자동으로 명시가 된다.

    // Nothing -> null밖에 대입할 수 없다.

    // 코틀린에서 null 허용과 불허용을 명사해야 함.
    // -> 이걸 가능하게 해주는 것이 ? 물음표시이다.
    var nulldata1:Int = 10
    // nulldata1 = null // 오류

    var nulldata2: Int? = 10
    nulldata2 = null // 에러가 안난다. ?로 null을 표현했기 때문.

}

fun main() {
    someFun()

}