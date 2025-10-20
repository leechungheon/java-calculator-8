package calculator;

import java.util.regex.Pattern;

public class InputParser {
    public static String[] parse(String text) {
        text = text.replaceAll("\\s", "");
        boolean isCustomDelimiter = Delimiter.isCustomDelimiter(text);

        if (isCustomDelimiter) {
            String customDelimiter = Delimiter.extractDelimiter(text);
            text = text.replace("//" + customDelimiter + "\\n", "");
            return text.split(Pattern.quote(customDelimiter), -1);
        } else {
            return text.split("[,:]", -1);
        }
    }
}
