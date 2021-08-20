package phonebook

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.math.min
import kotlin.math.sqrt

var startTime: Long = 0
var endTime: Long = 0

fun main() {
    val directoryPath = "/Users/uladzislaushoka/Programming/IDEA/Phone Book/directory.txt"
    val findPath = "/Users/uladzislaushoka/Programming/IDEA/Phone Book/find.txt"

    val data = Files.readAllLines(Paths.get(directoryPath))
    val find = Files.readAllLines(Paths.get(findPath))
    data.indices.forEach { data[it] = data[it].replace("[0-9]+ ".toRegex(), "") }

    println("Start searching (linear search)...")
    var startingTime = System.currentTimeMillis()
    var count = linearSearch(find, data)
    var endingTime = System.currentTimeMillis()
    print("Found " + count + " / " + find.size + " entries. Time taken: ")
    printResult(endingTime - startingTime)




    count = 0
    val linearSearchTime = endingTime - startingTime
    println("\n\nStart searching (bubble sort + jump search)...")
    val flag = bubbleSort(data, linearSearchTime)
    startingTime = System.currentTimeMillis()
    if (flag) {
        find.forEach { if (jumpSearch(data, it)) count++ }
    } else {
        count = linearSearch(find, data)
    }
    endingTime = System.currentTimeMillis()

    print("Found $count / ${find.size} entries. Time taken: ")
    printResult(endTime - startTime + endingTime - startingTime)
    print("\nSorting time: ")
    printResult(endTime - startTime)
    if (!flag) {
        print(" - STOPPED, moved to linear search")
    }
    print("\nSearching time: ")
    printResult(endingTime - startingTime)




    count = 0
    startingTime = System.currentTimeMillis()
    startTime = System.currentTimeMillis()
    println("\n\nStart searching (quick sort + binary search)...")
    val quicksortdata = quickSort(data)
    endTime = System.currentTimeMillis()
    find.forEach {
        if (binarySearch(quicksortdata, it)) {
            count++
        }
    }
    endingTime = System.currentTimeMillis()

    print("Found $count / ${find.size} entries. Time taken: ")
    printResult(endTime - startTime + endingTime - startingTime)
    print("\nSorting time: ")
    printResult(endTime - startTime)
    print("\nSearching time: ")
    printResult(endingTime - startingTime)



    count = 0
    startingTime = System.currentTimeMillis()
    startTime = System.currentTimeMillis()
    println("\n\nStart searching (hash table)...")
    val hashtabledata = createHashTable(data)
    endTime = System.currentTimeMillis()
    find.forEach {
        if (hashtabledata.containsKey(it)) {
            count++
        }
    }
    endingTime = System.currentTimeMillis()

    print("Found $count / ${find.size} entries. Time taken: ")
    printResult(endTime - startTime + endingTime - startingTime)
    print("\nCreating time: ")
    printResult(endTime - startTime)
    print("\nSearching time: ")
    printResult(endingTime - startingTime)
}

fun createHashTable(data: List<String>): Hashtable<String, Int> {
    var hashTable = Hashtable<String, Int>()

    for ((j, i) in data.withIndex()) {
        hashTable[i] = j
    }

    return hashTable
}


fun printResult(time: Long) {
    val min = time / 1000 / 60
    val sec = time / 1000 % 60
    val ms = time - min * 1000 * 60 - sec * 1000
    print("$min min. $sec sec. $ms ms.")
}

fun linearSearch(find: List<String>, data: List<String>): Int {
    var count = 0
    for (findLine in find)
        for (dataLine in data)
            if (dataLine.contains(findLine)) {
                count++
                break
            }

    return count
}

fun jumpSearch(data: List<String>, find: String): Boolean {
    var currentRight = 0
    var prevRight = 0

    if (data[currentRight] == find) {
        return true
    }

    val jumpLength = sqrt(data.size.toDouble()).toInt()
    while (currentRight < data.size - 1) {
        currentRight = min(data.size - 1, currentRight + jumpLength)
        if (data[currentRight] >= find) {
            if (data[currentRight] == find) {
                return true
            }
            break
        }
        prevRight = currentRight
    }

    return when {
        currentRight == data.size - 1 && find > data[currentRight] -> false
        else -> backwardSearch(data, find, prevRight, currentRight)
    }
}

fun binarySearch(data: List<String>, find: String): Boolean {

    var mid: Int
    var low = 0
    var high = data.size - 1

    while (low <= high) {
        mid = low + ((high - low) / 2)
        when {
            find > data[mid] -> low = mid + 1
            find < data[mid] -> high = mid - 1
            find == data[mid] -> return true
        }
    }
    return false
}

fun backwardSearch(data: List<String>, find: String, prevRight: Int, currentRight: Int): Boolean {
    for (i in currentRight - 1 downTo prevRight + 1)
        if (data[i] == find)
            return true

    return false
}

fun bubbleSort(data: MutableList<String>, linearSearchTime: Long): Boolean {
    startTime = System.currentTimeMillis()
    endTime = System.currentTimeMillis()
    for (i in 0 until data.size - 1) {
        if (linearSearchTime * 10 < endTime - startTime) {
            return false
        }
        for (j in 0 until data.size - i - 1) {
            if (data[j] > data[j + 1]) {
                val temp = data[j]
                data[j] = data[j + 1]
                data[j + 1] = temp
            }
        }
        endTime = System.currentTimeMillis()
    }

    return true
}

fun quickSort(data: MutableList<String>): List<String> {

    if (data.size < 2) return data

    val pivot = data[data.size / 2]

    val equals = data.filter { it == pivot }
    val less = data.filter { it < pivot }
    val greater = data.filter { it > pivot }

    return quickSort(less as MutableList<String>) + equals + quickSort(greater as MutableList<String>)


}

