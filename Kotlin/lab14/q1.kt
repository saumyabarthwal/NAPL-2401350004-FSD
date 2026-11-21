// Student Class
data class Student(
    val name: String,
    val percentage: Double
)

fun main() {

   
    println("----- LIST -----")

    val readOnlyList = listOf(10, 20, 30, 40)
    println("Read-only List: $readOnlyList")
    println("Contains 20: ${readOnlyList.contains(20)}")
    println("Get element: ${readOnlyList[0]}")

    val mutableList = mutableListOf(10, 20, 30, 40)
    mutableList.add(50)
    mutableList.remove(20)
    println("Mutable List: $mutableList")

    // Set
    println("\n----- SET -----")

    val readOnlySet = setOf(10, 20, 30, 40)
    println("Read-only Set: $readOnlySet")
    println("Contains 20: ${readOnlySet.contains(20)}")

    val mutableSet = mutableSetOf(10, 20, 30, 40)
    mutableSet.add(50)
    mutableSet.remove(20)
    println("Mutable Set: $mutableSet")

    // Map
    println("\n----- MAP -----")

    val readOnlyMap = mapOf(1 to "Saumya", 2 to "Rahul", 3 to "Manju")
    println("Read-only Map: $readOnlyMap")
    println("Get value: ${readOnlyMap[1]}")
    println("Contains key 2: ${readOnlyMap.containsKey(2)}")

    val mutableMap = mutableMapOf(1 to "Saumya", 2 to "Rahul")
    mutableMap[3] = "Manju"
    mutableMap.remove(2)
    println("Mutable Map: $mutableMap")

    // 2. Functional Transformations

    println("\n----- FUNCTIONAL TRANSFORMATIONS -----")

    val numbers = listOf(1, 2, 3, 4, 5)

    val mapped = numbers.map { it * 2 }
    println("Original List: $numbers")
    println("Map (Multiply by 2): $mapped")

    val filtered = numbers.filter { it > 2 }
    println("Filter (Greater than 2): $filtered")

    val reduced = numbers.reduce { a, b -> a + b }
    println("Reduce (Sum): $reduced")

    // 3. Sorting Objects and Grouping

    println("\n----- SORTING AND GROUPING -----")

    val students = listOf(
        Student("Saumya", 90.5),
        Student("Bhavii", 75.0),
        Student("Manju", 85.0),
        Student("Rashi", 95.0),
        Student("Parneet", 65.0)
    )

    val sortedStudents = students.sortedByDescending { it.percentage }

    println("Students Sorted by Percentage:")
    sortedStudents.forEach {
        println("${it.name} - ${it.percentage}%")
    }

    val groupedStudents = students.groupBy {
        if (it.percentage >= 80) "First Division" else "Second Division"
    }

    println("\nStudents Grouped by Division:")
    groupedStudents.forEach { (division, studentList) ->
        println("$division: ${studentList.map { it.name }}")
    }
}