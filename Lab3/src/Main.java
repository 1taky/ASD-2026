import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        Student[] students = {
                new Student("Перший", 3, 15, 95, "Україна"),
                new Student("Другий", 2, 10, 82, "Україна"),
                new Student("Третій", 3, 25, 91, "Україна"),
                new Student("Четвертий", 1, 5, 70, "США"),
                new Student("Пʼятий", 3, 20, 88, "Швейцарія"),
                new Student("Шостий", 3, 30, 97, "Іспанія")
        };

        for (Student stud : students) tree.insert(stud);

        boolean exit = false;
        while (!exit) {

            System.out.println("\n\tМЕНЮ");
            System.out.println("1 — Прохід в ширину");
            System.out.println("2 — Пошук студентів");
            System.out.println("3 — Видалити студентів");
            System.out.println("4 — Вихід");
            System.out.print("Ваш вибір: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    print(tree.traversalBreadth());
                }
                case 2 -> {
                    Params params = inputCriteria();
                    List<Student> found = tree.search(params.course, params.grade, params.cit);
                    if (found.isEmpty()) System.out.println("Нічого не знайдено!");
                    else print(found);
                }
                case 3 -> {
                    Params p = inputCriteria();
                    tree.deleteBy(p.course, p.grade, p.cit);
                    System.out.println("Вузли видалено.");
                    print(tree.traversalBreadth());
                }
                case 4 -> {
                    exit = true;
                }
            }
        }
    }

    static class Params {
        int course;
        double grade;
        String cit;
    }

    static Params inputCriteria() {
        Params p = new Params();

        System.out.print("Введіть курс: ");
        p.course = sc.nextInt();

        System.out.print("Введіть мінімальний бал: ");
        p.grade = sc.nextDouble();
        sc.nextLine();

        System.out.print("Введіть громадянство: ");
        p.cit = sc.nextLine();

        return p;
    }

    static void print(List<Student> list) {
        System.out.println("ID        | Прізвище        | Курс | Бал   | Громадянство");
        for (Student s : list)
            System.out.println(s);
    }
}