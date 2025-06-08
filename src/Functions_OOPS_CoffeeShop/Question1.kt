package Functions_OOPS_CoffeeShop
fun welcomeMessage(coffeeType: String): String {
    return "Enjoy your $coffeeType!"
}
fun main() {
    val message = welcomeMessage("Latte")
    println(message)
}
