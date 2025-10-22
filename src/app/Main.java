package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;

/*
    Temporary test for peek() in LIFO mode:
    - Adds three items and expects peek to show the last one added.
*/
public class Main {
    public static void main(String[] args) {
        DequeArrayStorage storage = new DequeArrayStorage(8);

        storage.add(new FoodItem("Burger", 200, LocalDate.now().plusDays(3)));
        storage.add(new FoodItem("Pizza", 250, LocalDate.now().plusDays(4)));
        storage.add(new FoodItem("Fries", 150, LocalDate.now().plusDays(2)));

        System.out.println("Expecting: Fries");
        System.out.println("Peek -> " + (storage.peek() != null ? storage.peek().getName() : "null"));
    }
}
