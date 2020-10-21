package vsu.pustoslov.task2;

import vsu.pustoslov.commons.ConsoleReader;
import vsu.pustoslov.figures.Triangle;

public class Task2 {

    public static void main(String[] args) {
        final ConsoleReader consoleReader = new ConsoleReader();
        final double sideA = consoleReader.readDouble("Side A length = ");
        final double sideB = consoleReader.readDouble("Side B length = ");
        final double sideC = consoleReader.readDouble("Side C length = ");
        final double radius = consoleReader.readDouble("Radius R length = ");
        final Triangle triangle = new Triangle(sideA, sideB, sideC);

        checkPossibilityRadius(triangle, radius);
    }

    private static void checkPossibilityRadius(Triangle triangle, double radius) {
        if (countAreaByGeron(triangle) == countAreaWithRadius(triangle, radius)) {
            System.out.println("Yes, you can!");
        } else {
            System.out.println("No, you can't...");
        }
    }

    private static double countAreaByGeron(Triangle triangle) {
        double halfPerimeter = triangle.calculateHalfPerimeter();
        return Math.sqrt(halfPerimeter * (halfPerimeter - triangle.getSideA())
                * (halfPerimeter - triangle.getSideB()) * (halfPerimeter - triangle.getSideC()));
    }

    private static double countAreaWithRadius(Triangle triangle, double radius) {
        return radius * triangle.calculateHalfPerimeter();
    }
}