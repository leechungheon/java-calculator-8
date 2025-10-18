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
        for (String str : texts) {
            if (str.isBlank()) { // 1. 공백을 입력한다면 0을 반환
                return 0;
            } else if (str.contains("-")) { // 2. 음수 입력 시 예외 처리
                throw new IllegalArgumentException();
            } else if (texts.length == 1) { // 3. 한 자리 숫자라면 해당 숫자를 반환
                return Integer.parseInt(str);
            } else { // 4. 그 외의 경우에는 기본 구분자로 구분된 모든 숫자의 합을 반환
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }
}
