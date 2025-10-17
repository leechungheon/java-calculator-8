package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_쉼표_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_콜론_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_여러번_사용() {
        assertSimpleTest(() -> {
            run("1::::2:,,:::3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_사이_스페이스_공백() {
        assertSimpleTest(() -> {
            run("1,   2,  3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_사이_탭_공백() {
        assertSimpleTest(() -> {
            run("1,\t\t2,\t3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_앞_0존재() {
        assertSimpleTest(() -> {
            run("01,02,03");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자_0_입력() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 입력_없음() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_스페이스_입력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_탭_입력() {
        assertSimpleTest(() -> {
            run("\t");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_엔터_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_하나_입력() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 공백_숫자_하나_입력() {
        assertSimpleTest(() -> {
            run("1   2  3    4");
            assertThat(output()).contains("결과 : 1234");
        });
    }

    @Test
    void 연속숫자_하나_입력() {
        assertSimpleTest(() -> {
            run("1234");
            assertThat(output()).contains("결과 : 1234");
        });
    }

    @Test
    void 커스텀_구분자_사용_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용_물음표() {
        assertSimpleTest(() -> {
            run("//?\\n1?2?3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_달러() {
        assertSimpleTest(() -> {
            run("//$\\n1$2$3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_여는대괄호() {
        assertSimpleTest(() -> {
            run("//[\\n1[2[3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_숫자_여러개() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_동일() {
        assertSimpleTest(() -> {
            run("//,\\n1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속된_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 알파벳_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,@"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 실수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2.5,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!/n1!2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_여러개() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!\\n//@\\n1!2@3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_위치_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1!2!3//!\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1!2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n12321"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_스페이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("// \\n1 2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_길이_1초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@\\n1!@2!@3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_기본_구분자_혼용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
