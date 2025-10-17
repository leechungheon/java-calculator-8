package calculator;

public class Calculator {
    /**
     * 기본 구분자를 사용하는 메서드 defaultDelimiter
     */
    public static int defaultDelimiter(String text) {
        String[] texts = text.replaceAll("\\s", "").split("[,:]"); // !리팩토링 필요
        int sum = 0;
        for (String str : texts) {
            str = str.trim();
            if (str.isBlank()) { // 1. 공백을 입력한다면 0을 반환
                return 0;
            } else if (texts.length == 1) { // 2. 한 자리 숫자라면 해당 숫자를 반환
                return Integer.parseInt(str);
            } else {
            }
        }
        throw new IllegalArgumentException();
    }
}
