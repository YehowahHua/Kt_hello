package com.Yehowah.Kt_hello.grammarTest

fun main(args: Array<String>) {
    ifTest()
    whenTest()
    when4Test()
    when5Test()
}


var is_odd:Boolean = true
fun ifTest() {
    var simple = "xxxxxxxxxxxxxxxxxxxxxx"
    if (is_odd){
        simple = "yyyyyyyyyyyyyyyyyyy"
    }else{
        simple = "zzzzzzzzzzzzzzzzzz"
    }
    //可以把上面的简写成这样，类似三元运算符,所以kotlin不再支持三元运算符
    simple = if (is_odd) "hhhhhhhhhhhhhhhh" else "qqqqqqqqqqqqqqqqqqqqq"

    println(simple)

}

fun whenTest() {
    //对于switch/case扩充
    var count:Int= 0
    var str:String = ""
    when(count){
        0 -> str = "i want to you"
        1 -> str = "perfect"
        else -> str = "other"
    }
    count = (count+1)%3
    println(str)
}

fun when2Test() {
    //对于switch/case扩充
    var count:Int= 0
    var str:String = ""
    str = when(count){  //简化
        0 -> "i want to you"
        1 -> "perfect"
        else -> "other"
    }
    count = (count+1)%3
    println(str)
}

fun when3Test() {
    //对于switch/case扩充
    var count:Int= 0
    var odd:Int = 0 //可以使用变量,java中不可以
    var even:Int = 1

    var str:String = ""
    str = when(count){
        odd -> "i want to you"
        even -> "perfect"
        else -> "other"
    }
    count = (count+1)%3
    println(str)
}

fun when4Test() {
    //对于switch/case扩充
    var count:Int= 6
    var str:String = ""
    str = when(count){
        1,3,5 -> "i want to you"    //可以多组常量判断
        in 14..20 -> "perfect"
        !in 7..10 -> "asdad" //
        else -> "other"
    }
    count = (count+1)%3
    println(str)
}

fun when5Test() {
    //对于switch/case扩充
    var count:Int= 1
    var countType:Number
    var str:String = ""
    countType = when (count){
        0 -> count.toLong()
        1 -> count.toDouble()
        else -> count.toFloat()
    }

    str = when(countType){
        is Long -> "is long ${countType}"   //添加了类型判断
        is Double -> "is Double  ${countType}" // is Double  1.0
        else -> "other ${countType}"
    }
    count = (count+1)%3
    println(str)
}