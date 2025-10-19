package calculator;

public class Calculator {
    public static int add(String text) {
        String[] texts = InputParser.parse(text);

        int sum = 0;
        for (String numberString : texts) {
            if (numberString.isBlank()) { // 1. 공백이라면 무시하고 다음 배열 확인
                continue;
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
