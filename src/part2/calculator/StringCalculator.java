package part2.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    int add(String text) {

        int result = 0;
        String delimiter = ",|:";

        if (text == null || text.isEmpty() || " ".equals(text)) {
            return result;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
            text = text.substring(text.indexOf("\n")+1);
        }

        String[] splitText = text.split(delimiter);

        for (String s : splitText) {
            int parseInt = Integer.parseInt(s);
            if (parseInt < 0) {
                throw new RuntimeException();
            }
            result = result + parseInt;
        }
        System.out.println("result: " + result);
        return result;
    }

}
