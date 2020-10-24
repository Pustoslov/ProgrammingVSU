package vsu.pustoslov.task1;

import vsu.pustoslov.commons.ConsoleReader;
import vsu.pustoslov.figures.Triangle;

public class Task1 {

    public static void main(String[] args) {
        final ConsoleReader consoleReader = new ConsoleReader();
        final double sideA = consoleReader.readDouble("Input side A: ");
        final double sideB = consoleReader.readDouble("Input side B: ");
        final double sideC = consoleReader.readDouble("Input side C: ");
        final Triangle triangle = new Triangle(sideA, sideB, sideC);
        System.out.printf("Для данного треугольника высоты равны H1 = %1$.2f H2 = %2$.2f H3 = %3$.2f\n",
                triangle.calculateHeight(triangle.getSideA()), triangle.calculateHeight(triangle.getSideB()), triangle.calculateHeight(triangle.getSideC()));
    }
}

