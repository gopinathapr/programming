package com.prg.learning;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(new PalindromeCheck().validPalindrome("tebbem"));
    }

    public boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            if (chars[start] != chars[end]) {
                return checkPalindrome(s, start + 1, end) || checkPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
