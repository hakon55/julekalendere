package aoc

fun main() {
    val input = object {}::class.java.getResource("/aoc/2.txt")?.readText()!!.split("\n")

    val limits = mapOf("blue" to 14, "green" to 13, "red" to 12)
    input.filter { s ->
        s.substringAfter(": ").split("; ").forEach { result ->
            result.split(", ").forEach { cube ->
                val color = cube.substringAfter(" ")
                val count = cube.substringBefore(" ").toInt()
                if (checkNotNull(limits[color]) < count) return@filter false
            }
        }
        true
    }.sumOf { it.substringAfter("Game ").substringBefore(":").toInt() }.let { println(it) }

    input.sumOf { s ->
        val minimumRequiredCubes = mutableMapOf("blue" to 0, "green" to 0, "red" to 0)
        s.substringAfter(": ").split("; ").forEach { result ->
            result.split(", ").forEach { cube ->
                val color = cube.substringAfter(" ")
                val count = cube.substringBefore(" ").toInt()
                if (checkNotNull(minimumRequiredCubes[color]) < count) minimumRequiredCubes[color] = count
            }
        }
        minimumRequiredCubes.values.fold(1L) { acc, entry -> entry * acc }
    }.let { println(it) }

}
