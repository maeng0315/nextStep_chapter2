package part2.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
//    private StringCalculator cal;
    private StringCalculatorBook cal;

    @Before
    public void setup() {
//        cal = new StringCalculator();
        cal = new StringCalculatorBook();
    }

    @Test
    public void 공백_입력() {
        assertEquals(0, cal.add(""));
        assertEquals(0, cal.add(" "));
        assertEquals(0, cal.add(null));
    }


    @Test
    public void 숫자_0_입력() {
        assertEquals(0, cal.add("0"));
        assertEquals(3, cal.add("1,2,0"));
    }

    @Test
    public void 음수_입력() {
        assertThrows(RuntimeException.class, () -> cal.add("-9,2"));
        assertThrows(RuntimeException.class, () -> cal.add("-1,2,3"));
    }

    @Test(expected = RuntimeException.class)
    public void 음수_입력2() {
        cal.add("-9,2");
        cal.add("-1,2,3");
    }

    @Test
    public void 쉼표_구분자() {
        assertEquals(3, cal.add("1,2"));
        assertEquals(6, cal.add("1,2,3"));
    }

    @Test
    public void 콜론_구분자() {
        assertEquals(3, cal.add("1:2"));
        assertEquals(6, cal.add("1:2:3"));
    }

    @Test
    public void 쉼표_콜론_혼합_구분자() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void 사용자_지정_구분자() {
        assertEquals(6, cal.add("//!\n1!2!3"));
    }
}