package knowit


fun main() {
    var a = ""
    var counter = 0

    for (i in 0..100000) {
        if (!a.contains(i.toString())) {
            a += i.toString()
            counter += 1
        }
    }

    println(counter)
}

private fun firstTry() {
    val upper = 99999
    val mutList = (-1..9).toMutableList()
    println(mutList)
    val blackList = mutableListOf<Int>()
    (9..upper).forEach a@{ tall ->

        val windowList = mutList.windowed(tall.toString().length)
        windowList.forEach { liste ->
            if (liste.joinToString(separator = "").contains(tall.toString())) {
                return@a
            }
        }
        mutList.add(tall)
    }

    println(mutList.count())
}
