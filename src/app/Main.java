package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;

/*
    Quick test for display():
    - Add three items and print current order (front -> rear).
*/
public class Main {
    public static void main(String[] args) {
        DequeArrayStorage storage = new DequeArrayStorage(8);

        storage.add(new FoodItem("Burger", 200, LocalDate.now().plusDays(3)));
        storage.add(new FoodItem("Pizza", 250, LocalDate.now().plusDays(4)));
        storage.add(new FoodItem("Fries", 150, LocalDate.now().plusDays(2)));

        storage.display(); 

        storage.setModeLifo(false); // switch to FIFO
        System.out.println("Peek: " + storage.peek().getName()); 
        storage.display();
    }
}
