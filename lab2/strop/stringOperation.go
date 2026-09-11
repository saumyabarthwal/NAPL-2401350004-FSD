package strop

import "fmt"

func PrintStr(s string) {
	fmt.Println("String: ", s)
}
func CountVowels(st string) int {
	count := 0

	for _, ch := range st {
		if ch == 'a' || ch == 'e' || ch == 'i' ||
			ch == 'o' || ch == 'u' ||
			ch == 'A' || ch == 'E' || ch == 'I' ||
			ch == 'O' || ch == 'U' {
			count++
		}
	}

	return count
}

func ReverseString(s string) string {
	n := len(s)
	result := ""
	for i := n - 1; i >= 0; i-- {
		result += string(s[i])
	}
	return result
}
