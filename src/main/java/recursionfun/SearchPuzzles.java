package recursionfun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by amartinez on 7/5/16.
 */
public class SearchPuzzles {

    public static void main(String[] args) {





    }

    public static void main( String args[]) {

        List<Integer> values = new ArrayList<Integer>();
        values.add(9);values.add(1);
        values.add(9);values.add(4);
        values.add(4);values.add(9);
        values.add(1);values.add(1);
        values.add(4); values.add(4);

        Integer result = SearchPuzzles.findIntegerHighestOccurances(values);
        System.out.println("Max occurance was the integer: " + result);

        List<Integer> numberList = new ArrayList<Integer>();
        numberList.add(1);
        numberList.add(12);
        numberList.add(5);
        numberList.add(-1);
        numberList.add(16);

      //  int max = SearchPuzzles.maxIntInList(numberList);
        //System.out.println("Max number is: " + max);

        int[] numbers = {1,4,3,6,5,4,1,6,5};

        int unique = SearchPuzzles.uniqueInteger(numbers);

        System.out.println("Unique number is: " + unique);
        String sentence = "this is a test sentence to capitalize words";

        System.out.println(SearchPuzzles.capitalizeEveryNthWord(sentence,1,2));

        System.out.println(SearchPuzzles.isPrime(4));

        String b = "A nut for a jar of tuna";
        System.out.println("String is palindrome: " + isPalindrome(b));

        System.out.println("Common Genomes: " + commonGeneticGenomes("ABEC","ABCD"));

        System.out.println(findLongestPalindromeInValue("gbollobafa"));
        System.out.println(findLongestPalindromeInValue("gbollof"));
        System.out.println(findLongestPalindromeInValue("fffzklffaf"));
    }

    /*public static int maxIntInList(List<Integer> source) {


        if(CollectionUtils.isEmpty(source)){
            throw new IllegalArgumentException("List has no elements");

        } else {

            //list has elements, return max integer in list

            int[] primitives = ArrayUtils.toPrimitive(source.toArray(new Integer[source.size()]));

            return NumberUtils.max(primitives);

        }
    }*/

    public static Boolean isPrime(Integer n) {

        if(n<=1){
            return false;
        }
        for(int i=2;i<n;i++){
            if((n%i) == 0){
                return false;
            }
        }
        return true;
    }



    public static int uniqueInteger(int[] numbers) {


        if( numbers == null || numbers.length <= 0){
            throw new IllegalArgumentException("no data is list...");
        }

        Map<Integer,Integer> trackNumbers = new HashMap<Integer,Integer>();
        Map<Integer,Integer> resultMap = new HashMap<Integer,Integer>();

        int length = numbers.length;

        for(int i=0;i<length;i++){

            Integer value = numbers[i];

            if(!trackNumbers.containsKey(value)){
                //does not exist add to tracking Map
                trackNumbers.put(value, value);
                //add to result map too
                resultMap.put(value,value);
            } else {
                //exists in Map, remove from resultMap
                resultMap.remove(value);
            }

        }

        //get the keys, should only have one unique key/value
        Set<Integer> keys = resultMap.keySet();

        if( keys.size() != 1){
            throw new IllegalArgumentException("unique number not found in provided data...");
        }

        for(Integer key : keys) {
            return resultMap.get(key);
        }

        return 0;
    }


    public static Integer findIntegerHighestOccurances(List<Integer> values) {

        int maxCount = 0;
        int keyMaxValue = 0;

        Map<Integer,Integer > history = new HashMap<Integer, Integer>();

        for(Integer key : values) {

            if (history.containsKey(key)) {
                Integer incCount = history.get(key) + 1;
                history.put(key, incCount);

                //store value with the highest number
                if (incCount > maxCount) {
                    keyMaxValue = key;
                    maxCount = incCount;
                }

            } else {
                history.put(key, 1);
            }
        }


        return keyMaxValue;
    }

    // Take a single-spaced <sentence>, and capitalize every <n> word starting with <offset>.
    public static String capitalizeEveryNthWord(String sentence, Integer offset, Integer n) {

        StringTokenizer strTok = new StringTokenizer(sentence," ");

        int capIndex = offset;
        int cursor = 0;
        StringBuilder builder = new StringBuilder();
        while(strTok.hasMoreTokens()){
            String currentWord = strTok.nextToken();
            if(cursor == capIndex){
                String firstLetter = String.valueOf(currentWord.toCharArray()[0]);
                builder.append(currentWord.replaceFirst(firstLetter,firstLetter.toUpperCase()) + " ");
                capIndex += n;
            } else {
                builder.append(currentWord + " ");
            }
            cursor++;
        }

        return builder.toString().trim();
    }

    public static boolean isPalindrome(String string){
        if(string != null) {
            string = string.replaceAll(" ","");
            StringBuilder reverse = new StringBuilder(string).reverse();
            return reverse.toString().toLowerCase().equals(string.toLowerCase());
        }
        return false;
    }

    public static String commonGeneticGenomes(String base, String subject) {

        StringBuilder builder = new StringBuilder();

        char[] newBase = base.toCharArray();
        Arrays.sort(newBase);
        char[] newSubject = subject.toCharArray();
        int len = newBase.length;
        for(int i=0;i<len;i++) {
            char c = newSubject[i];
            int j = Arrays.binarySearch(newBase, newSubject[i]);
            if(j>=0){
                builder.append(newBase[j]);
            }
        }
        return builder.toString();
    }

    public static String findLongestPalindromeInValue(String value) {
        int valueStringLen = value.length();
        if(valueStringLen < 1)
            throw new IllegalArgumentException("Invalid string argument");


        int maxIndexStart = 0; //the resulting beginning index of longest palindrome
        int maxCount = 0; // length of the longest palindrome

        char[] subject = new StringBuilder(value).reverse().toString().toLowerCase().toCharArray();
        char[] source = value.toLowerCase().toCharArray();

        //Go get'em tiger!! LOL
        for (int i = 0; i < valueStringLen; i++) {
            int sourceCursor = 0;
            do {
                if (subject[i] != source[sourceCursor])
                    sourceCursor++;
                else {
                    int remainingLen = valueStringLen - ((sourceCursor > i) ? sourceCursor : i);
                    int resultCount = getConsecutiveSequenceMatchCount(
                            String.valueOf(subject, i, remainingLen).toCharArray(),
                            String.valueOf(source, sourceCursor, remainingLen).toCharArray());
                    if (resultCount > maxCount) {
                        maxCount = resultCount;
                        maxIndexStart = i;
                    }
                    break;
                }

            } while (sourceCursor < valueStringLen);
        }

        //now return largest palindrome found
        return String.valueOf(subject, maxIndexStart, maxCount);
    }

    public static int getConsecutiveSequenceMatchCount(char[] subject, char[] source) {
        int result = 0;
        int len = source.length;
        for(int i=0;i < len;i++){
            if(subject[i] == source[i]){
                result++;
            }
            else {
                break;
            }
        }
        return result;
    }

}
