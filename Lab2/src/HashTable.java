public class HashTable {

    private Trapezoid[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Trapezoid[size];
    }

    private int hash(double key) {
        double A = 0.618;
        double frac = (key * A) % 1;
        return (int)(size * frac);
    }

    public boolean insert(Trapezoid t) {
        int index = hash(t.getArea());

        int startIndex = index;

        while (table[index] != null) {
            index = (index + 1) % size;

            if (index == startIndex) {
                return false; // таблиця повна
            }
        }

        table[index] = t;
        return true;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            if (table[i] != null) {
                table[i].print();
            } else {
                System.out.println("empty");
            }
        }
    }

    public void deleteByPerimeter(double min, double max) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                double p = table[i].getPerimeter();

                if (p >= min && p <= max) {
                    table[i] = null;
                }
            }
        }
    }
}