package vsu.pustoslov.task10;

public class Tablet {
    private final String name;
    private final int memory;
    private final int rate;
    private final int price;

    public Tablet(String name, int memory, int rate, int price) {
        this.name = name;
        this.memory = memory;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getMemory() {
        return memory;
    }

    public int getRate() {
        return rate;
    }

    public int getPrice() {
        return price;
    }
}
