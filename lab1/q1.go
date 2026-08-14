package main

import "fmt"

func main() {
	var a, b float64
	var choice int

	fmt.Print("Enter a and b: ")
	fmt.Scan(&a, &b)

	fmt.Println("1. Integer")
	fmt.Println("2. Float")
	fmt.Println("3. Exit")

	fmt.Print("Enter your choice: ")
	fmt.Scan(&choice)

	switch choice {
	case 1:
		x := int(a)
		y := int(b)

		fmt.Println("Addition:", x+y)
		fmt.Println("Subtraction:", x-y)
		fmt.Println("Multiplication:", x*y)
		fmt.Println("Division:", x/y)

	case 2:
		fmt.Println("Addition:", a+b)
		fmt.Println("Subtraction:", a-b)
		fmt.Println("Multiplication:", a*b)
		fmt.Println("Division:", a/b)

	case 3:
		fmt.Println("Exit")

	default:
		fmt.Println("Invalid choice")
	}
}
