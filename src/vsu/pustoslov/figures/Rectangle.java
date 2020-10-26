package vsu.pustoslov.figures;

public class Rectangle {
    private final double leftCornerPointX0;
    private final double leftCornerPointY0;
    private final double lengthX;
    private final double widthY;

    public Rectangle(double leftCornerPointX0, double leftCornerPointY0, double lengthX, double widthY) {
        this.leftCornerPointX0 = leftCornerPointX0;
        this.leftCornerPointY0 = leftCornerPointY0;
        this.lengthX = lengthX;
        this.widthY = widthY;
    }

    public boolean isPointInsideRectangle(Point point) {
        return (point.getX() >= leftCornerPointX0) && (point.getX() <= leftCornerPointX0 + lengthX)
                && (point.getY() >= leftCornerPointY0) && (point.getY() <= leftCornerPointY0 + widthY);
    }
}
