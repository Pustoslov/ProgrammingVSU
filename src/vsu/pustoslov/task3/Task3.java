package vsu.pustoslov.task3;

import vsu.pustoslov.commons.ConsoleReader;
import vsu.pustoslov.figures.Line;
import vsu.pustoslov.figures.Point;
import vsu.pustoslov.figures.Rectangle;

public class Task3 {
    private static final Line TOP_LINE = new Line(-5, -5, 0.6);
    private static final Line BOTTOM_LINE = new Line(7, 0, 1);
    private static final Rectangle RECTANGLE = new Rectangle(-3, -2, 6, 4);
    private static final Point[] POINTS_FOR_TEST = {
            new Point(1.5, -1.1),
            new Point(9, -9),
            new Point(3, 0),
            new Point(4, -2),
            new Point(0, -7),
            new Point(0, -2),
            new Point(4.5, 3.3)};

    public static void main(String[] args) {
        for (Point value : POINTS_FOR_TEST) {
            printColorForPoint(value);
        }

        final ConsoleReader consoleReader = new ConsoleReader();
        final double x = consoleReader.readDouble("Input X: ");
        final double y = consoleReader.readDouble("Input Y: ");
        final Point point = new Point(x, y);

        printColorForPoint(point);
    }

    private static SimpleColor getColor(Point point) {
        if (RECTANGLE.isPointInsideRectangle(point)) {
            return SimpleColor.ORANGE;
        }

        if (TOP_LINE.isPointAboveLine(point)) {
            return SimpleColor.YELLOW;
        }

        if (!BOTTOM_LINE.isPointAboveLine(point)) {
            return SimpleColor.GREEN;
        }

        return SimpleColor.WHITE;
    }

    private static void printColorForPoint(Point point) {
        System.out.printf("(%s , %s) -> %s\n", point.getX(), point.getY(), getColor(point));
    }
}
