package calculator;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result;
        try {
            String input = Input.input();
            boolean isCustomDelimiter = Validator.isCustomDelimiter(input);
            if (isCustomDelimiter) {
                result = Calculator.add(input, Validator.extractDelimiter(input));
            } else {
                result = Calculator.add(input, null);
            }
            Output.output(result);
        } catch (NoSuchElementException e) {
            Output.output(0);
        }
    }
}
