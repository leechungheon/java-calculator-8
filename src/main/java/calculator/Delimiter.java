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

    public static boolean hasSingleCustomDelimiter(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static boolean isCustomDelimiterOneChar(String text) {
        String delimiter = extractDelimiter(text);
        if (delimiter == null) {
            return false;
        }
        return delimiter.length() == 1;
    }

    public static boolean isDelimiterNotDigit(String text) {
        String delimiter = extractDelimiter(text);
        if (delimiter == null || delimiter.isEmpty()) {
            return false;
        }
        boolean isOnlyDigits = delimiter.matches("\\d+");
        return !isOnlyDigits;
    }

    public static boolean isCustomDelimiter(String text) {
        text = text.replaceAll("\\s", "");

        if (!text.startsWith(START_CUSTOM_DELIMITER) || !text.contains(END_CUSTOM_DELIMITER)) {
            System.out.println("커스텀 구분자 양식이 포함되어 있지 않습니다.");
            return false;
        }
        if (!hasSingleCustomDelimiter(text)) { // 커스텀 구분자가 하나가 아닌 경우
            System.out.println("커스텀 구분자가 없거나 여러 개입니다.");
            return false;
        }
        if (!isCustomDelimiterOneChar(text)) { // 커스텀 구분자가 한 글자가 아닌 경우
            System.out.println("커스텀 구분자가 한 글자가 아닙니다.");
            return false;
        }
        if (!isDelimiterNotDigit(text)) { // 커스텀 구분자가 숫자인 경우
            System.out.println("커스텀 구분자가 숫자입니다.");
            return false;
        }
        return true;
    }
}
