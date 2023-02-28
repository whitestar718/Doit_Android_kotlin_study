package com.example.lab3.Chap_02_FunctionAndVariables

fun main() {
    // List: 순서가 있고, 데이터 중복 허용
    // Set: 순서가 없으며, 중복 허용 안 함
    // Map: 키와 값으로 이루어진 데이터 집합으로, 키의 중복은 허용하지 않음 (python dictionary)


    // 1. immutable list
    var list = listOf<Int>(10, 20, 30)
    println("""
        list size: ${list.size},
        list data: ${list[0]}, ${list.get(1)}, ${list.get(2)}
    """.trimIndent())


    // 2. mutable list
    var list82 = mutableListOf<Int>(10, 20, 30)
    list82.add(list82.size, 20)
    list82.set(0, 50)
    println(list82[0])

    // 3. map 사용법
    var map83 = mapOf<String, String>(Pair("one", "hello"), Pair("two", "world"))
    println("${map83["one"]} ${map83["two"]}")

}