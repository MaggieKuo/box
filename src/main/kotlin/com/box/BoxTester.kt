package com.kotlin

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val length = scanner.input("Please enter object's length: "){scanner.nextFloat()}
    val width = scanner.input("Please enter object's width: "){scanner.nextFloat()}
    val height = scanner.input("Please enter object's width: ", {scanner.nextInt()})

    var box = Box.getInstance(length, width, height)
    println(box?.getName())
}

interface IBox{
    var length: Float
    var width: Float
    val height: Int
    fun validate(length: Float, width : Float, height : Int): Boolean
    fun getName(): String
}

class Box{
    companion object {
        fun getInstance(length: Float, width : Float, height : Int): BaseBox? {
            var box: BaseBox? = null
            when{
                Box3().validate(length, width, height) -> box = Box3()
                Box5().validate(length, width, height) -> box = Box5()
            }
            return box
        }
    }
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

class Box3(): BaseBox(23f, 14f, 13){
    override fun getName(): String {
        return "Box3"
    }
}
class Box5(): BaseBox(39.5f, 27.5f, 23){
    override fun getName(): String {
        return "Box5"
    }
}

