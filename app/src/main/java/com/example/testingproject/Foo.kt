package com.example.testingproject


open class Super
class Not : Super()

fun Super.whoAmI() =
    "I am super"

fun Not.whoAmI() = "I am not"
fun main() {
    val someOne = Not()
    println(someOne)
    println(someOne as Super)
    println((someOne as Super).whoAmI())
}

open class Bar {
    open fun getName() = "gouri"
    open fun getLasName(): String {
        return "panda"
    }
}

class Bar2 : Bar() {
    fun getName2() {}
    val n: String = "dkfsklf"
    override fun getName(): String {
        return super.getName()
    }

    override fun getLasName(): String {
        return super.getLasName()
    }

}

//interface Shape {
//    var vertexCount: Int
//}

//class Rectangle(override var vertexCount: Int = 4) : Shape // Always has 4 vertices
//
//class Polygon : Shape {
//    override var vertexCount: Int = 0  // Can be set to any number later
//}
open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() {
            println("Filling")
        }

        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            super@FilledRectangle.draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}

open class Polygon {
    open fun draw() {}
}

abstract class Rectangle2 : Polygon() {
    override fun draw() {}
}

class HHH : Rectangle2() {
    override fun draw() {
        super.draw()
        println("Hello")
    }
}

open class Rectangle3 {
    open fun draw() { /* ... */
    }
}

interface Polygon2 {
    fun draw() { /* ... */
    } // interface members are 'open' by default
}

class Square() : Rectangle3(), Polygon2 {
    override fun draw() {
        super<Rectangle3>.draw()
        super<Polygon2>.draw()
    }

}