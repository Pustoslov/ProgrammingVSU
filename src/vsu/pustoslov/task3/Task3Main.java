package vsu.pustoslov.task3;

import vsu.pustoslov.commons.ConsoleReader;

public class Task3Main {

    public static void main(String[] args) {
        final Line topLine = new Line(-5, -5, 0.6);
        final Line bottomLine = new Line(7, 0, 1);
        Square square = new Square(-3, -2, 6, 4);

        System.out.printf("(%s , %s) -> %s\n", 1.5, -1.1, getColor(topLine, bottomLine, square, 1.5, -1.1));
        System.out.printf("(%s , %s) -> %s\n", 9, -9, getColor(topLine, bottomLine, square, 9, -9));
        System.out.printf("(%s , %s) -> %s\n", 3, 0, getColor(topLine, bottomLine, square, 3, 0));
        System.out.printf("(%s , %s) -> %s\n", 4, -2, getColor(topLine, bottomLine, square, 4, -2));
        System.out.printf("(%s , %s) -> %s\n", 0, -7, getColor(topLine, bottomLine, square, 0, -7));
        System.out.printf("(%s , %s) -> %s\n", 0, -2, getColor(topLine, bottomLine, square, 0, -2));
        System.out.printf("(%s , %s) -> %s\n", 1.5, -1.1, getColor(topLine, bottomLine, square, 1.5, -1.1));
        System.out.printf("(%s , %s) -> %s\n", 4.567, -3.33, getColor(topLine, bottomLine, square, 4.567, -3.33));

        ConsoleReader consoleReader = new ConsoleReader();
        double x = consoleReader.readDouble("Input X: ");
        double y = consoleReader.readDouble("Input Y: ");
        printColorForPoint(x, y, topLine, bottomLine, square);
    }

    private static SimpleColor getColor(Line topLine, Line bottomLine, Square square, double x, double y) {
        if (square.isPointInsideSquare(x, y)) {
            return SimpleColor.ORANGE;
        } else if (topLine.isPointAboveLine(x, y)) {
            return SimpleColor.YELLOW;
        } else if (!bottomLine.isPointAboveLine(x, y)) {
            return SimpleColor.GREEN;
        } else {
            return SimpleColor.WHITE;
        }
    }

    private static void printColorForPoint(double x, double y, Line topLine, Line bottomLine, Square square) {
        System.out.printf("(%s , %s) -> %s", x, y, getColor(topLine, bottomLine, square, x, y));
    }
}
