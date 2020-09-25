package vsu.pustoslov.task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Длина стороны a = ");
        double a = scanner.nextDouble();
        System.out.println("Длина стороны b = ");
        double b = scanner.nextDouble();
        System.out.println("Длина стороны c = ");
        double c = scanner.nextDouble();
        double h1 = calculateHeight(a, b, c);
        double h2 = calculateHeight(b, a, c);
        double h3 = calculateHeight(c, a, b);
        System.out.printf
                ("Для данного треугольника высоты равны H1 = %1$.2f H2 = %2$.2f H3 = %3$.2f", h1, h2, h3);
    }

    public static double calculateHalfPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public static double calculateSqrt(double a, double b, double c) {
        return Math.sqrt(calculateHalfPerimeter(a, b, c)
                * (calculateHalfPerimeter(a, b, c) - a)
                * (calculateHalfPerimeter(a, b, c) - b)
                * (calculateHalfPerimeter(a, b, c) - c));
    }

    public static double calculateHeight(double a, double b, double c) {
        return (2 / a) * calculateSqrt(a, b, c);
    }

}

