fun main() {
    for (orderNumber in 1..10) {
        if (orderNumber % 3 == 0) {
            println("Skipping order #$orderNumber (decaf)")
            continue
        }
        println("Processing coffee order #$orderNumber")
    }
}
