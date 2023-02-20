package domain;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class ReversePolishNotation {

    public static String calculate(String expression) {
        if (expression.isEmpty()) {
            return "Пустая строка";
        }
        String[] elem = expression.split(" ");
        Stack<String> numberStack = new Stack<>();
        Stack<Enum> signStack = new Stack<>();

        for (int i = 0; i < elem.length; i++) {
            int i1 = Integer.parseInt(elem[elem.length - 1]);
            if (i1 == -1) {
                throw new IllegalArgumentException("Last symbol isn't digit: " + elem[elem.length - 1]);
            }

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
                        signStack.push(Priority.PLUS);
                        break;
                    case "-":
                        signStack.push(Priority.MINUS);
                        break;
                    case "*":
                        signStack.push(Priority.MULTIPLICATION);
                        break;
                    case "/":
                        signStack.push(Priority.DIVISION);
                        break;
                }
            } else {
                double topNum, bottomNum;
                String temp;
                Priority internalSigh, externalSign;
                internalSigh = (Priority) signStack.peek();
                externalSign = null;

                // Инициализируем текущий знак в выражении
                switch (elem[i]) {
                    case "+":
                        externalSign = Priority.PLUS;
                        break;
                    case "-":
                        externalSign = Priority.MINUS;
                        break;
                    case "*":
                        externalSign = Priority.MULTIPLICATION;
                        break;
                    case "/":
                        externalSign = Priority.DIVISION;
                        break;
                }
                // Производим вычисления пока у последнего знака в стеке
                // приоритет меньше вставляемого в стек знака
                while (internalSigh.getPriority() >= externalSign.getPriority()) {
                    if (signStack.empty()) {
                        break;
                    }
                    internalSigh = (Priority) signStack.pop();
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
            Priority sign = (Priority) signStack.pop();
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
enum Priority {
    PLUS("+", 1),
    MINUS("+", 1),
    DIVISION("/", 2),
    MULTIPLICATION("*", 2);

    private final String title;
    private final int priority;

    Priority(String title, int priority) {
        this.title = title;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public int getPriority() {
        return priority;
    }
}

