package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;

/*
    Temporary test for add(): tries to insert 9 items into capacity 8.
    The 9th add should fail (return false).
*/
public class Main {
    public static void main(String[] args) {
        DequeArrayStorage storage = new DequeArrayStorage(8);

        for (int i = 1; i <= 9; i++) {
            boolean ok = storage.add(new FoodItem("Burger", 100 + i, LocalDate.now().plusDays(3)));
            System.out.println("Add #" + i + " -> " + (ok ? "OK" : "FULL"));
        }
        System.out.println("Done.");
    }
}
