package app;

import model.FoodItem;
import java.time.LocalDate;
import storage.DequeArrayStorage;


public class Main {
    public static void main(String[] args) {

        DequeArrayStorage storage = new DequeArrayStorage(8);
        System.out.println("It worked!");
    }
}
