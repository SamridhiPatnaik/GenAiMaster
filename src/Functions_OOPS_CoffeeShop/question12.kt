package Functions_OOPS_CoffeeShop

data class CoffeeMenu(val items: String, val List:<String>) {
    fun printMenu() {
        println("Coffee Menu:")
        for (item in items) {
            println("$item")
        }
    }
}
fun main() {
    val menu = CoffeeMenu(listOf("Espresso","Latte","Americano","Mocha"))
    menu.printMenu()
}