public class MathFunctions {
    public static double f1(double x) {
        return Math.exp(x) / Math.sqrt(1 + x * x + x);
    }

    public static double f2(double x) {
        return x * Math.exp(2 * x) - 4;
    }

    public static double df2(double x) {
        return Math.exp(2 * x) * (1 + 2 * x);
    }

    public static double f3(double x, double y) {
        return (1 - 2 * x) / (y * y);
    }
}