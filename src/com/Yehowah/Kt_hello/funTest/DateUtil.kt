package com.Yehowah.Kt_hello.funTest

import java.text.SimpleDateFormat
import java.util.*

/**
 *  Kotlin的扩展函数
 */

//方法名称前面的Date.表示该方法扩展自Date类
//返回的日期时间格式形如2017-10-01 10:00:00
fun Date.getNowDateTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(this)
}

//只返回日期字符串
fun Date.getNowDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(this)
}

//只返回时间字符串
fun Date.getNowTime(): String {
    val sdf = SimpleDateFormat("HH:mm:ss")
    return sdf.format(this)
}

//返回详细的时间字符串，精确到毫秒
fun Date.getNowTimeDetail(): String {
    val sdf = SimpleDateFormat("HH:mm:ss.SSS")
    return sdf.format(this)
}

//返回开发者指定格式的日期时间字符串
fun Date.getFormatTime(format: String=""): String {
    var ft: String = format
    val sdf = if (!ft.isEmpty()) SimpleDateFormat(ft)
    else SimpleDateFormat("yyyyMMddHHmmss")
    return sdf.format(this)
}


fun main(args: Array<String>) {
    var count=0

    // Kotlin的扩展函数，无需声明专门的DateUtil工具类
    var data:String = when (count) {
        0 -> "当前日期时间为${Date().getNowDateTime()}"
        1 -> "当前日期为${Date().getNowDate()}"
        2 -> "当前时间为${Date().getNowTime()}"
        3 -> "当前毫秒时间为${Date().getNowTimeDetail()}"
        else -> "当前中文日期时间为${Date().getFormatTime("yyyy年MM月dd日HH时mm分ss秒")}"
    }

    println(data)

}