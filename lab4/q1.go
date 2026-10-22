package main

import "fmt"

func square(n int, ch chan string) {
	fmt.Println("Square goroutine started")
	ch <- fmt.Sprintf("Square of %d: %d", n, n*n)
	fmt.Println("Square goroutine completed")
}

func cube(n int, ch chan string) {
	fmt.Println("Cube goroutine started")
	ch <- fmt.Sprintf("Cube of %d: %d", n, n*n*n)
	fmt.Println("Cube goroutine completed")
}

func fibonacci(n int, ch chan string) {
	fmt.Println("Fibonacci goroutine started")

	a, b := 0, 1
	result := ""

	for i := 0; i < n; i++ {
		result += fmt.Sprintf("%d ", a)
		a, b = b, a+b
	}

	ch <- fmt.Sprintf("Fibonacci series: %s", result)
	fmt.Println("Fibonacci goroutine completed")
}

func main() {
	var n int

	fmt.Print("Enter a number: ")
	fmt.Scan(&n)

	ch := make(chan string)

	go square(n, ch)
	go cube(n, ch)
	go fibonacci(n, ch)

	for i := 0; i < 3; i++ {
		fmt.Println(<-ch)
	}

	fmt.Println("All goroutines completed")
}
