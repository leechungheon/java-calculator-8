package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 커스텀 구분자 판별 클래스
 */
public class Delimiter {

    public static final String START_CUSTOM_DELIMITER = "//";
    public static final String END_CUSTOM_DELIMITER = "\\n";

    private static final String REGEX =
            Pattern.quote(START_CUSTOM_DELIMITER) + "(.+?)" + Pattern.quote(END_CUSTOM_DELIMITER);
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static String extractDelimiter(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static boolean hasMultipleCustomDelimiter(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            if (count > 1) {
                return true;
            }
        }
        return count != 1;
    }

    public static boolean isCustomDelimiterNotOneChar(String text) {
        String delimiter = extractDelimiter(text);
        if (delimiter == null) {
            return true;
        }
        return delimiter.length() != 1;
    }

    public static boolean isDelimiterDigit(String text) {
        String delimiter = extractDelimiter(text);
        if (delimiter == null || delimiter.isEmpty()) {
            return true;
        }
        return delimiter.matches("\\d+");
    }

    public static boolean isCustomDelimiter(String text) {
        text = text.replaceAll("\\s", "");

        if (!text.startsWith(START_CUSTOM_DELIMITER) || !text.contains(END_CUSTOM_DELIMITER)) {
            return false;
        }
        if (hasMultipleCustomDelimiter(text)) { // 커스텀 구분자가 하나가 아닌 경우
            return false;
        }
        if (isCustomDelimiterNotOneChar(text)) { // 커스텀 구분자가 한 글자가 아닌 경우
            return false;
        }
        if (isDelimiterDigit(text)) { // 커스텀 구분자가 숫자인 경우
            return false;
        }
        return true;
    }
}
