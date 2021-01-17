package vsu.pustoslov.task11;

public class RomanToArabic {
    public int romanToArabic(String inputString) {
        int result = 0;
        final RomanNumeral[] romanNumerals = RomanNumeral.reverseSortedValues();
        int i = 0;

        while (inputString.length() > 0 && i < romanNumerals.length) {
            final RomanNumeral currentSymbol = romanNumerals[i];

            if (inputString.startsWith(currentSymbol.name())) {
                result += currentSymbol.getValue();
                inputString = inputString.substring(currentSymbol.name().length());
            } else {
                i++;
            }
        }
        return result;
    }
}