package domain.rpn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static String[] convertExprToCorrectFormat(String expression) {
        String[] tempStr = expression.split("");
        StringBuilder stringBuilder = new StringBuilder();
        List<String> arrStr = Arrays.stream(tempStr).collect(Collectors.toList());
        stringBuilder.append(arrStr.get(0));
        for (int i = 1; i < arrStr.size(); ++i) {
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
