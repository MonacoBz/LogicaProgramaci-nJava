package codewars;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       System.out.println(removeBang("!!!Hi !!hi!!! !hi"));
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
    /*
    Complete the method/function so that it converts dash/underscore delimited words into camel casing.
    The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
    The next words should be always capitalized.
    Examples
    "the-stealth-warrior" gets converted to "theStealthWarrior"
    "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
    "The_Stealth-Warrior" gets converted to "TheStealthWarrior"
    */
    private static String toCamelCase(String s){
        if(s.isEmpty())return "";
        String [] newS = s.split("[-_]");
        String result = "";
        if(s.substring(0,2).matches("[-_][A-Z]")||s.substring(0,1).matches("[a-z]|[A-Z]"))result+=newS[0];
        else if(s.substring(0,2).matches("[-_][a-z]"))result+=newS[0].substring(0,1) + newS[0].substring(1,newS[0].length()-1);

        for (int i = 1; i < newS.length ; i++) {
            result+=newS[i].substring(0,1).toUpperCase() + newS[i].substring(1,newS[i].length());
        }
        return result;
    }
    /*Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements,
    with the same multiplicities (the multiplicity of a member is the number of times it appears).
    "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
    Examples
    Valid arrays
    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
    Invalid arrays
    If, for example, we change the first number to something else, comp is not returning true anymore:
    a = [121, 144, 19, 161, 19, 144, 19, 11]
    b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
    comp(a,b) returns false because in b 132 is not the square of any number of a.
*/
    private static boolean comp(int[] a, int[] b){
        if (a == null || b == null || a.length != b.length) return false;

        Map<Integer, Integer> freqA = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();

        for (int num : a) {
            int square = num * num;
            freqA.put(square, freqA.getOrDefault(square, 0) + 1);
        }

        for (int num : b) {
            freqB.put(num, freqB.getOrDefault(num, 0) + 1);
        }

        return freqA.equals(freqB);
    }

    /*
    Remove all exclamation marks from the end of words. Words are separated by a single space. There are no exclamation marks within a word.
    Examples
    "Hi!" --> "Hi"
    "Hi!!!" --> "Hi"
    "!Hi" --> "!Hi"
    "!Hi!" --> "!Hi"
    "Hi! Hi!" --> "Hi Hi"
    "!!!Hi !!hi!!! !hi" --> "!!!Hi !!hi !hi"*/
    private static String removeBang(String str){
        if(str.isEmpty())return "";
        String [] strA = str.split(" ");
        if (strA.length==1)return strA[0].replaceAll("[A-Za-z]{0}!+","");
        String result = "";
        for(String var : strA){
            result+=var.replaceAll("!+$","") + " ";
        }
        result = result.substring(0,result.length()-1);
        return result;
    }
}

