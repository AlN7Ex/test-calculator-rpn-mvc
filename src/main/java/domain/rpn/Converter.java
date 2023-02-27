package domain.rpn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static String[] convertExprToCorrectFormat(String expression) {
        String trim = expression.replaceAll("\\s", "");
        String[] tempStr = trim.split("");
        StringBuilder stringBuilder = new StringBuilder();
        List<String> arrStr = Arrays.stream(tempStr).collect(Collectors.toList());
        int initFirstElem = 0;
        switch (arrStr.get(initFirstElem)) {
            case "+":
                initFirstElem++;
                break;
            case "*":
            case "/":
                throw new RuntimeException("Wrong first input sigh: " + arrStr.get(initFirstElem));
        }
        stringBuilder.append(arrStr.get(initFirstElem));
        for (int i = initFirstElem + 1; i < arrStr.size(); ++i) {
            if ("+-*/".contains(arrStr.get(i))) {
                stringBuilder.append(" ");
                stringBuilder.append(arrStr.get(i));
                stringBuilder.append(" ");
            } else {
                stringBuilder.append(arrStr.get(i));
            }
        }

        return stringBuilder.toString().split(" ");
    }
}
