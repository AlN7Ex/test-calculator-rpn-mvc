package domain.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convertExprToCorrectFormat1() {
        String expression = "10+2*3-5";
        String[] actual = Converter.convertExprToCorrectFormat(expression);
        String[] expected = {"10", "+", "2", "*", "3", "-", "5"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void convertExprToCorrectFormat2() {
        String expression = "2+2*2+2";
        String[] actual = Converter.convertExprToCorrectFormat(expression);
        String[] expected = {"2", "+", "2", "*", "2", "+", "2"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void convertExprToCorrectFormat3() {
        String expression = "2 +2*2+2";
        String[] actual = Converter.convertExprToCorrectFormat(expression);
        String[] expected = {"2", "+", "2", "*", "2", "+", "2"};
        assertArrayEquals(actual, expected);
    }

}