package storage;

import model.FoodItem;

/*
    Interface that defines the operations for a storage unit.
    It will support both LIFO (stack) and FIFO (queue) behaviors.
*/
public interface Storage {

    /*
        Adds a FoodItem to the storage;
        Returns true if the item was added successfully,
        or false if the storage is already full.
    */
    boolean add(FoodItem item);
}