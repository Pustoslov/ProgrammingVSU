package vsu.pustoslov.task3;

public class Square {
    private final double leftCornerPointX0;
    private final double leftCornerPointY0;
    private final double lengthX;
    private final double widthY;

    public Square(double leftCornerPointX0, double leftCornerPointY0, double lengthX, double widthY) {
        this.leftCornerPointX0 = leftCornerPointX0;
        this.leftCornerPointY0 = leftCornerPointY0;
        this.lengthX = lengthX;
        this.widthY = widthY;
    }

    public boolean isPointInsideSquare(double x, double y) {
        return (x <= leftCornerPointX0 + lengthX) && (x >= leftCornerPointX0)
                && (y <= leftCornerPointY0 + widthY) && (y >= leftCornerPointY0);
    }
}
