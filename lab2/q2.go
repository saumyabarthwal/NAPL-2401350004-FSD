package main

import (
	"fmt"
	"slices"
)

func main() {

	students := []string{"Saumya", "Rashi", "Manju"}
	fmt.Println("Original Slice:", students)

	students = append(students, "Parneet")
	fmt.Println("After Add operation:", students)

	students = slices.Delete(students, 1, 2)
	fmt.Println("After Remove:", students)

	students[1] = "Bhavii"
	fmt.Println("After Update:", students)

	marks := map[string]int{
		"Math":    100,
		"Science": 90,
		"English": 70,
		"hindi":   30,
	}
	fmt.Println("Original Map:", marks)
	marks["Computer"] = 95
	fmt.Println("After Insert:", marks)

	delete(marks, "Science")
	fmt.Println("After Delete:", marks)

	_, exists := marks["Science"]
	fmt.Println("Exists:", exists)

	fmt.Println("Map After Lookup:", marks)
}
