package storage;

import model.FoodItem;

/*
    Interface that defines the operations for a storage unit.
    It will support both LIFO and FIFO behaviors.
*/
public interface Storage {

    /*
        Adds a FoodItem to the storage;
        Returns true if the item was added successfully,
        or false if the storage is already full.
    */
    boolean add(FoodItem item);
    
    /*
        Returns the next item to be removed without deleting it;
        Returns null if the storage is empty.
    */
    FoodItem peek();
    
    /*
        Removes and returns the next item ***depends on current mode***
        Returns null if the storage is empty.
    */
    FoodItem remove();
    
    /*
        Sets the operating mode
        - true = LIFO
        - false = FIFO
    */
    void setModeLifo(boolean lifo);

    /*
        Returns true if LIFO mode is active, false if FIFO.
    */
    boolean isModeLifo();
    
    /*
    Prints all items from front to rear in logical order.
    */
    void display();



}