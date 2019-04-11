package com.Yehowah.Kt_hello.DataTypeTest

//定义数组,java中用new Int[]{}
private var string_array:Array<String> = arrayOf("how","are","you")


fun main(args: Array<String>) {
    getArrayTest()
}

fun getArrayTest() {
    var str:String = ""
    var i: Int = 0
    while (i<string_array.size){    //java中length,kotlin中使用size
        str = str + string_array[i]+", "
//        数组元素可以通过下标访问，也可通过get方法访问
//        str = str + string_array.get(i)+", "
        i++
    }
    println(str)
}
























