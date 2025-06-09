package higherOrderFun_ExceptionHandling

fun<T> Filter(list: List<T>,predicate: (T) -> Boolean):List<T> {
    val result = mutableListOf<T>()
    for (item in list) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}
fun main(){
    val numbers = listOf(1,2,3,4,5,6,7)
    val evenNumbers = Filter(numbers) { it % 2==0}
    println("Even numbers are: $evenNumbers")
}