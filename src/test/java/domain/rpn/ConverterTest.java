package domain.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convertExprToCorrectFormat() {
        String expression = "10+2*3-5";
        String[] actual = Converter.convertExprToCorrectFormat("10+2*3-5");
        String[] expected = {"10", "+", "2", "*", "3", "-", "5"};
        assertArrayEquals(actual, expected);
    }
}