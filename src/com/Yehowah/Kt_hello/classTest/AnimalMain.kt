package com.Yehowah.Kt_hello.classTest



class AnimalMain constructor( name:String) {
    init {
        println("这是只$name")
    }
    //二级构造函数
    constructor( name:String, sex:Int) : this( name) {
        var sexName:String = if(sex==0) "公" else "母"
        println("这只${name}是${sexName}的")
    }
}

//这样写和java差不多，写了2个二级构造函数，相互不干扰
class AnimalSeparate {
    constructor( name:String) {
        println("xxxx这是只$name")
    }

    constructor(name:String, sex:Int) {
        var sexName:String = if(sex==0) "公" else "母"
        println("xxxxx这只${name}是${sexName}的")
    }
}


//类的主构造函数使用了默认参数
class AnimalDefault ( name:String, sex:Int = 0) {
    init {
        var sexName:String = if(sex==0) "公" else "母"
        println("yyyyyy这只${name}是${sexName}的")
    }
}



fun main(args: Array<String>) {
    var animalName:String = "Papa Dog"
    var animalSex:Int = 1
    var animal = AnimalMain( animalName)
    var animal1 = AnimalMain( animalName, animalSex) //发现会执行2次

    var animal2 = AnimalSeparate( animalName)
    var animal13 = AnimalSeparate( animalName, animalSex) //不会执行2次


    var animal4 = AnimalDefault( animalName)
    var animal15 = AnimalDefault( animalName, animalSex) //不会执行2次
}