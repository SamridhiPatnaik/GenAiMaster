fun main(){
    val originalPrice = 120
    println("Coffee Discount")
    println("Original Price: $originalPrice")
    println("        ")
    println("Discount %  Discount Price")
    println("  ")
    for (dis in 10..50 step 10){
        val discountAmount = originalPrice * dis/100
        val discountPrice = originalPrice - discountAmount
        val discount = ""
        println(" $discount% Rs $discountPrice" )
    }

}