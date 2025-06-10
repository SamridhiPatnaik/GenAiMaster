package Functions_OOPS_CoffeeShop

class Customer(val name: String) {
    var loyaltyPoints: Int = 0

    fun addPoints(points: Int) {
        if (points > 0) {
            loyaltyPoints += points
        }
    }
}
fun main() {
    val customer = Customer("Samridhi")
    customer.addPoints(10)
    customer.addPoints(5)

    println("${customer.name} has ${customer.loyaltyPoints} loyalty points.")
}
