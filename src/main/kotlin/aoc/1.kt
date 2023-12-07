package aoc

fun main() {
    val file = object {}::class.java.getResource("/aoc/1.txt")?.readText()!!.split("\n")

    val digits = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    )


    val totalt = file.sumOf {
        val first = it.findAnyOf(digits)?.second?.parseDigit()
        val second = it.findLastAnyOf(digits)?.second?.parseDigit()
        "$first$second".toInt()
    }




    println(totalt)

}

private fun String.parseDigit() = when (this) {
    "one" -> "1"
    "two" -> "2"
    "three" -> "3"
    "four" -> "4"
    "five" -> "5"
    "six" -> "6"
    "seven" -> "7"
    "eight" -> "8"
    "nine" -> "9"
    else -> this
}
