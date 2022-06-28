package com.prg.learning;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().isValidPalindrome("A man, a plan, a canal: PanaMa"));
    }

    private boolean isValidPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                System.out.println("l++ " + l);
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                System.out.println("r--");
                r--;
            } else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                System.out.println("Not palindrome");
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
