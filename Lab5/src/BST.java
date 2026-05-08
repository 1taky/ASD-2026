import java.util.*;

class BST {
    Node root;
    Random rand = new Random();

    Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    Node insert(Node root, Student data) {
        if (root == null)
            return new Node(data);

        if (rand.nextBoolean()) {
            root = insertRoot(root, data);
        } else {
            if (data.getOperator().compareTo(root.data.getOperator()) < 0)
                root.left = insert(root.left, data);
            else
                root.right = insert(root.right, data);
        }

        return root;
    }

    Node insertRoot(Node root, Student data) {
        if (root == null)
            return new Node(data);

        if (data.getOperator().compareTo(root.data.getOperator()) < 0) {
            root.left = insertRoot(root.left, data);
            return rotateRight(root);
        } else {
            root.right = insertRoot(root.right, data);
            return rotateLeft(root);
        }
    }

    Student search(Node root, String key) {
        if (root == null)
            return null;

        if (root.data.getOperator().equals(key))
            return root.data;

        if (key.compareTo(root.data.getOperator()) < 0)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    void bfs() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }
}