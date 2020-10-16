package vsu.pustoslov.task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        double a = readDouble("a");
        double b = readDouble("b");
        double c = readDouble("c");
        double h1 = calculateHeight(a, b, c);
        double h2 = calculateHeight(b, a, c);
        double h3 = calculateHeight(c, a, b);
        System.out.printf("Для данного треугольника высоты равны H1 = %1$.2f H2 = %2$.2f H3 = %3$.2f", h1, h2, h3);
    }

    private static double readDouble(String name) {
        System.out.printf("Длина стороны %s = ", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static double calculateHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    private static double calculateSqrt(double a, double b, double c) {
        return Math.sqrt(calculateHalfPerimeter(a, b, c)
                * (calculateHalfPerimeter(a, b, c) - a)
                * (calculateHalfPerimeter(a, b, c) - b)
                * (calculateHalfPerimeter(a, b, c) - c));
    }

    private static double calculateHeight(double a, double b, double c) {
        return (2 / a) * calculateSqrt(a, b, c);
    }

}

