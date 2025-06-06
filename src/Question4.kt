fun main() {
    var cup1 = "small"
    var cup2 = "large"
    val temp = cup1
    cup1 = cup2
    cup2 = temp
    println("cupSize1: $cup1 and cupSize2: $cup2")
}