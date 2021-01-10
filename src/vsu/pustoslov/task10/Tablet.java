package vsu.pustoslov.task10;

public class Tablet {
    private final String name;
    private final int memory;
    private final double rate;
    private final double price;

    public Tablet(String name, int memory, double rate, double price) {
        this.name = name;
        this.memory = memory;
        this.rate = rate;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + memory + ", " + rate + ", " + price;
    }

    public String getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }

    public double getRate() {
        return rate;
    }

    public double getPrice() {
        return price;
    }
}
