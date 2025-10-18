package calculator;

import java.util.regex.Pattern;

public class Calculator {
    public static int add(String text, String customDelimiter) {
        String[] texts;
        if (customDelimiter == null) { // 기본 구분자 사용 시
            texts = text.replaceAll("\\s", "").split("[,:]+");
        } else { // 커스텀 구분자 사용 시
            String cleanedText = text.replaceAll("\\s", "")
                    .replace("//" + customDelimiter + "\\n", "");
            texts = cleanedText.split(Pattern.quote(customDelimiter));
        }
        int sum = 0;
        for (String numberString : texts) {
            if (numberString.isBlank()) { // 1. 공백을 입력한다면 0을 반환
                return 0;
            } else if (numberString.contains("-")) { // 2. 음수 입력 시 예외 처리
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            } else if (isNumber(numberString)) { // 4. 그 외의 경우에는 기본 구분자로 구분된 모든 숫자의 합을 반환
                sum += Integer.parseInt(numberString);
            } else {
                throw new IllegalArgumentException("숫자가 아닌 문자는 허용되지 않습니다.");
            }
        }
        return sum;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
