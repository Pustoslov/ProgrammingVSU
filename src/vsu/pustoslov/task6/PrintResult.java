package vsu.pustoslov.task6;

public class PrintResult {
    private final double sumOfRowN;
    private final double sumOfRowMoreThanE;
    private final double sumOfRowETen;

    public PrintResult(double sumOfRowN, double sumOfRowMoreThanE, double sumOfRowETen) {
        this.sumOfRowN = sumOfRowN;
        this.sumOfRowMoreThanE = sumOfRowMoreThanE;
        this.sumOfRowETen = sumOfRowETen;
    }

    public double getSumOfRowN() {
        return sumOfRowN;
    }

    public double sumOfRowMoreThanE() {
        return sumOfRowMoreThanE;
    }

    public double sumOfRowETen() {
        return sumOfRowETen;
    }
}
