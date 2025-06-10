package higherOrderFun_ExceptionHandling

fun applyTwice(x: Int , op: (Int)-> Int): Int {
    return(op(op(x)))
}
fun main(){
    val double = { n: Int -> n * 2 }

    val result = applyTwice(5, double)
    println("Result: $result")
}