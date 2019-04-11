package com.Yehowah.Kt_hello.containerTest



private var goodsMap : Map<String,String> = mapOf<String,String>()
private var goodsMutMap : MutableMap<String,String> = mutableMapOf<String,String>()
private val goodsA : String = "orange"
private val goodsB : String = "apple"
private val goodsC : String = "pear"
private val goodsD : String = "watermelon"
private val goodsE : String = "tomato"


fun main(args: Array<String>) {
    initMapTest()
//    mapAddTest()
    mapForTest()
    mapIteratorTest()
    mapForEachTest()
}

fun initMapTest() {
    // Map没有put(添加)、remove(删除)、clear(清空)等导致队列变更的相关方法
    goodsMap = mapOf("橘子" to goodsA, "苹果" to goodsB, "梨子" to goodsC, "西瓜" to goodsD, "西红柿" to goodsE)
    // 使用Pair配对方式初始化映射
    goodsMutMap = mutableMapOf(Pair("橘子",goodsA),Pair("苹果",goodsB),Pair("梨子",goodsC),Pair("西瓜",goodsD),Pair("西红柿",goodsE))
}

fun mapAddTest() {
    goodsMutMap.put("橘子",goodsA)
    goodsMutMap.put("苹果",goodsB)
    goodsMutMap.put("梨子",goodsC)
    goodsMutMap.put("西瓜",goodsD)
    goodsMutMap.put("西红柿",goodsE)
    println("水果种类：${goodsMutMap.size}")
}

//for in 遍历
fun mapForTest() {
    var desc=""
    for (item in goodsMutMap){
        desc = "${desc}--for chinese name --${item.key}--english name--${item.value}\n"
    }
    println("fruit: ${desc}")
}

//iterator 迭代器
fun mapIteratorTest() {
    var desc = ""
    val iterator = goodsMutMap.iterator()
    while (iterator.hasNext()){
        val item = iterator.next()
        desc = "${desc} --iterator--${item.key}--value--${item.value}\n"
    }
    println("fruit: ${desc}")
}

//forEach 遍历 key value
fun mapForEachTest() {
    var desc = ""
    //映射的forEach函数需要API24及以上版本支持
    //forEach内部使用key指代每条记录的键，使用value指代每条记录的值
    goodsMutMap.forEach{ key,value -> desc = "${desc} --forEach--${key}--value--${value}\n"}
//  goodsMutMap.forEach{ desc = "${desc} --forEach--${it.key}--value--${it.value}\n"} //也是可以的
    println("fruit: ${desc}")
}








