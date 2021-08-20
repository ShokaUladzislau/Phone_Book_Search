import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {

    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val root2: Double
    val root1: Double
    val output: String

    val determinant = b * b - 4.0 * a * c

    // condition for real and different roots
    if (determinant > 0) {
        root2 = (-b + Math.sqrt(determinant)) / (2 * a)
        root1 = (-b - Math.sqrt(determinant)) / (2 * a)

        output = "${min(root1, root2)} ${max(root1, root2)}"
    }
    // Condition for real and equal roots
    else if (determinant == 0.0) {
        root1 = -b / (2 * a)
        root2 = root1

        output = "$root2"
    }
    // If roots are not real
    else {
        val realPart = -b / (2 * a)
        val imaginaryPart = Math.sqrt(-determinant) / (2 * a)

        output = "%f+%fi %f-%fi".format(realPart, imaginaryPart, realPart, imaginaryPart)
    }

    println(output)
}