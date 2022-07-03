package part2.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    int add(String text) {

        if (isBlank(text)) {
            return 0;
        }

        String delimiter = getDelimiter(text);
        String newText = getNewText(text);

        int[] numbers = getNumbers(newText, delimiter);

        int resultNumber = sumNumbers(numbers);
        System.out.println("result: " + resultNumber);

        return resultNumber;
    }

    private int sumNumbers(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private void isPositive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private int[] getNumbers(String text, String delimiter) {
        return getPositiveInts(getSplitStrings(text, delimiter));
    }

    private int[] getPositiveInts(String[] splitStrings) {
        int[] numbers = new int[splitStrings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(splitStrings[i]);
            isPositive(numbers[i]);
        }
        return numbers;
    }

    private String[] getSplitStrings(String text, String delimiter) {
        return text.split(delimiter);
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty() || " ".equals(text);
    }

    private String getDelimiter(String text) {
        Matcher m = getMatcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return  ",|:";
    }

    private String getNewText(String text) {
        Matcher m = getMatcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }

    private Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

}
