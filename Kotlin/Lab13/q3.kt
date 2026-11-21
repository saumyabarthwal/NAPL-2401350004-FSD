class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    // Function to accept student details
    fun acceptData() {
        print("Enter Roll Number: ")
        rollNo = readln().toInt()

        print("Enter Name: ")
        name = readln()

        print("Enter Course: ")
        course = readln()

        print("Enter Percentage: ")
        percentage = readln().toDouble()
    }

    // Function to display student details
    fun displayDetails() {
        println("\n----- Student Details -----")
        println("Roll Number: $rollNo")
        println("Name: $name")
        println("Course: $course")
        println("Percentage: $percentage%")
    }
}

fun main() {

    // Creating first Student object
    val s1 = Student(0, "", "", 0.0)

    println("Enter First Student Details:")
    s1.acceptData()
    s1.displayDetails()

    // Creating second Student object
    val s2 = Student(0, "", "", 0.0)

    println("\nEnter Second Student Details:")
    s2.acceptData()
    s2.displayDetails()
}