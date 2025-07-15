package codewars;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(digital_root(493193));
    }
    /*
    SquareDigits
    For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)
    Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)
     */
    private static int squareDigits(int n){
        StringBuilder result = new StringBuilder();
        String.valueOf(n)
                .chars()
                .forEach(c->  {
                    int v = Integer.valueOf(String.valueOf((char) c));
                    int square = v*v;
                    result.append(square);
                });
        return Integer.parseInt(result.toString());

    }
    /*
    Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').
    Examples:

    * 'abc' =>  ['ab', 'c_']
    * 'abcdef' => ['ab', 'cd', 'ef']
     */
    private static String[] stringSplit(String s){
        if(s.isEmpty())return new String[]{};
        int size = s.length();
        String [] result = (size%2==0)? new String[size/2] : new String[size/2+1];
        String chars = "";
        for(int i=0,j=0;i<size;i++){
            chars += s.charAt(i);
            if(chars.length()==2){
                result[j++] = chars;
                chars="";
            }
            else if(i+1 == size && chars.length() == 1){
                result[j]=chars+"_";
            }
        }
       return result;


    }

    /*
    Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:
    []                                -->  "no one likes this"
    ["Peter"]                         -->  "Peter likes this"
    ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
    ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
    ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 */
    public static String whoLikesIs(String ... names){
         return switch (names.length) {
            case 0 -> "no one likes this";

            case 1 -> names[0] + " likes this";

            case 2 -> names[0] + " and " + names[1] + " like this";

            case 3 ->  names[0] + ", " + names[1] + " and " + names[2] + " like this";

            default -> names[0] + ", " + names[1] + " and " + (names.length-2) + " others like this";
        };
    };

    /*
    A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).
    For example, take 153 (3 digits), which is narcissistic:
    1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    and 1652 (4 digits), which isn't:
    1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938*/
    public static boolean isNarcissistic(int number){
        String numberS = ""+number;
        int size = numberS.length();
        int sum = 0;
        for (int i = 0; i < size ; i++) {
            int n = Integer.parseInt(numberS.charAt(i)+"");
            sum += Math.pow(n,size);
        }
        return sum==number;
    }

    /*
    Digital root is the recursive sum of all the digits in a number.
    Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
    Examples
    16  -->  1 + 6 = 7
    942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
    132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
    493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2*/
    public static int digital_root(int n){
        String nS = ""+n;
        if(nS.length()==1)return n;
        int sum = 0;
        for ( int i = 0; i < nS.length() ; i++) {
            sum += Integer.parseInt(nS.charAt(i)+"");
        }
        return digital_root(sum);
    }
}

