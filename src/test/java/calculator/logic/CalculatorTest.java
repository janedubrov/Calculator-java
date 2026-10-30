package calculator.logic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        calculator.setNum1(12);
        calculator.setNum2(2.4);
        calculator.setOperator('+');

        double result = calculator.calculate();

        assertEquals(14.4, result, 0.0001);
    }

    @Test
        void testSubtraction() {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(3);
        calculator.setOperator('-');

        double result = calculator.calculate();

        assertEquals(7.0, result, 0.0001);
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        calculator.setNum1(3.1);
        calculator.setNum2(5);
        calculator.setOperator('*');

        double result = calculator.calculate();

        assertEquals(15.5, result, 0.0001);
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        calculator.setNum1(8);
        calculator.setNum2(3);
        calculator.setOperator('/');

        double result = calculator.calculate();

        assertEquals(8.0/3, result, 0.0001);
    }

    @Test
    void divisionByZero() {
        Calculator calculator = new Calculator();
        calculator.setNum1(5);
        calculator.setNum2(0);
        calculator.setOperator('/');

        assertThrows(ArithmeticException.class, () -> calculator.calculate());
    }

    @Test
    void testChainedCalculation() {
        Calculator calculator = new Calculator();

        calculator.setNum1(10);
        calculator.setNum2(8);
        calculator.setOperator('-');
        calculator.calculate();

        calculator.setNum2(3);
        calculator.setOperator('*');
        double result = calculator.calculate();

        assertEquals(6.0, result, 0.0001);
    }
}
