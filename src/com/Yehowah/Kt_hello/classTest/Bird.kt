package com.Yehowah.Kt_hello.classTest


/**
 * 父类
 */
open class Bird (var name:String, val sex:Int = MALE){
    //变量、方法、类默认都是public，所以一般都把public省略掉了
    //public var sexName:String
    var sexName:String
    init {
        sexName = getSexName(sex)
    }

    //私有的方法既不能被外部访问，也不能被子类继承，因此open与private不能共存
    //否则编译器会报错：Modifier 'open' is incompatible with 'private'
    //open private fun getSexName(sex:Int):String {
    open protected fun getSexName(sex:Int):String {
        return if(sex==MALE) "公" else "母"
    }

    fun getDesc(tag:String):String {
        return "欢迎来到$tag：这只${name}是${sexName}的。"
    }

    companion object BirdStatic{
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

/**
 * 子类
 */
class Ostrich(name:String="鸵鸟", sex:Int = Bird.MALE) : Bird(name, sex) {
    //继承protected的方法，标准写法是“override protected”
    //override protected fun getSexName(sex:Int):String {
    //不过protected的方法继承过来默认就是protected，所以也可直接省略protected
    //override fun getSexName(sex:Int):String {
    //protected的方法继承之后允许将可见性升级为public，但不能降级为private
    override public fun getSexName(sex:Int):String {
        return if(sex==MALE) "雄" else "雌"
    }
}

//子类的构造函数，原来的输入参数不用加var和val，新增的输入参数必须加var或者val。
//因为抽象类不能直接使用，所以构造函数不必给默认参数赋值。
abstract class Chicken(name:String, sex:Int, var voice:String) : Bird(name, sex) {
    val numberArray:Array<String> = arrayOf("一","二","三","四","五","六","七","八","九","十");
    //抽象方法必须在子类进行重写，所以可以省略关键字open，因为abstract方法默认就是open类型
    //open abstract fun callOut(times:Int):String
    abstract fun callOut(times:Int):String
}

class Cock(name:String="鸡", sex:Int = Bird.MALE, voice:String="喔喔喔") : Chicken(name, sex, voice) {
    override fun callOut(times: Int): String {
        var count = when {
        //when语句判断大于和小于时，要把完整的判断条件写到每个分支中
            times<=0 -> 0
            times>=10 -> 9
            else -> times
        }
        return "$sexName$name${voice}叫了${numberArray[count]}声，原来它在报晓呀。"
    }
}
//接口不能带构造函数（那样就变成一个类了），否则编译器报错“An interface may not have a constructor”
//interface Behavior(val action:String) {
interface Behavior {
    //接口内部的方法默认就是抽象的，所以不加abstract也可以，当然open也可以不加
    open abstract fun fly():String
    //比如下面这个swim方法就没加关键字abstract，也无需在此处实现方法
    fun swim():String
    //Kotlin的接口与Java的区别在于，Kotlin接口内部允许实现方法，
    //此时该方法不是抽象方法，就不能加上abstract，
    //不过该方法依然是open类型，接口内部的所有方法都默认是open类型
    fun run():String {
        return "大多数鸟儿跑得并不像样，只有鸵鸟、鸸鹋等少数鸟类才擅长奔跑。"
    }
    //Kotlin的接口允许声明抽象属性，实现该接口的类必须重载该属性，
    //与接口内部方法一样，抽象属性前面的open和abstract也可省略掉
    //open abstract var skilledSports:String
    var skilledSports:String
}


class Goose(name:String="鹅", sex:Int = Bird.MALE) : Bird(name, sex), Behavior {
    override fun fly():String {
        return "鹅能飞一点点，但飞不高，也飞不远。"
    }

    override fun swim():String {
        return "鹅，鹅，鹅，曲项向天歌。白毛浮绿水，红掌拨清波。"
    }

    //因为接口已经实现了run方法，所以此处可以不用实现该方法，当然你要实现它也行。
    override fun run():String {
        //super用来调用父类的属性或方法，由于Kotlin的接口允许实现方法，因此super所指的对象也可以是interface
        return super.run()
    }

    //重载了来自接口的抽象属性
    override var skilledSports:String = "游泳"

}
fun main(args: Array<String>) {
    var os:Ostrich = Ostrich("xx",Bird.MALE)
    println(os.getSexName(Bird.MALE))
}