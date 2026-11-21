// 1. Function with Default Parameters
fun student(name: String = "Saumya", age: Int = 20) {
    println("Name: $name")
    println("Age: $age")
}

// 2. Function with Named Arguments
fun display(name: String, course: String, semester: Int) {
    println("Name: $name")
    println("Course: $course")
    println("Semester: $semester")
}

// 3. Function with Vararg
fun printNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (num in numbers) {
        println(num)
    }
}

// 4. Higher-Order Function
fun calculate(numbers: List<Int>, operation: (Int) -> Int) {
    println("Result:")
    for (num in numbers) {
        println(operation(num))
    }
}

fun main() {

    // Default Parameters
    println("Default Parameters:")
    student()
    student("Rahul", 22)

    // Named Arguments
    println("\nNamed Arguments:")
    display(semester = 5, name = "Saumya", course = "B.Tech CSE")

    // Vararg
    println("\nVararg Function:")
    printNumbers(10, 20, 30, 40, 50)

    // Higher-Order Function
    println("\nHigher-Order Function:")
    val list = listOf(1, 2, 3, 4, 5)

    calculate(list) { it * it }
}