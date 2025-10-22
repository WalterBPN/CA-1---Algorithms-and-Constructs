package app;

import model.FoodItem;
import java.time.LocalDate;

/*
    Temporary test for FoodItem class;
    Validates name, weight, and best-before date logic using sample objects.
*/
public class Main {
    public static void main(String[] args) {

        System.out.println("FoodItem Quick Test\n");

        try {
            // valid item
            FoodItem valid = new FoodItem("pizza", 250, LocalDate.now().plusDays(5));
            System.out.println("Created: " + valid);

            // invalid name
            System.out.println("\nTesting invalid name...");
            FoodItem badName = new FoodItem("cake", 200, LocalDate.now().plusDays(3));

        } catch (IllegalArgumentException e) {
            System.out.println(" Exception: " + e.getMessage());
        }

        try {
            // intentional invalid best-before
            System.out.println("\nTesting invalid best-before...");
            FoodItem badDate = new FoodItem("Burger", 150, LocalDate.now().plusDays(20));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // invalid weight
            System.out.println("\nTesting invalid weight...");
            FoodItem badWeight = new FoodItem("Fries", 0, LocalDate.now().plusDays(2));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
