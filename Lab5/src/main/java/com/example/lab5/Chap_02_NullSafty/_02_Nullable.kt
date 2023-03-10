package com.example.lab5.Chap_02_NullSafty

var data21: String = "Eun"
// data21 = null // 에러난다.

fun main() {
    var data22: String? = "Eun"
    println(data22?.length) // nullable은 ?.으로 호출해야 한다.
}
