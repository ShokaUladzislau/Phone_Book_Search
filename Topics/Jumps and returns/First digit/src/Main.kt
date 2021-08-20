fun main() {
    val input = readLine()!!
    for (num in input) {
        if (num.isDigit()) {
            println(num)
            return
        }
    }
}
