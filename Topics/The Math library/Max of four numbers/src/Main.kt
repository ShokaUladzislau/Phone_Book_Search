import kotlin.math.*

fun main() {
    val values = arrayListOf<Int>()
    var result = Int.MIN_VALUE
    repeat(4) {
        values.add(readLine()!!.toInt())
    }

    for (i in values){
        if (result < i) result = i
    }
    println(result)
}