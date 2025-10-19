package calculator;

public class Calculator {
    public static int add(String text) {
        String[] texts = InputParser.parse(text);
        int sum = 0;

        for (String numberString : texts) {
            if (numberString.isBlank()) {
                continue;
            }
            Checker.positiveNumber(numberString);
            sum += Integer.parseInt(numberString);
        }

        return sum;
    }
}
