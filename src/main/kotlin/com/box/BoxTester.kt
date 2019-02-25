package com.kotlin

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val length = scanner.input("Please enter object's length: "){scanner.nextFloat()}
    val width = scanner.input("Please enter object's width: "){scanner.nextFloat()}
    val height = scanner.input("Please enter object's height: ", {scanner.nextInt()})

    val box = Box.getInstance(length, width, height)
    println(box?.name() ?:"empty")
}

class Box{
    companion object {
        var boxs = mutableListOf(Box3(), Box5())

        fun getInstance(length: Float, width : Float, height : Int): BaseBox? {
                boxs.forEach {
                    if (it.validate(length, width, height)) return it
                }
                return null
//                when{
//                Box3.instance.validate(length, width, height) -> Box3.instance
//                Box5.instance.validate(length, width, height) -> Box5.instance
//                else -> null
        }
    }
}

interface IBox{
    var length: Float
    var width: Float
    val height: Int
    val price: Int
    fun validate(length: Float, width : Float, height : Int): Boolean
    fun name(): String
}

open abstract class BaseBox(override var length: Float,
                   override var width: Float,
                   override val height: Int) : IBox {

    init {
        if (width > length)
            length = width.also { width = length }
    }

    override fun validate(length: Float, width: Float, height: Int): Boolean {
        val mLength = maxOf(length, width)
        var mWidth = minOf(length, width)
        return this.length>=mLength && this.width>=mWidth && this.height>=height
    }
}

class Box5(): BaseBox(23f, 14f, 13){
    override var price: Int = 0
        get() = 65
    override fun name() = "小型便利箱"
//    companion object {
//        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED, {Box5()})
//    }
}

class Box3(): BaseBox(39.5f, 27.5f, 23){
    override fun name() = "90cm便利箱"
    override var price: Int = 0
        get() = 110
//    companion object {
//        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED, {Box3()})
//    }
}

