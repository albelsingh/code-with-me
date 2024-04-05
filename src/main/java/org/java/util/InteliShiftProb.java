package org.java.util;

public class InteliShiftProb {
    //Write a Java program to print all permutations of a given String.
    // For example, if given String is "GOD" then your program should print
    // all 6 permutations of this string, e.g. "GOD," "OGD," "DOG," "GDO,"
    // "ODG," and "DGO."
    static void printPermutation(String str, String ans)
    {
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            // Recursive call
            printPermutation(ros, ans + ch);
        }
    }


    public static void main(String[] args) {
        String str="GOD";
        printPermutation(str,"");

    }
}
