package calculator;

public class Calculator {
    public static int add(String text) {
        if (text.isBlank()) {
            return 0;
        }

        String[] texts = InputParser.parse(text);
        int sum = 0;
        for (String numberString : texts) {
            Checker.checkNotBlank(numberString);
            int number = Checker.singleNumber(numberString);
            Checker.checkOverflow(number, sum);
            sum += number;
        }

        return sum;
    }
}
