package gov.iti.jets;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("test the calculator operation")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    public void setup() {

        calculator = new Calculator();

    }

    @AfterEach
    public void cleanup() {
        calculator = null;

    }

    @Test
    @DisplayName("test add 2 numbers operation")
    public void testAdditionOperation() {

        double expected = 25;
        double actual = calculator.addition(15, 10);

        Assumptions.assumeTrue(expected > 0 && actual > 0);

        assertEquals(expected, actual);
        assertNotEquals(expected, calculator.addition(2, 3));
        assertThrows(NullPointerException.class, () -> {

            throw new NullPointerException("null pointer exception");

        });


    }

    @Test
    public void testSubtractionOperation() {

        double result[] = new double[]{calculator.subtraction(15, 10), calculator.subtraction(4, 2)};
        assertArrayEquals(new double[]{5, 2}, result);
    }

    @Test
    public void testMultiplicationOperation() {

        assertTrue(4 == calculator.multiply(2, 2));
        assertFalse(25 == calculator.multiply(5, 4));

    }

    @Test
    public void testDivisionOperation() {

        assertThrows(ArithmeticException.class, () -> calculator.division(1, 0));
        assertDoesNotThrow(() -> calculator.division(5, 2));
        assertAll(() -> assertEquals(12, calculator.addition(8, 4)), () -> assertEquals(12, calculator.multiply(6, 2))

        );

        assertNotNull(calculator);
        Calculator calc = null;
        assertNull(calc);
    }

    @Test
    @Disabled
    public void testMultiplicationOperation(int x) {

        System.out.println("multiply operation testing");

    }

    @BeforeAll
    public static void beforeAllOperations() {
        System.out.println("before all calculator operations");

    }

    @AfterAll
    public static void afterAllOperations() {
        System.out.println("after all calculator operations");

    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 15})
    void isPositiveNubers(int number) {

        assertTrue(number > 0);
    }


}
