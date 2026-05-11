package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int N = 100;

        int[] sizes = {N, N * N, N * N * N};

        double[] linearInsertTimes = new double[3];
        double[] quadraticInsertTimes = new double[3];

        System.out.println("\tТест методів вирішення колізій в хеш-таблиці\n");

        for (int index = 0; index < sizes.length; index++) {

            int size = sizes[index];

            System.out.println("РОЗМІР НАБОРУ ДАНИХ: " + size);

            int[] data = generateRandomArray(size);

            HashTableLinear linearTable =
                    new HashTableLinear(size * 2);

            long startInsertLinear = System.nanoTime();

            for (int value : data) {
                linearTable.insert(value);
            }

            long endInsertLinear = System.nanoTime();

            double linearInsertTime =
                    (endInsertLinear - startInsertLinear)
                            / 1_000_000.0;

            HashTableSquare quadraticTable =
                    new HashTableSquare(size * 2);

            long startInsertQuadratic = System.nanoTime();

            for (int value : data) {
                quadraticTable.insert(value);
            }

            long endInsertQuadratic = System.nanoTime();

            double quadraticInsertTime =
                    (endInsertQuadratic - startInsertQuadratic)
                            / 1_000_000.0;

            linearInsertTimes[index] = linearInsertTime;

            quadraticInsertTimes[index] = quadraticInsertTime;

            System.out.println("\nЛІНІЙНЕ ЗОНДУВАННЯ:");
            System.out.println("Час вставки: "
                    + linearInsertTime + " мс");

            System.out.println("\nКВАДРАТИЧНЕ ЗОНДУВАННЯ:");
            System.out.println("Час вставки: "
                    + quadraticInsertTime + " мс");
        }

        showChart(
                linearInsertTimes,
                quadraticInsertTimes
        );
    }

    public static int[] generateRandomArray(int size) {

        Random random = new Random();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = random.nextInt(1_000_000);
        }

        return array;
    }

    public static void showChart(
            double[] linear,
            double[] quadratic
    ) {

        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue(linear[0],
                "Лінійне зондування", "100");

        dataset.addValue(linear[1],
                "Лінійне зондування", "10 000");

        dataset.addValue(linear[2],
                "Лінійне зондування", "1 000 000");

        dataset.addValue(quadratic[0],
                "Квадратичне зондування", "100");

        dataset.addValue(quadratic[1],
                "Квадратичне зондування", "10 000");

        dataset.addValue(quadratic[2],
                "Квадратичне зондування", "1 000 000");

        JFreeChart chart =
                ChartFactory.createLineChart(
                        "Порівняння методів хешування",
                        "Розмір даних",
                        "Час вставки (мс)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

        ChartFrame frame =
                new ChartFrame("Графік", chart);

        frame.setSize(900, 600);

        frame.setVisible(true);
    }
}