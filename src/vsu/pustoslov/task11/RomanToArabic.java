package vsu.pustoslov.task11;

public class RomanToArabic {
    public int romanToArabic(String inputString) {
        int result = 0;
        final RomanNumeral[] romanNumerals = RomanNumeral.reverseSortedValues();
        int i = 0;

        while (inputString.length() > 0 && i < romanNumerals.length) {
            final RomanNumeral symbol = romanNumerals[i];

            if (inputString.startsWith(symbol.name())) {
                result += symbol.getValue();
                inputString = inputString.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        return result;
    }
}