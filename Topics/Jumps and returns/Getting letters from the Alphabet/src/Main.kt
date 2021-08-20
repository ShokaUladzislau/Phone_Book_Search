fun main() {
    val input = readLine()!!.single()
    for (i in 97..input.toInt()) {
        if (i != input.toInt()) {
            print(i.toChar())
        } else {
            return
        }
    }
}
