package main

import "testing"

func TestDivide(t *testing.T) {
	result, err := divide(10, 2)
	if err != nil || result != 5 {
		t.Error("Expected 5, got", result, err)
	}

	_, err = divide(10, 0)
	if err == nil {
		t.Error("Expected division by zero error")
	}
}

func TestSquareRoot(t *testing.T) {
	result, err := squareRoot(25)
	if err != nil || result != 5 {
		t.Error("Expected 5, got", result, err)
	}

	_, err = squareRoot(-4)
	if err == nil {
		t.Error("Expected negative square root error")
	}
}

func TestCheckInput(t *testing.T) {
	result, err := checkInput("Hello")
	if err != nil || result != "Hello" {
		t.Error("Expected Hello, got", result, err)
	}

	_, err = checkInput("")
	if err == nil {
		t.Error("Expected empty input error")
	}

	_, err = checkInput("   ")
	if err == nil {
		t.Error("Expected whitespace input error")
	}
}
