fun main() {
    var orderCount = 0

    while (true) {
        orderCount++
        println("Taking coffee order #$orderCount")

        if (orderCount == 5) {
            println("Rush hour!")
            break
        }
    }
}
