package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        DequeArrayStorage storage = new DequeArrayStorage(8);


        storage.add(new FoodItem("Pizza", 250, LocalDate.now().plusDays(4)));
        storage.add(new FoodItem("Fries", 150, LocalDate.now().plusDays(2)));

        System.out.println("Lets try to remove Fries");
        var r1 = storage.remove();
        System.out.println("Removed: " + (r1 != null ? r1.getName() : "null"));

        System.out.println("Lets try to remove Pizza");
        var r2 = storage.remove();
        System.out.println("Removed: " + (r2 != null ? r2.getName() : "null"));
    }
}
