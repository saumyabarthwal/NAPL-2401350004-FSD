package main

import "fmt"

//create a function to modify varaibale using pointer
func modifyValue(a *int) {
	*a = *a + 5
}

func modifyStructure(s *Student) {
	fmt.Println("Enter new student details:")
	fmt.Print("Enter new name: ")
	fmt.Scan(&s.Name)

	fmt.Print("Enter new age: ")
	fmt.Scan(&s.Age)

	fmt.Print("Enter new marks: ")
	fmt.Scan(&s.Marks)

}

type Student struct {
	Name  string
	Age   int
	Marks float64
}

func main() {
	//Part 1
	x := 10
	p := &x
	fmt.Println("Value of x:", x)
	fmt.Println("Address of x:", p)
	fmt.Println("Value using *p:", *p)

	//Part 2cd
	fmt.Println("Before modification:", x)

	modifyValue(p)

	fmt.Println("After modification:", x)

	//part3

	student := new(Student)

	fmt.Println("Student details before modification:")
	fmt.Println("Name:", student.Name)
	fmt.Println("Age:", student.Age)
	fmt.Println("Marks:", student.Marks)

	// Modify structure using pointer

	modifyStructure(student)

	fmt.Println("Student details after modification:")
	fmt.Println("Name:", student.Name)
	fmt.Println("Age:", student.Age)
	fmt.Println("Marks:", student.Marks)

}
