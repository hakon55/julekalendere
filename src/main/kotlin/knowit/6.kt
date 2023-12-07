package knowit

import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt


fun main() {

    val filePath = System.getProperty("user.dir") + "/src/main/resources/knowit/6.txt"
    val svar = Path(filePath).readLines().windowed(2).map { coords ->
        println(coords)
        val firstCoord = coords[0].split(",")
        val secoundCoord = coords[1].split(",")
        val x1 = firstCoord[0].toDouble()
        val y1 = firstCoord[1].toDouble()
        val x2 = secoundCoord[0].toDouble()
        val y2 = secoundCoord[1].toDouble()

        val dist = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
        println(dist)
        dist
    }.sum()
    println((svar / 1000) * 9)
//    println(System.getProperty("user.dir"))
}
