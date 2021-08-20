import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val vectorOne = readLine()!!.split(" ")
    val vectorTwo = readLine()!!.split(" ")

    val aVectorB =
        vectorOne.first().toInt() * vectorTwo.first().toInt() + vectorOne.last().toInt() * vectorTwo.last().toInt()
    val moduleA = sqrt(vectorOne.first().toDouble().pow(2.0) + vectorOne.last().toDouble().pow(2.0))
    val moduleB = sqrt(vectorTwo.first().toDouble().pow(2.0) + vectorTwo.last().toDouble().pow(2.0))
    val cosY = aVectorB / (moduleA * moduleB)
    val y = Math.toDegrees(acos(cosY)).toInt()

    println(y)
}