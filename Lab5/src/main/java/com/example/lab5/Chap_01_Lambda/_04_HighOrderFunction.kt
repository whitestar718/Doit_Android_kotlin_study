package com.example.lab5.Chap_01_Lambda

fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if (arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

fun main() {
    val result = hofFun { no -> no > 10 }
    println(result())
}