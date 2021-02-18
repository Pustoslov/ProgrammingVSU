package vsu.pustoslov.task11;

import vsu.pustoslov.commons.ConsoleReader;

public class ConvertNumeral {
    public void convertInputString() {
        final ConsoleReader consoleReader = new ConsoleReader();
        String restartFlag = "1";

        do {
            String inputString = consoleReader.readString("Input number pls: ");
            inputString = inputString.replaceAll("(^\\s*)|(^\\t*)", "");
            inputString = inputString.toUpperCase();

            if (inputString.length() == 0) {
                System.out.println("\nEnter something please ");
                continue;
            }

            if (inputString.matches("(\\d+)|([\\-]?\\d+)")) {
                final ArabicToRoman arabicToRoman = new ArabicToRoman();
                final int inputIntNumber = Integer.parseInt(inputString);

                if (inputIntNumber <= 0 || inputIntNumber >= 4000) {
                    System.out.println("Please enter int number integer range (0; 4000)");
                    continue;
                }

                System.out.println(arabicToRoman.convertArabicToRoman(inputIntNumber));
            } else if (isInputRomanNumerals(inputString)) {
                final RomanToArabic romanToArabic = new RomanToArabic();
                System.out.println(romanToArabic.romanToArabic(inputString));
            } else {
                System.out.println("Enter correct arabic or roman number without spaces please");
                continue;
            }

            restartFlag = consoleReader.readString("If you want to restart enter 1. ");
        } while (restartFlag.matches("[1]"));
    }

    private static boolean isInputRomanNumerals(String inputString) {
        if (inputString.matches("([I]|[V]|[X]|[L]|[C]|[D]|[M]){4,}")) {
            return false;
        }

        char[] inputCharArray = inputString.toCharArray();
        boolean flag = false;

        for (char currentCharValue : inputCharArray) {
            if (currentCharValue == 'I' || currentCharValue == 'V' || currentCharValue == 'X'
                    || currentCharValue == 'L' || currentCharValue == 'C' || currentCharValue == 'D'
                    || currentCharValue == 'M') {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
