fun main() {
    println("Prices of coffee from $1 to $10: ")
    for (price in 1..10){
        if(price % 2 == 0){
            println("$price - Exclusive deal for better brew!")
        }
    }
}