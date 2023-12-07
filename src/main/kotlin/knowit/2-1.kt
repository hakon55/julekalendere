package knowit

import java.io.File

fun main() {
    val filePath = "src/main/resources/2-log.txt"
    val file = File(filePath).readText().split(" ")
    println((file.count { it == "klikk" } - file.count { it == "klakk" }) / 7)
}