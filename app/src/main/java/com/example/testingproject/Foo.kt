package com.example.testingproject

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val KEY = "arrayKey"
    val arrayList = ArrayList<Int>()
    repeat(9) {
        arrayList.add(it)
    }
    val grouping: Map<String, List<Int>> = arrayList.groupBy {
        return@groupBy KEY
    }
    val grouping2: Map<String, List<Int>> =
        arrayList.groupBy(
            { return@groupBy "" },
            { return@groupBy 2 }
        )
    try {
        val values = grouping.getValue(KEY)
        val keys = grouping.keys
        println("values $values")
        println("keys $keys")
        grouping.forEach {
            println("key is ${it.key} and value is ${it.value}")
        }
        grouping.forEach { t, u ->
            println("t is $t , u is $u")
        }
    } catch (e: NoSuchElementException) {
        e.printStackTrace()
        println("No such value Element exception.May be you tried with wrong key")
    }


}

public fun foo(x: Int) {

}

public inline fun <T, R> Iterable<T>.groupBy2(keySelector: (T) -> R): Map<R, List<T>> {
    TODO()
}

public inline fun <T, R, V> Iterable<T>.groupBy3(
    keySelector: (T) -> R,
    valueSelector: (T) -> V
): Map<R, List<V>> {
    TODO()
}

fun <T, R> ArrayList<T>.map2(transform: (T) -> R): List<R> {
    val newArrayList = ArrayList<R>()
    for (value in 0 until this.size) {
        newArrayList.add(transform(this[value]))
    }
    return newArrayList
}

fun <T> ArrayList<T>.filter2(predicate: (T) -> Boolean): List<T> {
    val newArrayList = ArrayList<T>()
    for (value in 0 until this.size) {
        if (predicate(this[value])) {
            newArrayList.add(this[value])
        }
    }
    return newArrayList
}