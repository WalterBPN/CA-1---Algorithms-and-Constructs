package app;

import storage.DequeArrayStorage;
import model.FoodItem;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final DequeArrayStorage storage = new DequeArrayStorage(8);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n Menu");
            System.out.println("1 - Add new FoodItem");
            System.out.println("2 - Remove next item");
            System.out.println("3 - Peek next item");
            System.out.println("4 - Display all items");
            System.out.println("5 - Search by name");
            System.out.println("6 - Toggle mode (LIFO or FIFO)");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> peekItem();
                case 4 -> storage.display();
                case 5 -> searchItem();
                case 6 -> toggleMode();
                case 0 -> System.out.println("Finishing...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    /*
        Adds a new FoodItem
    */
    private static void addItem() {
        try {
            System.out.print("Enter name (Burger, Pizza, Fries, Sandwich, Hotdog): ");
            String name = sc.nextLine();
            System.out.print("Enter weight in grams: ");
            double weight = sc.nextDouble();
            System.out.print("Enter best-before days (1-14): ");
            int days = sc.nextInt();
            sc.nextLine();

            boolean ok = storage.add(new FoodItem(name, weight, LocalDate.now().plusDays(days)));
            System.out.println(ok ? "Item added." : "Storage full!");
        } catch (Exception e) {
            System.out.println("Woops!️ " + e.getMessage());
            sc.nextLine();
        }
    }

    /*
        Removes an item and prints it.
    */
    private static void removeItem() {
        var item = storage.remove();
        if (item == null) System.out.println("Storage empty!");
        else System.out.println("Removed: " + item);
    }

    /*
        Shows the next item without removing it.
    */
    private static void peekItem() {
        var item = storage.peek();
        if (item == null) System.out.println("Storage empty :(");
        else System.out.println("Next: " + item);
    }

    /*
        Search an item by name.
    */
    private static void searchItem() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        int pos = storage.searchByName(name);
        System.out.println(pos >= 0 ? "Found at position " + pos : "Not found :(");
    }

    /*
        Switch between LIFO and FIFO
    */
    private static void toggleMode() {
        storage.setModeLifo(!storage.isModeLifo());
        System.out.println("Mode changed to: " + (storage.isModeLifo() ? "LIFO" : "FIFO"));
    }
}
