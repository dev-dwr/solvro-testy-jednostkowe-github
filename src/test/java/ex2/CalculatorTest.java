package ex2;

import org.junit.jupiter.api.Test;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void shouldAddTwoNumber() {
        // given
        int a = 5;
        int b = 1;
        // when
        int sum = Calculator.sum(a, b);
        //then
        assertEquals(6, sum);
    }

    @Test
    void shouldSubtractTwoNumbersAndReturnNonNegativeNumber() {
        // given
        int a = 5;
        int b = 3;
        // when
        int subtract = Calculator.subtract(a, b);
        //then
        assertEquals(2, subtract);
    }

    @Test
    void shouldSubtractTwoNumbersAndReturnNegativeNumber() {
        // given
        int a = 3;
        int b = 5;
        // when
        int subtract = Calculator.subtract(a, b);
        //then
        assertEquals(-2, subtract);
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        // given
        int a = 3;
        int b = 5;
        // when
        int multiply = Calculator.multiply(a, b);
        //then
        assertEquals(15, multiply);
    }

    @Test
    void shouldDivideTwoNumbers() {
        // given
        float a = 3;
        float b = 2;
        // when
        float divide = Calculator.divide(a, b);
        //then
        assertEquals(1.5, divide);
    }

    @Test
    void shouldThrowArithmeticExceptionWhileDividingBy0() {
        float a = 5;
        float b = 0;

        assertThrows(ArithmeticException.class,
                () -> Calculator.divide(a,b),
                "Cannot divide by 0");
    }
}