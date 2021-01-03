package MultiMath_Math.BasicOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multiplication {


    private final Pattern MUL_PATTERN_INT = Pattern.compile("([-$0-9]+\\s*\\*\\s*)+[0-9]+");
    //private final Pattern MUL_PATTERN_DOUBLE = Pattern.compile("[-$0-9]+(\\.[-$0-9]*)?\\s*\\*\\s*[-$0-9]+(\\.[-$0-9]*)?");

    public static int multiply(int... factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double multiply(double[] factors) {
        double product = 1;
        String productString;

        for (double factor : factors) {
            product *= factor;
        }

        productString = getRoundedValue(product);

        return Double.parseDouble(productString);
    }

    private static String getRoundedValue(double product) {
        String productString;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        productString = df.format(product);
        return productString;
    }

    public int parseMultiplication(String operation) {
        int result = 0;
        Matcher patternMatcher = MUL_PATTERN_INT.matcher(operation);

        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();
            String[] splitOperationString = splitOperation(matchedOperation);
            int[] splitOperationValues = convertToValue(splitOperationString);
            result = multiply(splitOperationValues);
        }
        return result;
    }

    private int[] convertToValue(String[] splitOperation) {
        int[] splitOperationValues = new int[splitOperation.length];
        for (int i = 0; i < splitOperation.length; i++) {
            splitOperationValues[i] = Integer.parseInt(splitOperation[i]);
        }
        return splitOperationValues;
    }

    private String[] splitOperation(String matchedOperation) {
        matchedOperation = removeWhitespace(matchedOperation);
        return matchedOperation.split("\\*");
    }

    private String removeWhitespace(String operation) {
        return operation.replaceAll("\\s+", "");
    }
}
