package calculator;

import java.util.regex.Pattern;

public class InputParser {
    public static String[] parse(String text) {
        text = text.replaceAll("\\s", "");
        boolean isCustomDelimiter = Validator.isCustomDelimiter(text);

        if (isCustomDelimiter) {
            String customDelimiter = Validator.extractDelimiter(text);
            text = text.replace("//" + customDelimiter + "\\n", "");
            return text.split(Pattern.quote(customDelimiter));
        } else {
            return text.split("[,:]+");
        }
    }
}
