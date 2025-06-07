import org.intellij.lang.annotations.Flow

fun main(){
    val coffeePrice = 200
    val message = when {
        coffeePrice < 250 ->  "low budget"
        coffeePrice in 250..400 ->  "medium budget"
        else -> "High budget"
    }
    println("CoffeePrice: $coffeePrice")

    println("The message : $message")
}
