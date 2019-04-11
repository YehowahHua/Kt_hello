package com.Yehowah.Kt_hello.DataTypeTest

fun main(args: Array<String>) {
    stringOptTest()
    spliteOptTest()
}



fun stringOptTest() {
    val originStr:String = "my.book.is.there"
    var origin_trim:String = originStr
    if (origin_trim.indexOf('.')>0){
        println(origin_trim.indexOf('.'))// 2
        origin_trim = origin_trim.substring(0,origin_trim.indexOf('.'))
    }
    println(origin_trim)// my
}

fun spliteOptTest() {
    val originStr:String = "my.book.is.there"
    var originList:List<String> = originStr.split(".")//返回的是List，而不是String
    var str:String = ""
    println(originList.get(1))//只需要通过index就可以获取，比java方便
    for (item in originList){
        str = str + item+", "
    }
    println(str) // my, book, is, there,
}