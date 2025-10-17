package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        boolean isCustomDelimiter = Validator.isCustomDelimiter(input);
        if (isCustomDelimiter) {
            int result = Calculator.customDelimiter(input, Validator.extractDelimiter(input));
            System.out.println("결과 : " + result);
        } else {
            int result = Calculator.defaultDelimiter(input);
            System.out.println("결과 : " + result);
        }
    }
}
