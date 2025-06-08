package Functions_OOPS_CoffeeShop
class CoffeeShop(val name: String) {

    fun printOpeningHours() {
        println("$name is open from 8:00 AM to 8:00 PM.")
    }
}
fun main() {
    val myCafe = CoffeeShop("Cafe")
    myCafe.printOpeningHours()
}

