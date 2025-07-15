package leetcode;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


    }
    /*
    392
    Is subsequence
    Dados dos strign(s y t), retornar true si s es una subsecuencia de t o falso si no
    "ace" es una dubseqeuncia de "abcde"
    pero "aec" no
    pendiente
     */
    private static boolean isSubsequence(String s, String t){
        if(s.isEmpty())return true;
        else if(t.isEmpty())return false;
        else if(s.length()==1&&t.length()==1||s.length()==1)return t.contains(s);
        char[] sC = s.toCharArray();
        int j=0;
        for (int i = 0; i <t.length(); i++) {
            if(sC[j]==t.charAt(i))j++;
        }
        return j==sC.length;
    }
    /*
    283
    Move Zeroes
    dado un arreglo de enteros, mover todos los 0's al final del arreglo, mientras se mantiene
    el order del arreglo
     */
    private static void moveZeros(int [] nums){
        if(nums.length==1)System.out.println(Arrays.toString(nums));
        else {int aux=0;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]==0)nums[i]=-1;
            else aux++;
        }
        int []mZ=new int[nums.length];
        for (int i = 0,j=0; i <nums.length; i++) {
            if(nums[i]!=-1)mZ[j++]=nums[i];
        }
        for (int i = aux; i <nums.length ; i++) {
            mZ[i]=0;
        }
        System.out.println(Arrays.toString(mZ));}
    }
    /*
    1768
    Este metodo combina Strings dependinedo su tamaño ejemplo
    word1="ab",word2?="pqrs"
    resultado=apbqrs
     */
    private static String mergeStringsAlternatly(String word1,String word2){
        int max= Math.max(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <max; i++) {
            sb.append(String.valueOf((i<word1.length())?word1.charAt(i):""))
                    .append(String.valueOf((i<word2.length())?word2.charAt(i):""));
        }
        return sb.toString();
    }
    /*
    151
    Este metodo regresa una cadena al revés hola a todos = todos a hola
     */
    private static String reverseWords(String word){
        String [] words = word.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }

    /*
    1071
    Greates Common Divisor of Strings
    este metodo retosna los caracteres que dividen a ambas Strings
    él código no es mío, pero trabaja con el MCD
     */
    private static String greatesCommonDivisorOfStrings(String str1,String str2){
        if(!(str1+str2).equals(str2+str1))return "";
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    /*
    1431
    Kids with the greatest number of candies
    Retornar una lista de booleanos para ver que niños tinees mas dulces
     */
    private static  List<Boolean> kidsWithCandies(int[] candies,int extraCandies){
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies)
                .mapToObj(c-> c+extraCandies>=max)
                .toList();
    }
    /*
    605
    Can Place Flowers
    Dado un arreglo de flores donde 0 es empty y 1 no empty retornar verdadero o falso dependiendo
    si se puede plantar el numero de plantas solicitadas, recordar que no se pueden plantar plantas juntas
     */
    private static boolean canPlaceFlowers(int[]flowerbed,int n){
        if(flowerbed.length==0)return false;
        if(flowerbed.length==1&&flowerbed[0]==0&&n==1||n==0)return true;
        for (int i = 0; i <flowerbed.length ; i++) {
            if(flowerbed[i]==1) continue;
            else if(i==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }else if(i==flowerbed.length-1&&flowerbed[i-1]==0){
                flowerbed[i]=1;
                n--;
            }
            else if(i-1>=0&&flowerbed[i-1]==0&&i+1<flowerbed.length&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n<=0;
    }
    /*
    345
    Reverse Vowels of a String
    cambiar las posiciones de las vocales, pueden estan en mayuscula minuscula
    "IceCreAm"="AceCreIm"
     */
    private static String reverseVowels(String s){
        if(s.isEmpty()||s.length()==1)return s;
        String vocales = "AEIOUaeiou";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i <s.length() ; i++) {
            if(vocales.contains(String.valueOf(s.charAt(i))))stack.add(s.charAt(i));
        }
        StringBuilder resultado = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(vocales.contains(String.valueOf(s.charAt(i)))) resultado.append(stack.pollLast());
            else resultado.append(s.charAt(i));
        }
        return resultado.toString();

    }
    /*
    238
    Product of Array Except Self
    Sacar el producto de cada numero en el arreglo excepto el mismo
    [1,2,3,4]=[24,12,8,6]
    if(i==0){
                for (int j = i+1; j <nums.length ; j++) {
                    product*=nums[j];
                }
                products[i]=product;
            }
            else if(i==nums.length-1){
                for (int j = nums.length-1; j >=0 ; j++) {
                    product*=
                }
            }
     */
    private static int[] productOfArray(int[] nums) {
       int n = nums.length;
       int[] left = new int[n];
       int[] right = new int[n];
       int[] result = new int[n];

       left[0] = 1;
       for (int i = 1; i < n; i++) {
           left[i] = left[i - 1] * nums[i - 1];
       }

       right[n - 1] = 1;
       for (int i = n - 2; i >= 0; i--) {
           right[i] = right[i + 1] * nums[i + 1];
       }

       for (int i = 0; i < n; i++) {
           result[i] = left[i] * right[i];
       }
       return result;
   }

   /*
   334
   Increasing Triplet Subsequence
   Dado un arreglo de enteros retornar true si existe un triplete de indices (i,j,k)
   ejemplo nums[]=[1,2,3,4,5] retorno: true
   por que existe un triplete de indices i<j<k is valid
   pendiente
    */
    private static boolean TripletSubsequence(int [] nums){
        int min = Arrays.stream(nums).min().getAsInt();
        int max= Arrays.stream(nums).max().getAsInt();
        if(min==max)return false;
        int i=0,j=1,k=2;
        while(i<nums.length){
            if(nums[i]<nums[j]){
                int aux=k;
                int aux2=j;
                while(j<nums.length){
                    if(nums[j]<nums[k++])return true;
                    if(k<nums.length){
                        k=aux++;
                        j++;
                    }

                }
                k=aux;
                j=aux2;
            }
            else{
                while(j<nums.length){
                    if(nums[i]<nums[j++])break;
                }

            }
            i++;
            k++;
        }
        return false;
    }

}