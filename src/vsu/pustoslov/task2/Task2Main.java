package vsu.pustoslov.task2;

import java.util.Scanner;

public class Task2Main {

    public static void main(String[] args) {
        double a = readDouble("Side A length = ");
        double b = readDouble("Side B length = ");
        double c = readDouble("Side C length = ");
        double r = readDouble("Radius R length = ");
        prepareData(a, b, c, r);
    }

    private static void prepareData(double a, double b, double c, double r) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Triangle you are looking for doesn't exist, sorry");
        } else {
            checkPossibility(a, b, c, r);
        }
    }

    private static void checkPossibility(double a, double b, double c, double r) {
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

    private static double readDouble(String name) {
        System.out.printf("%s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}