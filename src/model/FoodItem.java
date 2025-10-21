
package model;

public class FoodItem {
    
    public static final String[] ALLOWED = { "Burger", "Pizza", "Fries", "Sandwich", "Hotdog" };

    private String name;
    private double weightGrams;
    
    //Constructor
    public FoodItem(String name, double weightGrams) {
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

        this.name = normalized;
        this.weightGrams = weightGrams;
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
