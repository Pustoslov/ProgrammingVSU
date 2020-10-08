package vsu.pustoslov.task2;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (checkPossibilityExist(a, b, c)) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean checkPossibilityExist(double a, double b, double c) {
        return (a >= b + c || b >= a + c || c >= a + b);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
