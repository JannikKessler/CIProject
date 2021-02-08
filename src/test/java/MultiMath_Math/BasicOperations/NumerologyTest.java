package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumerologyTest {

    Numerology num;

    @BeforeEach
    void setUp() throws Exception {
        num = new Numerology();
    }

    @Test
    public void isEvenTest() {
        // Arrange
        int[] operations = {0, 1, 2, 3, 11, 12, 999998};
        boolean[] expected = {true, false, true, false, false, true, true};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = Numerology.isEven(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Even Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void isPrimeTest(){
        // Arrange
        int[] operations = {17, 7, 23, 13, 19, 109, 90, 69, 77, 108};
        boolean[] expected = {true, true, true, true, true, true, false, false, false, false};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = Numerology.isPrime(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Prime Digit Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void isPrimeParserIntegerDoubleTest() {
        // Arrange
        String[] operations = {"isPrime(1)", "isPrime( 1 )", "isPrime(3.0)"};
        boolean[] expected = {false, false, true};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.isPrimeParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Prime Digit Parser Test", results, CoreMatchers.equalTo(expected));
    }

}
