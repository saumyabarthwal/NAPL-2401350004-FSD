fun main() {


    var name: String = "Saumya"
    var nickname: String? = null

    println("Non-nullable String: $name")
    println("Nullable String: $nickname")

   

    nickname = "Sam"
    println("Updated Nullable String: $nickname")


    // 2. Safe Call Operator

    println("\n----- Safe Call Operator -----")

    var studentName: String? = null

    println("Name Length: ${studentName?.length}")

    studentName = readlnOrNull()
    println("Name Length: ${studentName?.length}")


    // 3. Elvis Operator 

    println("\n----- Elvis Operator -----")

    var city: String? = null

    val result = city ?: "City Not Available"
    println("City: $result")

    city = readlnOrNull()

    val result2 = city ?: "City Not Available"
    println("City: $result2")


    // 4. Not-null Assertion Operator 

    println("\n----- Not-null Assertion Operator -----")

    var course: String? = null

    try {
        println("Course Length: ${course!!.length}")
    } catch (e: NullPointerException) {
        println("Exception Caught: Cannot access null value")
    }

    course = readlnOrNull()

    try {
        println("Course Length: ${course!!.length}")
    } catch (e: NullPointerException) {
        println("Exception Caught: Cannot access null value")
    }
}