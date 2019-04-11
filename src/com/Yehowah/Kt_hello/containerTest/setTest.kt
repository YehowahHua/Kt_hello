package com.Yehowah.Kt_hello.containerTest

private var goodsMutSet : MutableSet<String> = mutableSetOf<String>()
private val goodsA : String = "orange"
private val goodsB : String = "apple"
private val goodsC : String = "pear"
private val goodsD : String = "watermelon"
private val goodsE : String = "grape"
fun main(args: Array<String>) {
    setAddTest()
    forInTest()
    iterableTest()
    forEachTest()
}
fun setAddTest() {
    //set 没有add, remove, clear 等导致集合变更的相关方法
    //mutableSet一旦添加就不会修改
    goodsMutSet.add(goodsA)
    goodsMutSet.add(goodsB)
    goodsMutSet.add(goodsC)
    goodsMutSet.add(goodsD)
    goodsMutSet.add(goodsE)
    println("水果的种类多少个：${goodsMutSet.size}")
}

//使用for in
fun forInTest() {
    var desc = ""
    for (item in goodsMutSet){
        desc = "${desc}名称: ${item}\n"//类似递归方法
    }
    println("水果：$desc")
}

//使用iterable迭代器遍历mutableSet
fun iterableTest(){
    var desc = ""
    val iterator = goodsMutSet.iterator()
    //如果迭代器还存在下一个节点，则继续取出下一个节点的记录
    while (iterator.hasNext()){
        val item = iterator.next()
        desc = "${desc}name ：${item}\n"
    }
    println("fruit: $desc")
}

//使用forEach遍历mutableSet
fun forEachTest() {
    var desc = ""
    //forEach内部使用it指代每条记录
    goodsMutSet.forEach { desc = "${desc}name：${it}\n" }
    println("水果名字: $desc")
}
