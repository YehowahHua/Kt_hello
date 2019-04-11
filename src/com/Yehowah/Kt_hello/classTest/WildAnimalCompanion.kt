package com.Yehowah.Kt_hello.classTest

class WildAnimalCompanion(var name:String,val sex:Int = 0) {
    var sexName:String
    init {
        sexName = if(sex==0) "公" else "母"
    }

    fun getDesc(tag:String):String {
        return "欢迎来到$tag：这只${name}是${sexName}的。"
    }

    //在类加载时就运行伴生对象的代码块，其作用相当于Java里面的static { ... }代码块
    //关键字companion表示伴随，object表示对象，WildAnimal表示伴生对象的名称
    companion object WildAnimal{
        fun judgeSex(sexName:String):Int {
            var sex:Int = when (sexName) {
                "公","雄" -> 0
                "母","雌" -> 1
                else -> -1
            }
            return sex
        }
    }

}
class WildAnimalConstant(var name:String, val sex:Int = MALE) {
    var sexName:String
    init {
        sexName = if(sex==MALE) "公" else "母"
    }

    fun getDesc(tag:String):String {
        return "欢迎来到$tag：这只${name}是${sexName}的。"
    }

    companion object WildAnimal{
        //静态常量的值是不可变的，所以要使用关键字val修饰
        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = -1
        fun judgeSex(sexName:String):Int {
            var sex:Int = when (sexName) {
                "公","雄" -> MALE
                "母","雌" -> FEMALE
                else -> UNKNOWN
            }
            return sex
        }
    }
}

fun main(args: Array<String>) {
    println(WildAnimalCompanion.WildAnimal.judgeSex("雌"))// 1
    println(WildAnimalCompanion.judgeSex("公")) // 0 可以简写,类似于static

    println(WildAnimalConstant.judgeSex("公")) // 0 可以简写,类似于static
}