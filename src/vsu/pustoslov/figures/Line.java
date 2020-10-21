package vsu.pustoslov.figures;

import vsu.pustoslov.task3.Point;

public class Line {
    private final double x0;
    private final double y0;
    private final double a;

    public Line(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointAboveLine(Point point) {
        return point.getY() >= a * (point.getX() - x0) + y0;
    }
}
