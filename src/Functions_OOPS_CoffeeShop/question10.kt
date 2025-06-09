package Functions_OOPS_CoffeeShop

class CoffeeCup(val temperature: Int) {

    fun isTooHot(): Boolean {
        return temperature > 70
    }
}

fun main() {
    val myCoffee = CoffeeCup(75)

    if (myCoffee.isTooHot()) {
        println("The coffee is too hot!")
    } else {
        println("The coffee is at a safe temperature.")
    }
}