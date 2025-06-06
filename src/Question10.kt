fun main() {
    val caffeineLevel = 50
    val strength = when (caffeineLevel) {
        in 0..30->"Mild"
        in  31..70->"Medium"
        in 71..100->"Strong"
        else ->"Unknown Strength"
    }
    println("Caffeine Level: $caffeineLevel and strength:$strength")
}