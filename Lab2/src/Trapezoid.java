public class Trapezoid {

    private double a, b, c, d;

    public Trapezoid(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getArea() {
        return (a + b) / c;
    }

    public double getPerimeter() {
        return a + b + c + d;
    }

    public void print() {
        System.out.printf("Trapezoid: P=%.2f S=%.2f\n", getPerimeter(), getArea());
    }
}