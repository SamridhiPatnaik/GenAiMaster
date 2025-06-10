import kotlin.random.Random

fun main() {
    val tipNumber = Random.nextInt(1, 5) // Generates 1 to 4

    val tip = when (tipNumber) {
        1 -> "Tip: Life happens, coffee helps "
        2 -> "Tip: Espresso yourself — no filter needed!"
        3 -> "Tip: A yawn is a silent scream for coffee "
        4 -> "Tip: Behind every successful person is a substantial amount of coffee!"
        else -> "No tip today. Just vibes."
    }

    println("Today's Coffee Tip #$tipNumber: $tip")
}
