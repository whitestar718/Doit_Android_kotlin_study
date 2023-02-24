package com.example.lab3.Chap_02_FunctionAndVariables

// 1. 함수의 파라미터는 기본적으로 val이다.
fun some6(data1: Int){
    // data1 = 20
}

// 2. 파라미터에 기본값을 지정할 수 있다. (파이썬과 동일)
fun some62(data1:Int, data2:Int=10):Int{
    return (data1 + data2)
}

// 3. named parameter를 사용하면, 순서를 지키지 않아도 된다.
fun some63(data1:Int, data2:Int=10):Int{
    return (data1 + data2)
}


fun main() {
    // 2번 실행
    println(some62(10))
    println(some62(10, 20))
    
    // 3번 실행
    println(some63(data2 = 20, data1 = 40))
}