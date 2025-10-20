package calculator;

public class Checker {
    private static boolean isAllDigits(String numberString) {
        return numberString.matches("^\\d+$");
    }

    public static void positiveNumber(String numberString) {
        // 1. 음수 검사
        if (numberString.contains("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
        // 2. 숫자가 아닌 문자 포함 여부 검사
        if (!isAllDigits(numberString)) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 허용되지 않습니다.");
        }
        // 3. 오버플로우 검사
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용되는 정수 범위를 초과합니다.");
        }
    }

    public static void checkOverflow(String numberString, int sum) {
        int number = Integer.parseInt(numberString);

        try {
            sum = Math.addExact(sum, number);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("계산 결과가 계산 가능한 범위를 초과했습니다.");
        }
    }
}
