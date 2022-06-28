package com.prg.learning;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        new Anagram().isAnagram("anagram", "nagaram");
    }

    private boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        System.out.println(sChars);
        System.out.println(tChars);
        return new String(sChars).equals(new String(tChars));
    }
}
