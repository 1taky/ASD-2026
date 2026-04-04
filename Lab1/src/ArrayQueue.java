class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        rear++;
        arr[rear] = value;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int value = arr[front];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        size--;

        return value;
    }

    public void print() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}