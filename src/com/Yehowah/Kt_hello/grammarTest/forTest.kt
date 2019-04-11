package com.Yehowah.Kt_hello.grammarTest


val str_Array:Array<String> = arrayOf("ss","tt","rr")
fun main(args: Array<String>) {
    forTest()
    repeatOptTest()
}
//java--: kotlin--in
fun forTest() {
    var poem:String =""
    for (item in str_Array){    //在java中使用 :
        poem = "$poem item--$item\n"
    }

    println(poem)
}
fun repeatOptTest() {
    var poem:String = ""
    for (i in str_Array.indices){
        if (i%2==0){
            poem = "$poem ${str_Array[i]} $i --2\n"
        }else{
            poem = "$poem ${str_Array[i]} $i --1\n"
        }
    }
    println(poem)
}