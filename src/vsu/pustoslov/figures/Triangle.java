package vsu.pustoslov.figures;

public class Triangle {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        if (checkPossibilityExist()) {
            throw new IllegalArgumentException("Triangle you are looking for doesn't exist, sorry");
        }
    }

    public double calculateHeight(double side) {
        return (2 / side) * calculateSqrt();
    }

    public double calculateHalfPerimeter() {
        return (sideA + sideB + sideC) / 2;
    }

    private boolean checkPossibilityExist() {
        return (sideA >= sideB + sideC || sideB >= sideA + sideC || sideC >= sideA + sideB);
    }

    private double calculateSqrt() {
        return Math.sqrt(calculateHalfPerimeter()
                * (calculateHalfPerimeter() - sideA)
                * (calculateHalfPerimeter() - sideB)
                * (calculateHalfPerimeter() - sideC));
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
