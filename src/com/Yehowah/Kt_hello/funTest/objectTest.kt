package com.Yehowah.Kt_hello.funTest

import java.text.SimpleDateFormat
import java.util.*

/**
 * Kotlin的单例对象
 */

//关键字object用来声明单例对象，就像Java中开发者自己定义的Utils工具类。
//其内部的属性等同于Java中的static静态属性，外部可直接获取属性值。
object DateUtil {
    //声明一个当前日期时间的属性，
    //返回的日期时间格式形如2017-10-01 10:00:00
    val nowDateTime: String
            //外部访问DateUtil.nowDateTime时，会自动调用nowDateTime附属的get方法得到它的值
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }

    //只返回日期字符串
    val nowDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.format(Date())
        }

    //只返回时间字符串
    val nowTime: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss")
            return sdf.format(Date())
        }

    //返回详细的时间字符串，精确到毫秒
    val nowTimeDetail: String
        get() {
            val sdf = SimpleDateFormat("HH:mm:ss.SSS")
            return sdf.format(Date())
        }

    //返回开发者指定格式的日期时间字符串
    fun getFormatTime(format: String=""): String {
        val ft: String = format
        val sdf = if (!ft.isEmpty()) SimpleDateFormat(ft)
        else SimpleDateFormat("yyyyMMddHHmmss")
        return sdf.format(Date())
    }
}

fun main(args: Array<String>) {
    var count=0


    var data:String= when (count) {
        0 -> "当前日期时间为${DateUtil.nowDateTime}"
        1 -> "当前日期为${DateUtil.nowDate}"
        2 -> "当前时间为${DateUtil.nowTime}"
        3 -> "当前毫秒时间为${DateUtil.nowTimeDetail}"
        else -> "当前中文日期时间为${DateUtil.getFormatTime("yyyy年MM月dd日HH时mm分ss秒")}"
    }

    println(data)

}