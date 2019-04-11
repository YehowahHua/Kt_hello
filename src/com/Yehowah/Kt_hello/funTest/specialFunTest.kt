package com.Yehowah.Kt_hello.funTest

private var arrays = arrayOf(1,2,3,4,5)
private var string_array:Array<Double> = arrayOf(1.1,2.2,3.3)

fun main(args: Array<String>) {
    println(appendString<String>("古代的四大发明","造纸术","印刷术","火药","指南针"))
    println(appendString<Int>("小于10的素数",2,3,5,7))
    println(appendString<Double>("烧钱的日子",5.20,6.18,11.11,12.12))

    println(setArrayStr(arrays))
    println(setArrayStr(string_array))

}


//泛型函数
fun <T> appendString(tag:String, vararg otherInfo: T?):String {
    var str:String = "$tag："
    for (item in otherInfo) {
        str = "$str${item.toString()}，"
    }
    return str
}

//该函数不接受Array<Int>，也不接受Array<Double>，只好沦为孤家寡人
fun setArrayNumber(array:Array<Number>):String {
    var str:String = "数组元素依次排列："
    for (item in array) {
        str = str + item.toString() + ", "
    }
    return str
}
//只有内联函数才可以被具体化
inline fun <reified T : Number> setArrayStr(array:Array<T>):String {
    var str:String = "数组元素依次排列："
    for (item in array) {
        str = str + item.toString() + ", "
    }
    return str
}
