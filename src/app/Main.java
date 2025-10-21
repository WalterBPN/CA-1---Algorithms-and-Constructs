
package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to CCT Fast Food - The best in town!!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Add item");
            System.out.println("2) Remove item");
            System.out.println("3) Peek top/front");
            System.out.println("4) Display all");
            System.out.println("5) Toggle mode (LIFO/FIFO)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            
            String opt = input.nextLine().trim();
            switch (opt) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.println("It works :D ");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        System.out.println("Goodbye!");
        input.close();
    }
}
