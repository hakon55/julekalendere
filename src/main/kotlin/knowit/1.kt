package knowit

import kotlin.math.round
val bets = arrayOf(
    Pair(1, 1.71),
    Pair(2, 2.24),
    Pair(2, 2.32),
    Pair(1, 1.73),
    Pair(3, 2.77),
    Pair(1, 1.65),
    Pair(3, 2.81),
    Pair(1, 1.71),
    Pair(2, 1.94),
    Pair(2, 2.09),
    Pair(3, 2.69),
    Pair(2, 2.14),
    Pair(1, 1.67),
    Pair(2, 2.08),
    Pair(1, 1.71),
    Pair(3, 2.64),
    Pair(1, 1.66),
    Pair(2, 2.29),
    Pair(1, 1.69),
    Pair(2, 2.24),
    Pair(1, 1.69),
    Pair(1, 1.72),
    Pair(2, 2.14),
    Pair(2, 2.26),
    Pair(2, 2.19),
    Pair(1, 1.79),
    Pair(1, 1.67),
    Pair(1, 1.72),
    Pair(2, 2.18),
    Pair(1, 1.72),
    Pair(2, 2.12),
    Pair(1, 1.74),
    Pair(1, 1.71),
    Pair(2, 2.19),
    Pair(1, 1.69),
    Pair(1, 1.77),
    Pair(1, 1.78),
    Pair(1, 1.74),
    Pair(2, 2.22),
    Pair(1, 1.72),
    Pair(4, 4.39),
    Pair(2, 2.31),
    Pair(1, 1.74),
    Pair(3, 2.87),
    Pair(1, 1.81),
    Pair(2, 2.21),
    Pair(2, 2.16),
    Pair(2, 2.38),
    Pair(1, 1.7),
    Pair(2, 2.27),
    Pair(1, 1.68),
    Pair(2, 2.19),
    Pair(1, 1.78),
    Pair(1, 1.77),
    Pair(1, 1.69),
    Pair(1, 1.72),
    Pair(1, 1.67),
    Pair(2, 2.08)
)

val goals = arrayOf(2,0,1,3,3,1,2,1,1,3,2,1,0,0,2,0,0,0,1,0,0,1,2,1,0,0,0,0,1,3,0,0,0,1,0,0,1,0,0,1,5,3,0,2,1,2,1,0,1,1,1,0,0,1,0,0,0,0)



var sukkerStenger = 50000.0

fun bet(totalt: Double): Double {
    return round(totalt * 0.175)
}

fun main() {

    bets.forEachIndexed { index, pair ->
        val (goal, odds) = pair
        val currentBet = bet(sukkerStenger)
        if (goal <= goals[index]) {
            sukkerStenger += currentBet * odds
        } else {
            sukkerStenger -= currentBet
        }
        println(50000 - sukkerStenger)
    }

}
