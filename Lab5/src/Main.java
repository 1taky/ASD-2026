public class Main {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Surname1", "Name1", 70, 1, "0671234567"),
                new Student("Surname2", "Name2", 84, 3, "0991233367"),
                new Student("Surname3", "Name3", 95, 2, "0939834567"),
                new Student("Surname4", "Name4", 72, 3, "0951234987"),
                new Student("Surname5", "Name5", 62, 4, "0731264357")
        };

        System.out.println("До сортування:");
        for (Student student : students)
            System.out.println(student);

        sort(students);

        System.out.println("\nПісля сортування:");
        for (Student student : students)
            System.out.println(student);

        double key = students[2].averageGrade;

        Student found = interpolationSearch(students, key);

        System.out.println("\nПошук:");
        System.out.println(found != null ? found : "Не знайдено");

        BST tree = new BST();

        for (Student student : students) {
            tree.root = tree.insert(tree.root, student);
        }

        System.out.println("\nBST (BFS):");
        tree.bfs();

        Student result = tree.search(tree.root, "Kyivstar");

        System.out.println("\nПошук в дереві:");
        System.out.println(result != null ? result : "Не знайдено");
    }

    static void sort(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].averageGrade > arr[j + 1].averageGrade) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static Student interpolationSearch(Student[] arr, double key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high &&
                key >= arr[low].averageGrade &&
                key <= arr[high].averageGrade) {

            if (low == high) {
                if (arr[low].averageGrade == key)
                    return arr[low];
                return null;
            }

            int pos = low + (int)((key - arr[low].averageGrade) * (high - low) /
                    (arr[high].averageGrade - arr[low].averageGrade));

            if (arr[pos].averageGrade == key)
                return arr[pos];

            if (arr[pos].averageGrade < key)
                low = pos + 1;
            else
                high = pos - 1;
        }

        return null;
    }
}