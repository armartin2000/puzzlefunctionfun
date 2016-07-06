package recursionfun;

/**
 * Created by amartinez on 7/5/16.
 */
public class FactorialPuzzles {

    public static void main(String[] args) {

        System.out.println(FactorialPuzzles.recursionFibionacci(6));
        System.out.println(FactorialPuzzles.fibionacci(6));

    }


    // Give the nth Fibionacci number
    // Starting with 1 and 1, a Fibionacci number is the sum of the previous two.
    public static Integer recursionFibionacci(Integer n) {

        if (n <= 0) {
            return 0;
        }
        if (n < 2) {
            return n;
        } else {
            return recursionFibionacci(n - 1) + recursionFibionacci(n - 2);
        }
    }

    public static int fibionacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 2) {
            return n;
        }

        int prev = 0;
        int current = 1;
        for (int i = 1; i < n; i++) {
            int save = current;
            current += prev;
            prev = save;
        }
        return current;
    }

    // Calculate the golden ratio.
    // Given two numbers a and b with a > b > 0, the ratio is b / a.
    // Let c = a + b, then the ratio c / b is closer to the golden ratio.
    // Let d = b + c, then the ratio d / c is closer to the golden ratio.
    // Let e = c + d, then the ratio e / d is closer to the golden ratio.
    // If you continue this process, the result will trend towards the golden ratio.
    public static Double goldenRatio(Double a, Double b) {

        double epsilon = 0.000001;
        double d = Math.abs((b / a) - ((a + b) / b));
        boolean result = d < epsilon;
        if (result) {
            return (a + b) / b;
        } else {
            return goldenRatio(b, a + b);
        }

        // BigDecimal valueA = BigDecimal.valueOf(fibionacci(a.intValue()));
        //  BigDecimal valueB = BigDecimal.valueOf(fibionacci(b.intValue()));

        //  BigDecimal ratio = valueA.divide(valueB,mc);
        //BigDecimal ratio = valueA.divide(valueB,scale, RoundingMode.HALF_UP);

        //return ratio.doubleValue();

    }

    // Give the square root of a number
    // Using a binary search algorithm, search for the square root of a given number.
    // Do not use the built-in square root function.
    public static Double squareRoot(Double n) {

        //calculate upper bound
        double maxUpper = n;

        double lowerIndex = 0;
        double upperIndex = maxUpper - 1;

        while (lowerIndex >= 0 && upperIndex < maxUpper) {

            //calculate the middle to start
            double middleIndex = (lowerIndex + upperIndex) / 2;

            double value = middleIndex * middleIndex;
            //if equals value, we're done
            if (value == n) {
                return middleIndex;
            } else if (value > n) {
                //lower stays the same
                //update upper bound
                upperIndex = middleIndex - 1;

            } else {
                //upper index does not change
                // update lower index
                lowerIndex = middleIndex + 1;
            }
        }

        return 0.0;
    }
}
