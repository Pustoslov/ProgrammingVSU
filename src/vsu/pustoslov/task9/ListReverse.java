package vsu.pustoslov.task9;

import java.util.ArrayList;
import java.util.List;

public class ListReverse {
    public List<Integer> createNewList(List<Integer> introducedList) {
        final List<Integer> answerList = new ArrayList<>();
        for (int i = introducedList.size(); i > 0; i--) {
            int value = introducedList.get(i - 1);
            if (countOf(introducedList, value) % 2 == 0 && checkIsCurrentNumberInList(answerList, value)) {
                answerList.add(value);
            }
        }
        return answerList;
    }

    private static int countOf(List<Integer> storeTheNumberOfValues, int value) {
        int counterOfCurrentValue = 0;
        for (Integer list : storeTheNumberOfValues) {
            if (list == value) {
                counterOfCurrentValue++;
            }
        }
        return counterOfCurrentValue;
    }

    private static boolean checkIsCurrentNumberInList(List<Integer> answerList, int checkingValue) {
        int counter = 0;
        for (Integer valueOfAnswerList : answerList) {
            if (valueOfAnswerList == checkingValue) {
                counter++;
            }
        }
        return counter == 0;
    }
}
