fun main() {

    // 1. Hello Kotlin
    println("Hello Kotlin!!!")

    // 2. Employee Bonus
    print("Enter department code: ")
    val dept_code = readln().uppercase()

    print("Enter years of experience: ")
    val years = readln().toInt()

    print("Enter employee salary: ")
    val salary = readln().toDouble()

    val bonusPercent = when {
        dept_code == "IT" && years > 5 -> 20
        dept_code == "HR" && years > 3 -> 15
        dept_code == "SALES" && years > 2 -> 12
        else -> 10
    }

    val bonus = salary * bonusPercent / 100

    println("Bonus Percentage: $bonusPercent%")
    println("Bonus Amount: $bonus")

    // 3. Average of Individual Digits
    print("Enter an integer: ")
    var num = kotlin.math.abs(readln().toInt())

    var sum = 0
    var count = 0

    while (num > 0) {
        val digit = num % 10
        sum += digit
        count++
        num /= 10
    }

    if (count > 0) {
        val average = sum.toDouble() / count
        println("Average of digits: $average")
    } else {
        println("Average of digits: 0.0")
    }
}