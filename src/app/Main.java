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

        System.out.println("Size: " + storage.size());        // 3
        System.out.println("Capacity: " + storage.capacity()); // 8

        System.out.println("Search Pizza: " + storage.searchByName("Pizza")); // 1
        System.out.println("Search burger: " + storage.searchByName("burger")); // 0
        System.out.println("Search hotdog: " + storage.searchByName("hotdog")); // -1
    }
}
