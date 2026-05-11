import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("     ДОМАШНЯ РОБОТА");

        System.out.println("\tВирішення СЛАР (LUP-розкладання)");
        int n = 3;
        double[][] A = new double[n][n];
        double[] b = new double[n];

        double[][] defaultA = {{1, 2, 4}, {5, 1, 2}, {3, -1, 1}};
        double[] defaultB = {31, 29, 10};

        System.out.println("Бажаєте ввести коефіцієнти вручну? (1 - Так, 0 - Ні, використати стандартні Вар.6):");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Введіть матрицю A (3x3) та вектор b (3 елементи) підряд:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) A[i][j] = scanner.nextDouble();
                b[i] = scanner.nextDouble();
            }
        } else {
            A = defaultA;
            b = defaultB;
        }

        System.out.println("\nПочаткова матриця A:");
        LupSolver.printMatrix(A);

        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        int[] P = new int[n];

        LupSolver.lupDecompose(A, L, U, P, n);

        System.out.println("\nМатриця L:");
        LupSolver.printMatrix(L);
        System.out.println("\nМатриця U:");
        LupSolver.printMatrix(U);

        System.out.println("\nМатриця перестановки P: ");
        for (int p : P) System.out.print(p + " ");
        System.out.println("\n");

        double[] x = LupSolver.lupSolve(L, U, P, b, n);

        System.out.println("Розв'язок СЛАР:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", i + 1, x[i]);
        }

        System.out.println("\tДиф. рівняння (Рунге-Кутта 4)");

        System.out.print("Введіть початковий час (x0): ");
        double x0 = scanner.nextDouble();
        System.out.print("Введіть початкову позицію (y0): ");
        double y0 = scanner.nextDouble();
        System.out.print("Введіть початкову швидкість (v0): ");
        double v0 = scanner.nextDouble();
        System.out.print("Введіть кінцевий час (xEnd): ");
        double xEnd = scanner.nextDouble();
        System.out.print("Введіть крок (h): ");
        double h = scanner.nextDouble();
        System.out.println();

        OdeSolver.rungeKutta4(x0, y0, v0, xEnd, h);

        scanner.close();
    }
}