public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Шевченко", "Тарас", "ІПЗ-21", "Київська", "Біла Церква"),
                new Student("Франко", "Іван", "ІПЗ-21", "Львівська", "Львів"),
                new Student("Косач", "Лариса", "ІПЗ-22", "Волинська", "Луцьк"),
                new Student("Стус", "Василь", "ІПЗ-22", "Вінницька", "Вінниця"),
                new Student("Симоненко", "Василь", "ІПЗ-21", "Полтавська", "Лубни"),
                new Student("Загребельний", "Павло", "ІПЗ-22", "Полтавська", "Кременчук"),
                new Student("Костенко", "Ліна", "ІПЗ-23", "Київська", "Київ")
        };

        System.out.println("Початковий масив");
        printArray(students);

        System.out.println("\nSelection sort");
        Student[] copy1 = students.clone();
        Sorter.selectionSort(copy1);
        printArray(copy1);

        System.out.println("\nIndex sort");
        int[] sortedIndices = Sorter.indexSort(students);
        for (int index : sortedIndices) {
            System.out.println(students[index]);
        }

        System.out.println("\nMerge sort");
        Student[] copy3 = students.clone();
        Sorter.mergeSort(copy3);
        printArray(copy3);
    }

    static void printArray(Student[] arr) {
        for (Student student : arr) {
            System.out.println(student);
        }
    }
}