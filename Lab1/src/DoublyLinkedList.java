class DoublyLinkedList {
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
        }
    }

    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void remove(String data) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(data)) {

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                return;
            }
            temp = temp.next;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}