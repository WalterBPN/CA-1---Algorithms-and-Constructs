package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        DequeArrayStorage storage = new DequeArrayStorage(8);

        storage.add(new FoodItem("Burger", 200, LocalDate.now().plusDays(3)));
        storage.add(new FoodItem("Pizza", 250, LocalDate.now().plusDays(4)));
        storage.add(new FoodItem("Fries", 150, LocalDate.now().plusDays(2)));

        storage.setModeLifo(false); // switching to FIFO

        System.out.println("Mode LIFO: " + storage.isModeLifo());
        System.out.println("Trying to peek Burger");
        var p = storage.peek();
        System.out.println("Peeked item: " + (p != null ? p.getName() : "null"));
    }
}
