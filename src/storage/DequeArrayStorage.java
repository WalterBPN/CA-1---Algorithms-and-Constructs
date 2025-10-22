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
    
    /*
        Returns true when there are no items stored.
    */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
        Returns true when size reached capacity.
    */
    public boolean isFull() {
        return size == cap;
}


    /*
       Adds an item at the rear end of the deque;
       - If empty, initializes front=rear=0;
       - Otherwise, moves rear forward in circular fashion;
       Returns false if storage is already full.
    */
    @Override
    public boolean add(FoodItem item) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = rear = 0;
            data[rear] = item;
            size = 1;
            return true;
        }

        rear = (rear + 1) % cap;   // circular increment
        data[rear] = item;
        size++;
        return true;
}

}
