package part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest2 {

    @Test
    public void add() {
        Calculator cal = new Calculator();
        assertEquals(9, cal.add(6, 3));
    }

    @Test
    public void subtract() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.subtract(6, 3));
    }

    @Test
    public void multiply() {
        Calculator cal = new Calculator();
        assertEquals(18, cal.multiply(6, 3));
    }

    @Test
    public void divide() {
        Calculator cal = new Calculator();
        assertEquals(2, cal.divide(6, 3));
    }

}