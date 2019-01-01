package com.kotlin

import java.util.*
import javax.lang.model.type.NullType

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val length = scanner.input("Please enter object's length: "){scanner.nextFloat()}
    val width = scanner.input("Please enter object's width: "){scanner.nextFloat()}
    val height = scanner.input("Please enter object's height: ", {scanner.nextInt()})

    val box = Box.getInstance(length, width, height)
    println(box?.getName() ?:"empty")
}

class Box{
    companion object {
        fun getInstance(length: Float, width : Float, height : Int): BaseBox? =
            when{
                Box3().validate(length, width, height) -> Box3()
                Box5().validate(length, width, height) -> Box5()
                else -> null
        }
    }
}

interface IBox{
    var length: Float
    var width: Float
    val height: Int
    fun validate(length: Float, width : Float, height : Int): Boolean
    fun getName(): String
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
    override fun getName()= "Box3"
}

class Box5(): BaseBox(39.5f, 27.5f, 23){
    override fun getName()= "Box5"
}

