package com.example.lab3.Chap_02_FunctionAndVariables

fun someFun2(){
    // var data1: Int = null // 에러난다. 물음표가 없으니까
    var data42: Int? = null // 물음표를 붙여줬으니까 가능
    var data43: Int? = 10
    data43 = null // 물음표를 붙이면 뒤에가서 null을 할당하는 것도 가능하다.

    class User

    var user1: User? = User()
    user1 = null // 클래스 객체도 물음표로 널할당이 가능하다.

    fun sum(no:Int):Int {
        var sum = 0
        for (i in 1..no){
            sum += i
        }
        return sum
    }

    val name = "Eun"
    println("name: $name, sum: ${sum(10)}") // 함수를 문자열에서 쉽게 쓰려면 대괄호를 열어준다.
}

fun main() {
    someFun2()
}