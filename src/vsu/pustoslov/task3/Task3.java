package vsu.pustoslov.task3;

import vsu.pustoslov.commons.ConsoleReader;
import vsu.pustoslov.figures.Line;
import vsu.pustoslov.figures.Rectangle;

public class Task3 {
    private static final Line TOP_LINE = new Line(-5, -5, 0.6);
    private static final Line BOTTOM_LINE = new Line(7, 0, 1);
    private static final Rectangle RECTANGLE = new Rectangle(-3, -2, 6, 4);

    public static void main(String[] args) {
        printColorForPoint(1.5, -1.1);
        printColorForPoint(9, -9);
        printColorForPoint(3, 0);
        printColorForPoint(4, -2);
        printColorForPoint(0, -7);
        printColorForPoint(0, -2);
        printColorForPoint(4.567, -3.33);

        final ConsoleReader consoleReader = new ConsoleReader();
        final double x = consoleReader.readDouble("Input X: ");
        final double y = consoleReader.readDouble("Input Y: ");

        printColorForPoint(x, y);
    }

    private static SimpleColor getColor(double x, double y) {
        if (RECTANGLE.isPointInsideRectangle(x, y)) {
            return SimpleColor.ORANGE;
        }

        if (TOP_LINE.isPointAboveLine(x, y)) {
            return SimpleColor.YELLOW;
        }

        if (!BOTTOM_LINE.isPointAboveLine(x, y)) {
            return SimpleColor.GREEN;
        }

        return SimpleColor.WHITE;
    }

    private static void printColorForPoint(double x, double y) {
        System.out.printf("(%s , %s) -> %s\n", x, y, getColor(x, y));
    }
}
