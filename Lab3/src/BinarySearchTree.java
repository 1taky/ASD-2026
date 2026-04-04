import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;

    public void insert(Student student) {
        root = insertValue(root, student);
    }

    private Node insertValue(Node root, Student student) {
        if (root == null) return new Node(student);

        if (student.getStudentId() < root.data.getStudentId())
            root.left = insertValue(root.left, student);
        else if (student.getStudentId() > root.data.getStudentId())
            root.right = insertValue(root.right, student);

        return root;
    }

    public List<Student> traversalBreadth() {
        List<Student> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur.data);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return list;
    }

    public List<Student> search(int course, double minGrade, String citizenship) {
        List<Student> list = traversalBreadth();
        List<Student> result = new ArrayList<>();

        for (Student stud : list) {
            if (stud.getCourse() == course &&
                    stud.getAverageGrade() >= minGrade &&
                    stud.getCitizenship().equalsIgnoreCase(citizenship)) {
                result.add(stud);
            }
        }

        return result;
    }

    public void deleteBy(int course, double minGrade, String citizenship) {
        List<Student> toDelete = search(course, minGrade, citizenship);
        for (Student stud : toDelete) {
            root = deleteByKey(root, stud.getStudentId());
        }
    }

    private Node deleteByKey(Node root, long key) {
        if (root == null) return null;

        if (key < root.data.getStudentId()) {
            root.left = deleteByKey(root.left, key);
        } else if (key > root.data.getStudentId()) {
            root.right = deleteByKey(root.right, key);
        } else {
            if (root.left == null && root.right == null)
                return null;

            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            Node min = findMinValue(root.right);
            root.data = min.data;
            root.right = deleteByKey(root.right, min.data.getStudentId());
        }

        return root;
    }

    private Node findMinValue(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }
}