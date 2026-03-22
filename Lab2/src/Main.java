public class Main {

    public static void main(String[] args) {

        HashTable table = new HashTable(10);

        Trapezoid t1 = new Trapezoid(3, 4, 5, 6);
        Trapezoid t2 = new Trapezoid(2, 3, 4, 5);
        Trapezoid t3 = new Trapezoid(6, 7, 8, 9);

        table.insert(t1);
        table.insert(t2);
        table.insert(t3);

        System.out.println("Before delete:");
        table.print();

        table.deleteByPerimeter(15, 25);

        System.out.println("\nAfter delete:");
        table.print();
    }
}