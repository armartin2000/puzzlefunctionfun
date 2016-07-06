package recursionfun;

/**
 * Created by amartinez on 7/5/16.
 */
public class PrintMultiplicationTable {

    public static void main(String[] args) {
        Integer multiplicand = 5;
        Integer numMulitpliers = 7;
        System.out.print(" |\t");
        for(int j=multiplicand;j<=numMulitpliers;j++){
            System.out.print(j + "|\t");
        }
        System.out.println("");
        multiplicationTable(multiplicand,numMulitpliers);
    }

    public static void multiplicationTable(Integer start, Integer size) {
        loop(start,size, start);
    }

    public static void loop(Integer multiplicand, Integer numMultipliers, Integer baseMultiplicand){
        if(multiplicand > numMultipliers){
            return;
        } else {
            singleRowofNProducts(multiplicand, numMultipliers, baseMultiplicand);
            loop(multiplicand + 1, numMultipliers, baseMultiplicand);
        }
    }

    public static void singleRowofNProducts(Integer multiplicand, Integer numMultipliers, Integer baseMultiplicand) {
        StringBuilder builder = new StringBuilder(multiplicand + "| ");
        for(int i=baseMultiplicand;i<=numMultipliers;i++){
            builder.append(multiplicand*i + "|\t");
        }
        System.out.println(builder.toString());
    }
}
