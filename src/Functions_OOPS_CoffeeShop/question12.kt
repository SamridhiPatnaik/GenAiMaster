package Functions_OOPS_CoffeeShop

data class CoffeeMenu(val items: List<String>) {
    fun printMenu() {
        println("Coffee Menu:")
        for (item in items) {
            println("- $item")
        }
    }
}
fun main() {
    val menu = CoffeeMenu(listOf("Espresso", "Latte", "Cappuccino", "Mocha"))
    menu.printMenu()
}
