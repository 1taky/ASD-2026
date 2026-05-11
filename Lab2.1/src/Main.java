import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tЗАВДАННЯ 1: Числове інтегрування");
        System.out.print("Введіть початок інтервалу a (за замовчуванням 1): ");
        double a = scanner.nextDouble();
        System.out.print("Введіть кінець інтервалу b (за замовчуванням 2): ");
        double b = scanner.nextDouble();
        System.out.print("Введіть крок h (за замовчуванням 0.2): ");
        double h = scanner.nextDouble();

        System.out.printf("Метод лівих прямокутників: %.5f\n", NumericalMethods.rectangleMethod(a, b, h));
        System.out.printf("Метод трапецій: %.5f\n", NumericalMethods.trapezoidalMethod(a, b, h));
        System.out.printf("Метод Сімпсона: %.5f\n", NumericalMethods.simpsonMethod(a, b, h));


        System.out.println("\n\tЗАВДАННЯ 2: Корені алгебричного рівняння");
        System.out.print("Введіть ліву межу для пошуку кореня (наприклад, 0): ");
        double a2 = scanner.nextDouble();
        System.out.print("Введіть праву межу для пошуку кореня (наприклад, 2): ");
        double b2 = scanner.nextDouble();
        double eps = 0.0001;

        if (MathFunctions.f2(a2) * MathFunctions.f2(b2) > 0) {
            System.out.println("Помилка: На цьому інтервалі коренів може не бути (функція не змінює знак).");
        } else {
            System.out.printf("Метод дихотомії (полов. ділення): %.5f\n", NumericalMethods.bisectionMethod(a2, b2, eps));
            System.out.printf("Метод дотичних (Ньютона): %.5f\n", NumericalMethods.newtonMethod(b2, eps));
            System.out.printf("Метод хорд: %.5f\n", NumericalMethods.secantMethod(a2, b2, eps));
        }


        System.out.println("\n\tЗАВДАННЯ 3: Метод Рунге-Кутта 4-го порядку");
        System.out.print("Введіть початкове x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Введіть початкове y0: ");
        double y0 = scanner.nextDouble();
        System.out.print("Введіть кінцеве x_end: ");
        double xEnd = scanner.nextDouble();
        System.out.print("Введіть крок h: ");
        double h3 = scanner.nextDouble();

        NumericalMethods.rungeKutta4(x0, y0, xEnd, h3);

        scanner.close();
    }
}