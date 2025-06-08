package Functions_OOPS_CoffeeShop
fun greetCustomer(name: String?): String {
    val customerName = name ?: "Guest"
    return "Hello, $customerName!"
}
fun main() {
    println(greetCustomer("Samridhi"))
    println(greetCustomer(null))
}

