
package main

import "testing"

func TestAddItem(t *testing.T) {
	items = nil

	err := addItem(Item{1, "Laptop", 2, 30000})
	if err != nil {
		t.Error("Failed to add item:", err)
	}

	if len(items) != 1 {
		t.Error("Item was not added")
	}
}

func TestDuplicateItem(t *testing.T) {
	items = nil

	addItem(Item{1, "Laptop", 2, 30000})
	err := addItem(Item{1, "Mouse", 5, 500})

	if err == nil {
		t.Error("Duplicate item should not be allowed")
	}
}

func TestUpdateItem(t *testing.T) {
	items = nil
	addItem(Item{1, "Laptop", 2, 30000})

	err := updateItem(1, 3, 25000)
	if err != nil {
		t.Error("Failed to update item:", err)
	}

	if items[0].Quantity != 3 {
		t.Error("Quantity was not updated")
	}

	if items[0].Price != 25000 {
		t.Error("Price was not updated")
	}
}

func TestRemoveItem(t *testing.T) {
	items = nil
	addItem(Item{1, "Laptop", 2, 30000})

	err := removeItem(1)
	if err != nil {
		t.Error("Failed to remove item:", err)
	}

	if len(items) != 0 {
		t.Error("Item was not removed")
	}
}
