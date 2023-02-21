import domain.rpn.ReversePolishNotation;

public class Main {
    public static void main(String[] args) {
        double v = Double.parseDouble(ReversePolishNotation.calculate("1+2*4-7+10/2+4+10"));
        System.out.println("1");
    }
}

