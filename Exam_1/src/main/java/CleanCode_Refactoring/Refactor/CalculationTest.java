package CleanCode_Refactoring.Refactor;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    @Test
    public void checkAddition() {
        int result = Calculator.calculate(10, 5, Calculator.ADDITION);
        assertEquals(15, result);
    }

    @Test
    public void checkSubtraction() {
        int result = Calculator.calculate(10, 5, Calculator.SUBTRACTION);
        assertEquals(5, result);
    }

    @Test
    public void checkMultiplication() {
        int result = Calculator.calculate(10, 5, Calculator.MULTIPLICATION);
        assertEquals(50, result);
    }

    @Test
    public void checkDivision() {
        int result = Calculator.calculate(10, 5, Calculator.DIVISION);
        assertEquals(2, result);
    }

}
