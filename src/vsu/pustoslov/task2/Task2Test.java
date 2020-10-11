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
            checkPossibilityRadius(triangle, r);
        } catch (IllegalArgumentException e) {
            System.out.println("Triangle you are looking for doesn't exist, sorry");
        }
    }

    private static void checkPossibilityRadius(Triangle triangle, double r) {
        if (countArea(triangle) == r * countHalfPerimeter(triangle)) {
            System.out.println("Yes, you can!");
        } else {
            System.out.println("No, you can't...");
        }
    }

    private static double countArea(Triangle triangle) {
        double halfPerimeter = countHalfPerimeter(triangle);
        return Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getA())
                * (halfPerimeter - triangle.getB()) * (halfPerimeter - triangle.getC()));
    }

    private static double countHalfPerimeter(Triangle triangle) {
        return (triangle.getA() + triangle.getB() + triangle.getC()) / 2;
    }
}
