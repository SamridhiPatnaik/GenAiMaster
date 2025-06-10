package Functions_OOPS_CoffeeShop

fun getCoffeePrice(size: String?): Double {
return when (size?.lowercase()){
    "small" -> 150.00
    "medium" -> 220.00
    "large" -> 300.00
    else -> 0.00
}
}
fun main(){
    val price1 =  getCoffeePrice("Medium")
    val price2 =  getCoffeePrice(null)
    val price3 =  getCoffeePrice("Extra Large")
    println("Price 1: $$price1")
    println("Price 2: $$price2")
    println("Price 3: $$price3")
}