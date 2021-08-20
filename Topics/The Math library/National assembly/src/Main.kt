import kotlin.math.*

fun main() {
    var population = readLine()!!
    var assembly = Math.cbrt(population.toDouble()).toInt()

    println(assembly)
}