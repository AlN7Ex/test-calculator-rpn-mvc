package domain.rpn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePolishNotationTest {

    @Test
    public void calculate1() {
        String expression = "1+2*4-7+10/2+4+10";
        double actual = Double.parseDouble(ReversePolishNotation.calculate(expression));
        double expected = 21.0;
        assertEquals(actual, expected, Math.abs(expected - actual));
    }

    @Test
    public void calculate2() {
        String expression = "10+2*3-5";
        String actual = ReversePolishNotation.calculate(expression);
        String expected = "11.0";
        assertEquals(actual, expected);
    }

    @Test
    public void calculate3() {
        String expression = "2+2*2+2";
        String actual = ReversePolishNotation.calculate(expression);
        String expected = "8.0";
        assertEquals(actual, expected);
    }

    @Test
    public void calculate4() {
        String expression = "";
        String actual = ReversePolishNotation.calculate(expression);
        String expected = "Entered empty expression";
        assertEquals(actual, expected);
    }
}