import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("\tКомбінації");
        int n1 = 15;
        int k1 = 3;
        long combinationsCount = factorial(n1) / (factorial(k1) * factorial(n1 - k1));
        System.out.println("Задача: Скільки команд з 3 студентів можна сформувати з 15 учасників?");
        System.out.print("Сполучення без повторень: ");
        System.out.println(combinationsCount);

        System.out.println("\n\tРозміщення");
        int n2 = 5;
        int k2 = 8;
        long arrangementsCount = (long) Math.pow(n2, k2);
        System.out.println("Задача: Скільки паролів з 8 букв можна скласти з 5 голосних, якщо вони повторюються?");
        System.out.println("Розміщення з повтореннями: ");
        System.out.println(arrangementsCount);


        System.out.println("\n\tЗапис комбінацій у файл");
        List<String> results = new ArrayList<>();
        int[] arr = new int[n1];
        for (int i = 0; i < n1; i++) arr[i] = i + 1;

        generateCombinations(arr, k1, 0, new int[k1], 0, results);

        String filename = "combinations.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String res : results) {
                writer.write(res);
                writer.newLine();
            }
            System.out.println("Успішно згенеровано і записано у файл " + filename + " " + results.size() + " комбінацій!");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    private static long factorial(int num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    private static void generateCombinations(int[] arr, int k, int startIdx, int[] currentCombo, int comboIdx, List<String> results) {
        if (comboIdx == k) {
            StringBuilder sb = new StringBuilder("Команда: [");
            for (int i = 0; i < k; i++) {
                sb.append(currentCombo[i]).append(i == k - 1 ? "" : ", ");
            }
            sb.append("]");
            results.add(sb.toString());
            return;
        }

        for (int i = startIdx; i < arr.length; i++) {
            currentCombo[comboIdx] = arr[i];
            generateCombinations(arr, k, i + 1, currentCombo, comboIdx + 1, results);
        }
    }
}