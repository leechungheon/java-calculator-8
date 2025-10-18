package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine(); // 예외 발생 가능
            boolean isCustomDelimiter = Validator.isCustomDelimiter(input);
            if (isCustomDelimiter) {
                int result = Calculator.add(input, Validator.extractDelimiter(input));
                System.out.println("결과 : " + result);
            } else {
                int result = Calculator.add(input, null);
                System.out.println("결과 : " + result);
            }
        } catch (NoSuchElementException e) {
            System.out.println("결과 : " + 0);
        }
    }
}
