package higherOrderFun_ExceptionHandling

fun operate(a: Int, b: Int, op:(Int,Int)->Int): Int {
    return op(a,b)
}
fun main() {
    val result = operate(4,3){x,y -> x * y}
    println(result)
}