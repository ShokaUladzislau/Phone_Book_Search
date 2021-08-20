fun main() {
    var word = readLine()
    for (i in 'a'..'z') {
        if (word != null) {
            if (word.contains(i)){
                continue
            } else {
                print(i)
            }
        }
    }
}