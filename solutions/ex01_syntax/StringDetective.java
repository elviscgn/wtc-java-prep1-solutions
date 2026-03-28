package ex01_syntax;

import java.util.Arrays;

public class StringDetective {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(countVowels("ello"));
        System.out.println(reverseWords("Hello how are you"));
        System.out.println(capitaliseEachWord("HELLO"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] s_arr = s.toCharArray();
        char[] c_arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            c_arr[i] = s_arr[s.length()-1-i];
        }

        System.out.println("s_arr "+ Arrays.toString(s_arr));
        System.out.println("c_arr " + Arrays.toString(c_arr));


        return Arrays.equals(s_arr, c_arr);
    }

    public static int countVowels(String s) {
        s = s.toLowerCase();
        char[] s_arr = s.toCharArray();
        int vowels = 0;

        for (char a: s_arr) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                vowels++;
            }
        }

        return vowels;
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        String[] revArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
             revArr[i] = arr[arr.length-1-i];
        }

        return String.join(" ", revArr);
    }

    public static String capitaliseEachWord(String s) {
        s = s.toLowerCase();
        String[] arr = s.split(" ");
        String[] nArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
             nArr[i] = arr[i].substring(0,1).toUpperCase() + arr[i].substring(1);
        }

        return String.join(" ", nArr);
    }
    }
