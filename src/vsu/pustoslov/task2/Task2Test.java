package vsu.pustoslov.task2;

import vsu.pustoslov.commons.ConsoleReader;

public class Task2Test {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        double a = consoleReader.readDouble("Side A length = ");
        double b = consoleReader.readDouble("Side B length = ");
        double c = consoleReader.readDouble("Side C length = ");
        double r = consoleReader.readDouble("Radius R length = ");
        try {
            Triangle triangle = new Triangle(a, b, c);
            checkPossibilityRadius(triangle.getA(), triangle.getB(), triangle.getC(), r);
        } catch (IllegalArgumentException e) {
            System.out.println("Triangle you are looking for doesn't exist, sorry");
        }
    }

    private static void checkPossibilityRadius(double a, double b, double c, double r) {
        if (countArea(a, b, c) == r * countHalfPerimeter(a, b, c)) {
            System.out.println("Yes, you can!");
        } else {
            System.out.println("No, you can't...");
        }
    }

    private static double countArea(double a, double b, double c) {
        double halfPerimeter = countHalfPerimeter(a, b, c);
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    private static double countHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }
}
