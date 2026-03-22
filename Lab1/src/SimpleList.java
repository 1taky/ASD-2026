class SimpleList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void moveEvenToQueue(ArrayQueue queue) {
        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                queue.enqueue(temp.data);
            }
            temp = temp.next;
        }
    }
}