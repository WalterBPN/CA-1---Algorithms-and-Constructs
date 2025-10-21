
package model;

public class FoodItem {
    
    public static final String[] ALLOWED = { "Burger", "Pizza", "Fries", "Sandwich", "Hotdog" };

    private String name;
    private double weightGrams;
    
    private static String normalizeName(String nameInputed) {
    if (nameInputed == null) return "";
    nameInputed = nameInputed.trim();
    if (nameInputed.isEmpty()) return "";
    String lower = nameInputed.toLowerCase();
    return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
 
}
