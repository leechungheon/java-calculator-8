package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result;
        String input = Input.input();
        result = Calculator.add(input);
        Output.output(result);
    }
}
