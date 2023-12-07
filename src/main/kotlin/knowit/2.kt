package knowit

import java.io.BufferedReader
import java.io.File
import java.io.FileReader


fun main() {
    // Specify the path to your text file
    val filePath = "/home/hakon/IdeaProjects/test-gradle/src/main/resources/2-log.txt"

    // Read the file content and split it into an array
    val dataArray = readAndSplitFile(filePath)
    var locks = 0
    var sylinder =
        mutableMapOf<Int, Boolean>(1 to false, 2 to false, 3 to false, 4 to false, 5 to false, 6 to false, 7 to false)
    // Print the elements of the array
    dataArray.forEach {
        if (it.contains("klikk")) {
            println(it[it.lastIndex].digitToInt())
            sylinder[it[it.lastIndex].digitToInt()] = true
        } else if (it.contains("klakk")) {
            sylinder[it[it.lastIndex].digitToInt()] = false
        }
        if (!sylinder.containsValue(false)) {
            locks++
            sylinder = mutableMapOf<Int, Boolean>(
                1 to false,
                2 to false,
                3 to false,
                4 to false,
                5 to false,
                6 to false,
                7 to false
            )

        }
    }
    println(locks)
}

fun readAndSplitFile(filePath: String): Array<String> {
    val file = File(filePath)

    // Check if the file exists
    if (!file.exists()) {
        throw IllegalArgumentException("File not found: $filePath")
    }

    // Read the file content and split it into an array
    BufferedReader(FileReader(file)).use { reader ->
        val content = reader.readLine()
        return content.split(",").toTypedArray()
    }
}
