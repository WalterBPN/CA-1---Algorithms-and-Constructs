package storage;

import model.FoodItem;

/*
    Class that implements the Storage interface using a fixed-size array;
    It can simulate both LIFO (stack) and FIFO (queue) behaviors.
*/
public class DequeArrayStorage implements Storage {

    private final FoodItem[] data;  // array to store items
    private final int cap;          // maximum capacity
    private int front;              // index of the first element
    private int rear;               // index of the last element
    private int size;               // current number of elements
    private boolean lifoMode;       // true = LIFO, false = FIFO

    /*
        Constructor that initializes the storage with a fixed capacity.
        All indices start at -1 to indicate an empty structure.
    */
    public DequeArrayStorage(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        this.cap = capacity;
        this.data = new FoodItem[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.lifoMode = true; // default: LIFO
    }

    @Override
public boolean add(FoodItem item) {
    return false;
}

}
