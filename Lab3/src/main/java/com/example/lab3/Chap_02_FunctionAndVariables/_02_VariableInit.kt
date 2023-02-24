package com.example.lab3.Chap_02_FunctionAndVariables

// 1. lateinit을 이용한 방법
// 가급적 초기값을 할당해 주는 것이 좋다.
// 예외가 있긴 한데, 함수 안에서 사용할 때만 초기값을 안 줘도 된다.
// 심지어 null도 초기값이다. 아무것도 안줄 수는 없는 것이다.

// val data1 = Int // 오류 발생
val data3 = 10 // 성공

// 초기값 할당 미루기 (var만 사용 가능!)
// Int, Long, Short, Double, Float, Boolean, Byte 타입에는 사용할 수 없다.
lateinit var lateVar: String

// 2. lazy 키워드를 이용한 방법
// 어딘가에서 실행되는 순간 변수값이 초기화 된다.
val date4: Int by lazy {
    10
} // -> 예를 들어 이렇게 했지만, 사실 공간낭비다. val date4: Int = 10이랑 다를게 없다.
// 변수가 처음 할당될 때, 특정한 계산이 필요한 경우 등에만 사용한다.