package vsu.pustoslov.task2;

import java.util.Scanner;

public class Task2Test {

    public static void main(String[] args) {
        double a = readDouble("A");
        double b = readDouble("B");
        double c = readDouble("C");
        double r = readRadius();
        prepareData(a, b, c, r);

    }

    private static double readDouble(String name) {
        System.out.printf("Side %s length = ", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static double readRadius() {
        System.out.print("Radius = ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static void prepareData(double a, double b, double c, double r) {
        /*double a1 = Math.min(Math.min(a, b), c);
        double b1 = Math.max(Math.max(a, b), c);
        double c1 = a + b + c - a1 - b1;
        a = a1;
        b = b1;
        c = c1;*/
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Triangle you are looking for doesn't exist, sorry");
        } else {
            checkPossibility(a, b, c, r);
        }
    }

    private static void checkPossibility(double x, double y, double z, double r) {
        if (countArea(x, y, z) == r * countHalfPerimeter(x, y, z)) {
            System.out.println("Yes, you can!");
        } else {
            System.out.println("No, you can't...");
        }

    }

    private static double countArea(double a, double b, double c) {
        return Math.sqrt(countHalfPerimeter(a, b, c) * (countHalfPerimeter(a, b, c) - a)
                * (countHalfPerimeter(a, b, c) - b) * (countHalfPerimeter(a, b, c) - c));
    }

    private static double countHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

}
