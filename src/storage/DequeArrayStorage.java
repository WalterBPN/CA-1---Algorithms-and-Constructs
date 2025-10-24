package storage;

import model.FoodItem;

/*
    Class that implements the Storage interface using a fixed-size array;
    It can simulate both LIFO and FIFO behaviors.
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
        this.lifoMode = true; // default
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
       - Otherwise moves rear forward in circular fashion;
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
    
    /*
        Returns the next item depending on the current mode:
        - LIFO: returns the item at rear;
        - FIFO: will return the item at front;
        Returns null if empty;
    */
    @Override
    public FoodItem peek() {
        if (isEmpty()) return null;
        return lifoMode ? data[rear] : data[front];
    }

    /*
        Removes and returns the next item according to the current mode
        - LIFO (true): removes from rear most recently added;
        - FIFO (false): removes from front the first added;
        Returns null if the storage is empty;
    */
    @Override
    public FoodItem remove() {
        if (isEmpty()) return null;

        FoodItem removed;

        if (lifoMode) {
            // LIFO: remove from rear
            removed = data[rear];
            data[rear] = null;

            if (size == 1) {
                front = rear = -1;
                size = 0;
                return removed;
            }

            rear = (rear - 1 + cap) % cap; // move rear back
            size--;
            return removed;

        } else {
            // FIFO: remove from front
            removed = data[front];
            data[front] = null;

            if (size == 1) {
                front = rear = -1;
                size = 0;
                return removed;
            }

            front = (front + 1) % cap; // move front forward
            size--;
            return removed;
        }
}
    
    /*
        Enables or disables LIFO mode.
    */
    @Override
        public void setModeLifo(boolean lifo) {
        this.lifoMode = lifo;
    }

    /*
        Returns the current mode
        true = LIFO
        false = FIFO
    */
    @Override
    public boolean isModeLifo() {
        return lifoMode;
    }
    
    /*
        Prints items from front to rear in logical order.
        
    */
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("[empty]");
            return;
        }
        System.out.print("Front -> ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % cap;
            FoodItem it = data[idx];
            System.out.print(it.getName());
            if (i < size - 1) System.out.print(" | ");
        }
        System.out.println(" <- Rear");
        System.out.println("(mode: " + (lifoMode ? "LIFO" : "FIFO") + ", size=" + size + "/" + cap + ")");
    }

    /*
        Linear search by name from FRONT to REAR;
        Returns index or -1 if not found.
    */
    @Override
    public int searchByName(String name) {
        if (name == null || isEmpty()) return -1;
        String needle = name.trim().toLowerCase();
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % cap;
            FoodItem it = data[idx];
            if (it != null && it.getName().toLowerCase().equals(needle)) {
                return i; // logical position from FRONT
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return cap;
    }


}
