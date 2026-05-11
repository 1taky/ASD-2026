public class NumericalMethods {
    public static double rectangleMethod(double a, double b, double h) {
        double sum = 0;
        for (double x = a; x < b; x += h) {
            sum += MathFunctions.f1(x);
        }
        return sum * h;
    }

    public static double trapezoidalMethod(double a, double b, double h) {
        double sum = (MathFunctions.f1(a) + MathFunctions.f1(b)) / 2.0;
        for (double x = a + h; x < b; x += h) {
            sum += MathFunctions.f1(x);
        }
        return sum * h;
    }

    public static double simpsonMethod(double a, double b, double h) {
        int n = (int) Math.round((b - a) / h);
        if (n % 2 != 0) n++;
        h = (b - a) / n;

        double sum = MathFunctions.f1(a) + MathFunctions.f1(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 2 == 0) ? 2 * MathFunctions.f1(x) : 4 * MathFunctions.f1(x);
        }
        return sum * h / 3.0;
    }

    public static double bisectionMethod(double a, double b, double eps) {
        double c = a;
        while ((b - a) >= eps) {
            c = (a + b) / 2;
            if (MathFunctions.f2(c) == 0.0) break;
            else if (MathFunctions.f2(c) * MathFunctions.f2(a) < 0) b = c;
            else a = c;
        }
        return c;
    }

    public static double newtonMethod(double x0, double eps) {
        double x1 = x0 - MathFunctions.f2(x0) / MathFunctions.df2(x0);
        while (Math.abs(x1 - x0) >= eps) {
            x0 = x1;
            x1 = x0 - MathFunctions.f2(x0) / MathFunctions.df2(x0);
        }
        return x1;
    }

    public static double secantMethod(double a, double b, double eps) {
        double x0 = a;
        double x1 = b;
        double x2 = x1 - MathFunctions.f2(x1) * (x1 - x0) / (MathFunctions.f2(x1) - MathFunctions.f2(x0));
        while (Math.abs(x2 - x1) >= eps) {
            x0 = x1;
            x1 = x2;
            x2 = x1 - MathFunctions.f2(x1) * (x1 - x0) / (MathFunctions.f2(x1) - MathFunctions.f2(x0));
        }
        return x2;
    }

    public static void rungeKutta4(double x0, double y0, double xEnd, double h) {
        System.out.println(" x \t\t y");
        System.out.println("-------------------------");

        double x = x0;
        double y = y0;

        while (x <= xEnd + 1e-9) {
            System.out.printf("%.4f \t %.4f\n", x, y);

            double k1 = MathFunctions.f3(x, y);
            double k2 = MathFunctions.f3(x + h / 2.0, y + h * k1 / 2.0);
            double k3 = MathFunctions.f3(x + h / 2.0, y + h * k2 / 2.0);
            double k4 = MathFunctions.f3(x + h, y + h * k3);

            y = y + (h / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            x = x + h;
        }
    }
}