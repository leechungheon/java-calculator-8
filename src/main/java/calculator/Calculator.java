package calculator;

public class Calculator {
    public static int defaultDelimiter(String text) {
        //값이 null이거나 빈 공백 문자일 경우 0을 반환
        if (text == null || text.isBlank()) {
            return 0;
        } else {
            throw new IllegalArgumentException();
        }

    }
}
