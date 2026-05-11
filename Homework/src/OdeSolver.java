public class OdeSolver {

    public static void rungeKutta4(double x0, double y0, double v0, double xEnd, double h) {
        System.out.println(" x \t\t y \t\t v ");
        System.out.println("--------------------------------------------------");

        double x = x0;
        double y = y0;
        double v = v0;

        while (x <= xEnd + 1e-9) {
            System.out.printf("%8.4f \t %8.4f \t %8.4f\n", x, y, v);

            double k1 = h * MathEquations.f1(x, y, v);
            double q1 = h * MathEquations.f2(x, y, v);

            double k2 = h * MathEquations.f1(x + h/2, y + k1/2, v + q1/2);
            double q2 = h * MathEquations.f2(x + h/2, y + k1/2, v + q1/2);

            double k3 = h * MathEquations.f1(x + h/2, y + k2/2, v + q2/2);
            double q3 = h * MathEquations.f2(x + h/2, y + k2/2, v + q2/2);

            double k4 = h * MathEquations.f1(x + h, y + k3, v + q3);
            double q4 = h * MathEquations.f2(x + h, y + k3, v + q3);

            y = y + (k1 + 2*k2 + 2*k3 + k4) / 6.0;
            v = v + (q1 + 2*q2 + 2*q3 + q4) / 6.0;
            x = x + h;
        }
    }
}