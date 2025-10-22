
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;

public class FoodItem {
    
    public static final String[] ALLOWED = { "Burger", "Pizza", "Fries", "Sandwich", "Hotdog" };

    private String name;
    private double weightGrams;
    private LocalDate bestBefore;
    private LocalDateTime placedAt;
    
    /*
        Constructor that normalizes and validates:
        name;
        weight must be > 0;
        bestBefore must be within 0 up to 14 days, including "today"
    */
    public FoodItem(String name, double weightGrams, LocalDate bestBefore) {
        String normalized = normalizeName(name); 
        
        // Validate if name is valid, if not throw Exception
    if (!isAllowed(normalized)) {
        throw new IllegalArgumentException(
            "Invalid food name. Allowed: Burger, Pizza, Fries, Sandwich, Hotdog."
        );
    }

    // Validate if weight is valid, if not throw Exception
    if (weightGrams <= 0) {
        throw new IllegalArgumentException("Weight must be greater than 0 grams.");
    }
    
    /*
    Validate best-before:
    - cannot be before today;
    - cannot be more than 14 days ahead.
    */
    if (bestBefore == null) {
        throw new IllegalArgumentException("Best-before date is required.");
    }

    LocalDate today = LocalDate.now();
    long days = ChronoUnit.DAYS.between(today, bestBefore);
    if (days < 0 || days > 14) {
        throw new IllegalArgumentException("Best-before must be within 0..14 days from today.");
    }
    
    

        this.name = normalized;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.placedAt = LocalDateTime.now();
    }
    
    /*
        Trims the input;
        Returns an empty string if the input is null or blank;
        Ensures that the string has the first character uppercase and the rest lowercase.
    */
    private static String normalizeName(String nameInput) {
    if (nameInput == null) return "";
    nameInput = nameInput.trim();
    if (nameInput.isEmpty()) return "";
    String lower = nameInput.toLowerCase();
    return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
    
    /*
        Validates if the food name is in the allowed list;
        Returns true if the name is valid, otherwise false.
    */
    private static boolean isAllowed(String normalized) {
        for (String s : ALLOWED) {
            if (s.equals(normalized)) return true;
        }
        return false;
    }

 
}
