package calculator;

public class Calculator {
    public static int add(String text) {
        String[] texts = InputParser.parse(text);
        int sum = 0;
        if (text.isBlank()) {
            return 0;
        }
        for (String numberString : texts) {
            if (numberString.isBlank()) {
                throw new IllegalArgumentException("구분자의 위치가 잘못되었습니다.");
            }
            Checker.positiveNumber(numberString);
            sum += Integer.parseInt(numberString);
        }

        return sum;
    }
}
