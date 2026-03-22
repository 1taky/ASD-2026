public class Main {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();

        queue.dequeue();
        queue.print();



        DoublyLinkedList list = new DoublyLinkedList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.print();

        list.remove("two");
        list.print();



        SimpleList intList = new SimpleList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        ArrayQueue evenQueue = new ArrayQueue(10);

        intList.moveEvenToQueue(evenQueue);

        System.out.println("List:");
        intList.print();

        System.out.println("Even Queue:");
        evenQueue.print();
    }
}