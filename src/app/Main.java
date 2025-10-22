package app;

import model.FoodItem;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        FoodItem item = new FoodItem("Burger", 300, LocalDate.now().plusDays(3));
        System.out.println("Created: " + item);
    }
}
