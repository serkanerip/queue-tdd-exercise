package queue;

// Queue is a fixed size (3) integer queue
// Can enqueue
// Can dequeue
// Can check is full
// Can check is empty
// Can peek(get next without remove it)

public class Queue {
    private int tailPtr = -1;
    private final int[] items = new int[3];
    private int headPtr = -1;

    public void enqueue(int number) {
        if (headPtr == -1) {
            headPtr++;
        }
        if (isFull()) {
            throw new Overflow();
        }
        items[++tailPtr] = number;
    }

    public boolean isFull() {
        return tailPtr == items.length - 1;
    }

    public boolean isEmpty() {
        return tailPtr == -1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new Underflow();
        }
        return items[headPtr];
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new Underflow();
        }
        tailPtr--;
        return items[headPtr++];
    }
}
