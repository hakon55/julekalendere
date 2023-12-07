package knowit

import java.io.File

fun main() {
    val filePath = "src/main/resources/3-input.txt"
    var freeMoney: Long = 200000
    File(filePath).readLines().forEach {
        val prices = it.split(",").map { it.toLong() }

        val (lowStock, highStock) = findStoncks(prices)
        val diamondHands = freeMoney / lowStock
        val hodl = freeMoney % lowStock

        freeMoney = hodl + (diamondHands * highStock)
    }

    println(freeMoney)
}

fun findStoncks(dayTrade: List<Long>): Pair<Long, Long> {
    var biggestDiff = 0L
    var pair = 0L to 0L

    dayTrade.forEachIndexed { index: Int, value: Long ->
        val max = dayTrade.slice(index..dayTrade.lastIndex).max()
        val diff = max - value
        if (biggestDiff < diff) {
            biggestDiff = diff
            pair = value to max
        }
    }

    return pair
}