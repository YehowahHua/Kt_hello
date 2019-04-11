package com.Yehowah.Kt_hello.funTest

fun main(args: Array<String>) {
    println(genericFunTest<Int>("你好1",12,12,12))
    println(genericFunTest<String>("你好2","sss","ttt","rrr"))
    println(genericFunTest<Double>("你好3",12.01,12.02,12.03))

    println(getBigVararg("古代的七大发明","造纸术","印刷术","火药","指南针","丝绸","瓷器","茶叶"))
    println(getBigArray("古代的N大发明","造纸术","印刷术",arrayOf("丝绸","瓷器","茶叶"),arrayOf("国画","中医","武术")))
}


//可变参数
fun <T> genericFunTest(str:String,vararg arg:T?):String {
    var str:String = "$str: "
    for (item in arg){
        str = "$str ${item.toString()}"
    }
    return str
}

//默认参数
fun getBigVararg(general:String, first:String="纸", second:String="刷", vararg otherArray: String?):String {
    var answer:String = "$general：$first，$second"
    for (item in otherArray) {
        answer = "$answer，$item"
    }
    return answer
}

//可变参数改为可变数组
fun getBigArray(general:String, first:String="纸", second:String="印", vararg otherArray: Array<String>):String {
    var answer:String = "$general：$first，$second"
    for (array in otherArray) {
        for (item in array) {
            answer = "$answer，$item"
        }
    }
    return answer
}
