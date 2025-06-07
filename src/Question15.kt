fun main() {
    var stock = 10

    println("Coffee Inventory Countdown:")

    do {
        println("Stock remaining: $stock cups")
        stock--
    } while (stock >= 1)

    println("Coffee is out of stock!")
}
