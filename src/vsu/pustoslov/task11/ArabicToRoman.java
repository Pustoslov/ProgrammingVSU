package vsu.pustoslov.task11;

public class ArabicToRoman {
    public String convertArabicToRoman(int arabicNumber) {
        final StringBuilder stringBuilder = new StringBuilder();
        final RomanNumeral[] romanNumerals = RomanNumeral.reverseSortedValues();
        int i = 0;

        while (arabicNumber > 0 && i < romanNumerals.length) {
            final RomanNumeral currentSymbol = romanNumerals[i];
            if (currentSymbol.getValue() <= arabicNumber) {
                stringBuilder.append(currentSymbol.name());
                arabicNumber -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }
}