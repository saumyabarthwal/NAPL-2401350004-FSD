package main

import (
	"MyProject/mathutil"
	"MyProject/strop"
	"fmt"
)

func main() {

	var n int
	fmt.Print("Enter a number for factorial: ")
	fmt.Scan(&n)

	fmt.Println("Factorial:", mathutil.Factorial(n))

	var base, exponent int

	fmt.Print("Enter base: ")
	fmt.Scan(&base)

	fmt.Print("Enter exponent: ")
	fmt.Scan(&exponent)

	fmt.Println("Power:", mathutil.Power(base, exponent))

	var st string
	fmt.Print("Enter a string: ")
	fmt.Scan(&st)
	fmt.Println("No .of Vowels", strop.CountVowels(st))

	var s string
	fmt.Print("Enter a string: ")
	fmt.Scan(&s)
	fmt.Println("reverse ", strop.ReverseString(s))

}
