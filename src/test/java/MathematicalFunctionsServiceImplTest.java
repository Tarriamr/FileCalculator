import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathematicalFunctionsServiceImplTest {

    final MathematicalFunctionsService mathematicalFunctionsService = new MathematicalFunctionsServiceImpl();

    @Test
    public void shouldAddTwoNumbers() {
        //given
        double firstNumber = 10;
        double secondNumber = 20;
        //when
        double result = mathematicalFunctionsService.add(firstNumber, secondNumber);
        //then
        assertEquals(30, result);
    }

    @Test
    public void shouldSubtractTwoNumbers() {
        //given
        double firstNumber = 10;
        double secondNumber = 20;
        //when
        double result = mathematicalFunctionsService.subtract(firstNumber, secondNumber);
        //then
        assertEquals(-10, result);
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        //given
        double firstNumber = 10;
        double secondNumber = 20;
        //when
        double result = mathematicalFunctionsService.multiply(firstNumber, secondNumber);
        //then
        assertEquals(200, result);
    }

    @Test
    public void shouldDivideTwoNumbers() {
        //given
        double firstNumber = 20;
        double secondNumber = 10;
        //when
        double result = mathematicalFunctionsService.divide(firstNumber, secondNumber);
        //then
        assertEquals(2, result);
    }

    @Test
    public void divisionByZeroShouldGiveAnIllegalArgumentException() {
        //given
        double firstNumber = 20;
        double secondNumber = 0;
        //when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> mathematicalFunctionsService.divide(firstNumber, secondNumber)
        );
        //then
        assertEquals("You try divide by zero!", exception.getMessage());
    }

    @Test
    public void resultShouldBeRoundedToFourDecimalPlaces() {
        //given
        double firstNumber = 1;
        double secondNumber = 3;
        //when
        double result = mathematicalFunctionsService.divide(firstNumber, secondNumber);
        //then
        assertEquals(0.3333, result);
    }

    @Test
    public void resultShouldBeRoundedUpToFourDecimalPlaces() {
        //given
        double firstNumber = 1;
        double secondNumber = 6;
        //when
        double result = mathematicalFunctionsService.divide(firstNumber, secondNumber);
        //then
        assertEquals(0.1667, result);
    }
}
