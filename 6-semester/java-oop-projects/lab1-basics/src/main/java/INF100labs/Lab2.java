package INF100labs;

import java.util.Arrays;
import java.util.Collections;

/**
 * Implement the methods findLongestWords, isLeapYear and isEvenPositiveInt.
 * These programming tasks was part of lab2 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/2/
 */
public class Lab2 {
    
    public static void main(String[] args) {
        // Call the methods here to test them on different inputs
        findLongestWords("Game", "Action", "Champion");
        System.out.println(isLeapYear(2022));  // false
        System.out.println(isLeapYear(1996));  // true
        System.out.println(isLeapYear(1900));  // false
        System.out.println(isLeapYear(2000));  // true
        System.out.println(isEvenPositiveInt(123456));
        System.out.println(isEvenPositiveInt(-2));
        System.out.println(isEvenPositiveInt(123));
    }

    public static void findLongestWords(String word1, String word2, String word3) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len3 = word3.length();
        int maxLen = Math.max(len1, Math.max(len2, len3));
        
        if(len1 == maxLen){
            System.out.println(word1);
        }
        if(len2 == maxLen){
            System.out.println(word2);
        }
        if(len3 == maxLen){
            System.out.println(word3);
        }
    }

    public static boolean isLeapYear(int year) {
    if (year % 400 == 0) {
        return true;
    }

    if (year % 100 == 0) {
        return false;
    }

    return year % 4 == 0;
}
    

    public static boolean isEvenPositiveInt(int num) {
        if(num>0 && num % 2 == 0) {
            return true;
        } 
        else {
            return false;
        }
    
    }

}
