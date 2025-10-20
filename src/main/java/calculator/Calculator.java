package calculator;

public class Calculator {
    public static int add(String text) {
        if (text.isBlank()) {
            return 0;
        }

        String[] texts = InputParser.parse(text);
        int sum = 0;
        for (String numberString : texts) {
            if (numberString.isBlank()) {
                throw new IllegalArgumentException("구분자의 위치가 잘못되었습니다.");
            }
            int number = Checker.singleNumber(numberString);
            Checker.checkOverflow(number, sum);
            sum += number;
        }

        return sum;
    }
}
