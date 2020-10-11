package vsu.pustoslov.task2;

import vsu.pustoslov.commons.ConsoleReader;

public class Task2Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        double a = consoleReader.readDouble("Side A length = ");
        double b = consoleReader.readDouble("Side B length = ");
        double c = consoleReader.readDouble("Side C length = ");
        Triangle triangle = new Triangle(a, b, c);

        double r = consoleReader.readDouble("Radius R length = ");
        checkPossibilityRadius(triangle, r);
    }

    private static void checkPossibilityRadius(Triangle triangle, double r) {
        if (countAreaByGeron(triangle) == countAreaWithRadius(triangle, r)) {
            System.out.println("Yes, you can!");
        } else {
            System.out.println("No, you can't...");
        }
    }

    private static double countAreaByGeron(Triangle triangle) {
        double halfPerimeter = countHalfPerimeter(triangle);
        return Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getA())
                * (halfPerimeter - triangle.getB()) * (halfPerimeter - triangle.getC()));
    }

    private static double countAreaWithRadius(Triangle triangle, double r) {
        return r * countHalfPerimeter(triangle);
    }

    private static double countHalfPerimeter(Triangle triangle) {
        return (triangle.getA() + triangle.getB() + triangle.getC()) / 2;
    }
}