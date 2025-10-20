package calculator;

public class Checker {
    public static int singleNumber(String numberString) {
        int number;

        // 1. 숫자 형식 및 int 범위 초과 검사
        try {
            number = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            // 숫자가 아닌 문자, 혹은 int 범위를 초과하는 문자열 처리
            throw new IllegalArgumentException("입력값이 유효한 정수 형식이 아니거나 허용되는 범위를 초과합니다.");
        }

        // 2. 음수 검사
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        return number;
    }

    public static void checkOverflow(int number, int sum) {
        try {
            sum = Math.addExact(sum, number);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("계산 결과가 계산 가능한 범위를 초과했습니다.");
        }
    }

    public static void checkNotBlank(String numberString) {
        if (numberString.isBlank()) {
            throw new IllegalArgumentException("구분자의 위치가 잘못되었습니다.");
        }
    }
}
