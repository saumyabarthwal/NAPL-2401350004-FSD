package main

import "fmt"

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}

func (p Person) ReadData() Person {
	fmt.Print("Enter Name: ")
	fmt.Scan(&p.Name)

	fmt.Print("Enter Age: ")
	fmt.Scan(&p.Age)

	fmt.Print("Enter Job: ")
	fmt.Scan(&p.Job)

	fmt.Print("Enter Salary: ")
	fmt.Scan(&p.Salary)

	return p
}

func (p Person) DisplayData() {
	fmt.Println("Name   :", p.Name)
	fmt.Println("Age    :", p.Age)
	fmt.Println("Job    :", p.Job)
	fmt.Println("Salary :", p.Salary)
}

func main() {
	var person1 Person
	var person2 Person

	fmt.Println("Enter details for Person 1:")
	person1 = person1.ReadData()

	fmt.Println("\nEnter details for Person 2:")
	person2 = person2.ReadData()

	fmt.Println("\nPerson 1:")
	person1.DisplayData()

	fmt.Println("\nPerson 2:")
	person2.DisplayData()
}
