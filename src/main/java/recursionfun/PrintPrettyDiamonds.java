package recursionfun;

import java.util.function.Function;

/**
 * Created by amartinez on 7/5/16.
 */
public class PrintPrettyDiamonds {
    public static void main(String[] args) {
        System.out.println("Printing Diamond: <width=12>");
        PrintPrettyDiamonds.renderNWideDiamond(12);
    }

    public static void renderNWideDiamond(int n) {
        int startValue = (n%2 == 0) ? 2 : 1;
        loop(plus,n, n, startValue);
        loop(minus, n, n-2,n-2);
    }

    public static void loop(Function<Integer,Integer> f, Integer max, Integer loops, Integer numChars) {
        if (loops > 0) {
            printFormattedDiamondCharSeq(max,numChars);
            loop(f,max,loops - 2, f.apply(numChars));
        }
    }

    protected static void  printFormattedDiamondCharSeq(Integer width, Integer num) {
        int padding = (int)(width - num)/2;
        pad(padding);
        stars(num);
        pad(padding);
        System.out.println("");

    }

    protected static void pad(Integer n) {
        for(int k = 0; k < n; k++){
            System.out.print(" ");
        }
    }

    protected static void stars(Integer n) {
        for(int k = 0; k < n; k++){
            System.out.print("*");
        }
    }

    protected static Function<Integer,Integer> plus = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer value) {
            return value + 2;
        }
    };
    protected static Function<Integer,Integer> minus = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer value) {
            return value - 2;
        }
    };
}
