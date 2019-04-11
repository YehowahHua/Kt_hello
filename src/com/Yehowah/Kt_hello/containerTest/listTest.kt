package com.Yehowah.Kt_hello.containerTest

private var goodsMutList : MutableList<String> = mutableListOf<String>()
private val goodsA : String = "orange"
private val goodsB : String = "apple"
private val goodsC : String = "pear"
private val goodsD : String = "watermelon"
private val goodsE : String = "tomato"
var sortAsc = true
fun main(args: Array<String>) {
    listAddTest()
    listSortTest()
    listSortTest()
}

fun listAddTest() {
    goodsMutList.add(goodsA)
    goodsMutList.add(goodsB)
    goodsMutList.add(goodsC)
    goodsMutList.add(goodsD)
    goodsMutList.add(goodsE)
    println("水果的种类多少个：${goodsMutList.size}")
}

fun listSortTest() {
    if (sortAsc){
        //sortBy表示升序排序，后面跟的是排序条件
        goodsMutList.sortBy { it.length }
    }else{
        //sortByDescending表示降序排序，后面跟的是排序条件
        goodsMutList.sortByDescending { it.length }
    }
    var desc = ""
    for (item in goodsMutList){
        desc = "${desc}--fruit--${item}\n"
    }
    println("水果：$desc")
    sortAsc = !sortAsc
}
