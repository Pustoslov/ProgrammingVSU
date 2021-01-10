package vsu.pustoslov.task10;

import java.util.List;

public class TabletChoice {
    public Tablet theBestTablet(List<Tablet> listOfTablets, int necessaryMemory, double necessaryRate) {
        double minPrice = Double.MAX_VALUE;
        Tablet bestTablet = null;
        for (Tablet currentTablet : listOfTablets) {
            if (currentTablet.getMemory() >= necessaryMemory
                    && currentTablet.getRate() >= necessaryRate) {
                if (currentTablet.getPrice() <= minPrice) {
                    minPrice = currentTablet.getPrice();
                    bestTablet = currentTablet;
                }
            }
        }
        return bestTablet;
    }
}
