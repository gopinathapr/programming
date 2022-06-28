package com.prg.learning;


/* IMPORTANT: Multiple classes and nested static classes are supported */

//uncomment this if you want to read input.
//imports for BufferedReader

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner

        */
        // Write your code here
        Scanner s = new Scanner(System.in);
        String pattern = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        boolean result = true;
        char[] p = pattern.toCharArray();
        for (int i = 0; i < p.length - 1; i++) {
            if (i == 2 && !"AEIOUY".contains(p[i] + "")) {
                result = false;
                break;
            }
            if (i == 6) {
                continue;
            }
            int num = Character.getNumericValue(p[i]);
            int nextNum = Character.getNumericValue(p[i + 1]);
            if ((num + nextNum) % 2 != 0) {
                result = false;
                break;
            }
        }
        if (result) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}
