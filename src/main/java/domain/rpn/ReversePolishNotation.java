package domain.rpn;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class ReversePolishNotation {

    public static String calculate(String expression) {
        if (expression.isEmpty()) {
            return "Пустая строка";
        }
        String[] elem = Converter.convertExprToCorrectFormat(expression);
        Stack<String> numberStack = new Stack<>();
        Stack<Enum> signStack = new Stack<>();

        for (int i = 0; i < elem.length; i++) {
            if (!elem[i].equals("+")
                    && !elem[i].equals("-")
                    && !elem[i].equals("*")
                    && !elem[i].equals("/")
                    && !elem[i].equals("(")
                    && !elem[i].equals(")")) {
                numberStack.push(elem[i]);
            } else if (signStack.empty()) {
                switch (elem[i]) {
                    case "+":
                        signStack.push(OperandPriority.PLUS);
                        break;
                    case "-":
                        signStack.push(OperandPriority.MINUS);
                        break;
                    case "*":
                        signStack.push(OperandPriority.MULTIPLICATION);
                        break;
                    case "/":
                        signStack.push(OperandPriority.DIVISION);
                        break;
                }
            } else {
                double topNum, bottomNum;
                String temp;
                OperandPriority internalSigh, externalSign;
                internalSigh = (OperandPriority) signStack.peek();
                externalSign = null;

                // Init current sign in expression
                switch (elem[i]) {
                    case "+":
                        externalSign = OperandPriority.PLUS;
                        break;
                    case "-":
                        externalSign = OperandPriority.MINUS;
                        break;
                    case "*":
                        externalSign = OperandPriority.MULTIPLICATION;
                        break;
                    case "/":
                        externalSign = OperandPriority.DIVISION;
                        break;
                }
                if (externalSign == null) {
                    return new IllegalArgumentException("Wrong operand").getMessage();
                }

                // Calculating while external sigh has less priority than internal sign

                while (internalSigh.getPriority() >= externalSign.getPriority()) {
                    if (signStack.empty()) {
                        break;
                    }
                    internalSigh = (OperandPriority) signStack.pop();
                    topNum = Double.parseDouble(numberStack.pop());
                    bottomNum = Double.parseDouble(numberStack.pop());
                    switch (internalSigh.getTitle()) {
                        case "+":
                            temp = Double.toString(bottomNum + topNum);
                            numberStack.push(temp);
                            break;
                        case "-":
                            temp = Double.toString(bottomNum - topNum);
                            numberStack.push(temp);
                            break;
                        case "*":
                            temp = Double.toString(bottomNum * topNum);
                            numberStack.push(temp);
                            break;
                        case "/":
                            temp = Double.toString(bottomNum / topNum);
                            numberStack.push(temp);
                            break;
                    }
                }
                signStack.push(externalSign);
            }
        }
        double topNumber, bottomNumber;
        while (numberStack.size() > 1) {
            topNumber = Double.parseDouble(numberStack.pop());
            bottomNumber = Double.parseDouble(numberStack.pop());
            OperandPriority sign = (OperandPriority) signStack.pop();
            switch (sign.getTitle()) {
                case "+":
                    numberStack.push(Double.toString(bottomNumber + topNumber));
                    break;
                case "-":
                    numberStack.push(Double.toString(bottomNumber - topNumber));
                    break;
                case "*":
                    numberStack.push(Double.toString(bottomNumber * topNumber));
                    break;
                case "/":
                    numberStack.push(Double.toString(bottomNumber / topNumber));
                    break;
            }
        }
        return numberStack.pop();
    }
}

