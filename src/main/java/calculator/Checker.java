package calculator;

public class Checker {
    public static void positiveNumber(String numberString) {
        if (numberString.contains("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 허용되지 않습니다.");
        }
    }
}
