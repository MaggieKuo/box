package com.kotlin

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Please enter object's length: ")
    val length = scanner.nextFloat()
    println("Please enter object's width: ")
    val width = scanner.nextFloat()
    println("Please enter object's height: ")
    val height = scanner.nextInt()

    if (Box3().validate(length, width, height))
        println(Box3.BOX_NAME)
    else if (Box5().validate(length, width, height))
        println(Box5.BOX_NAME)
    else
        println("Sorry.")
}

interface Box{
    var length: Float
    var width: Float
    val height: Int
    fun validate(length: Float, width : Float, height : Int): Boolean
}

open class BaseBox(override var length: Float,
                   override var width: Float,
                   override val height: Int) : Box {
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

class Box3(): BaseBox(20f, 11f, 9){
    companion object {
        val BOX_NAME = "Box3"
    }
}
class Box5(): BaseBox(15f, 18f, 10){
    companion object {
        val BOX_NAME = "Box5"
    }
}

