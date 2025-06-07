fun main() {
    val temperature = 65

    val status = when {
        temperature < 60 -> "Too Cold"
        temperature in 60..70 -> "Perfect"
        else -> "Too Hot"
    }

    println("Coffee Temperature: $temperature°C → $status")
}
