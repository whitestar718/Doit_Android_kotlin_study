package com.example.lab5.Chap_01_Lambda

fun hofFun2(arg:(Int)->Boolean): () -> String {
    val result = if (arg(10)){
        "valid"
    } else {
        "invalid"
    }
    return {"result: $result"}
}

fun hofFun3(no1:Int, args:(Int) -> Boolean): ()->String{
    val result = if (args(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"result is $result"}
}

fun main() {
    // 맨 마지막 매개변수가 함수 타입일 경우, 괄호안의 것을 밖으로 뺄 수 있다...
    val result0 = hofFun2({it > 20})
    val result = hofFun2 { it > 10 }
    println(result())

    // 매개 변수가 2개인 경우, 맨마지막을 제외하고는 괄호 안에 넣어줘야 한다.
    val result1 = hofFun3(10){no:Int -> no>10}
}