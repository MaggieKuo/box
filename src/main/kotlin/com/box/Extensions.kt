package com.kotlin

import java.util.*

fun<T> Scanner.input(msg: String, scanNext: () -> T) : T {
    print(msg)
    return scanNext()
}

