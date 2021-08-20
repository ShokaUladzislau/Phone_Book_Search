fun main() {
    val ship1 = readLine()!!.trim()
    val ship2 = readLine()!!.trim()
    val ship3 = readLine()!!.trim()
    var ship4 = ""
    var ship5 = ""
    
    for (i in 49..53) {
        if (i != ship1.first().toInt() && i != ship2.first().toInt() && i != ship3.first().toInt()) {
            ship4 += i.toChar() + " "
        }
    }
    
    for (i in 49..53) {
        if (i != ship1.last().toInt() && i != ship2.last().toInt() && i != ship3.last().toInt()) {
            ship5 += i.toChar() + " "
        }
    }

    println(ship4.dropLast(1))
    println(ship5.dropLast(1))
}
