package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class OctalToDecimalTest {
    OctalToDecimal converter;

    @BeforeEach
    void setUp() {
        converter = new OctalToDecimal();
    }

    @Test
    void convert_oct7_to_dec() {
        //arrange
        int oct = 7;
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(oct);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_oct10_to_dec() {
        //arrange
        int oct = 10;
        int expectedResult = 8;

        //act
        int actualResult = converter.convert(oct);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_oct12345_to_dec() {
        //arrange
        int oct = 12345;
        int expectedResult = 5349;

        //act
        int actualResult = converter.convert(oct);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}