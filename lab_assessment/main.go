package main

import (
	"errors"
	"fmt"
)

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

var items []Item

func addItem(item Item) error {
	if item.ID <= 0 || item.Name == "" || item.Quantity < 0 || item.Price < 0 {
		return errors.New("invalid item details")
	}

	for _, i := range items {
		if i.ID == item.ID {
			return errors.New("item already exists")
		}
	}

	items = append(items, item)
	return nil
}

func updateItem(id int, quantity int, price float64) error {
	if id <= 0 || quantity < 0 || price < 0 {
		return errors.New("invalid item details")
	}

	for i := range items {
		if items[i].ID == id {
			items[i].Quantity = quantity
			items[i].Price = price
			return nil
		}
	}

	return errors.New("item not found")
}

func removeItem(id int) error {
	for i, item := range items {
		if item.ID == id {
			items = append(items[:i], items[i+1:]...)
			return nil
		}
	}

	return errors.New("item not found")
}

func main() {
	err := addItem(Item{1, "Laptop", 2, 3450000})
	if err != nil {
		fmt.Println("Error adding item:", err)
	}

	err = addItem(Item{2, "HardDisk", 4, 50890})
	if err != nil {
		fmt.Println(err)
	}

	err = updateItem(1, 3, 30000)
	if err != nil {
		fmt.Println(err)
	}

	err = removeItem(2)
	if err != nil {
		fmt.Println(err)
	}

	fmt.Println("Inventory:", items)
}
