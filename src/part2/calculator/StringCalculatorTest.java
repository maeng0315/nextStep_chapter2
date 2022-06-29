package part2.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @DisplayName("공백 입력")
    @Test
    public void empty() {
        assertEquals(0, cal.add(""));
        assertEquals(0, cal.add(" "));
    }

    @DisplayName("0 입력")
    @Test
    public void zero() {
        assertEquals(0, cal.add("0"));
        assertEquals(3, cal.add("1,2,0"));
    }

    @DisplayName("음수 입력")
    @Test
    public void negative() {
        assertThrows(RuntimeException.class, () -> cal.add("1,-2"));
        assertThrows(RuntimeException.class, () -> cal.add("-1,2,3"));
    }

    @DisplayName("기본(쉼표) 구분자")
    @Test
    public void comma_delimiter() {
        assertEquals(3, cal.add("1,2"));
        assertEquals(6, cal.add("1,2,3"));
    }

    @DisplayName("기본(콜론) 구분자")
    @Test
    public void colon_delimiter() {
        assertEquals(3, cal.add("1:2"));
        assertEquals(6, cal.add("1:2:3"));
    }

    @DisplayName("기본(쉼표, 콜론) 구분자 혼합")
    @Test
    public void comma_colon_delimiter() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @DisplayName("기본(쉼표, 콜론) 구분자 혼합")
    @Test
    public void coustom_delimiter() {
        assertEquals(6, cal.add("//!\n1!2!3"));
    }
}