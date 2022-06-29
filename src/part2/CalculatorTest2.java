package part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest2 {
    Calculator cal;

    @Before
    public void setup() {
        /* 다른 테스트에 영향을 줄 수 있기 때문에, Calculator 인스턴스를 매 테스트마다 생성하여 테스트의 독립성을 보장 해줌 */
        cal = new Calculator();
        System.out.println("테스트 실행 전 (초기화)");
    }

    @After
    public void teardown() {
        System.out.println("테스트 실행 후 (후처리)\n");
    }

    @Test
    public void add() {
        assertEquals(9, cal.add(6, 3));
        System.out.println("add()");
    }

    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
        System.out.println("subtract()");
    }

    @Test
    public void multiply() {
        assertEquals(18, cal.multiply(6, 3));
        System.out.println("multiply()");
    }

    @Test
    public void divide() {
        assertEquals(2, cal.divide(6, 3));
        System.out.println("divide()");
    }

}