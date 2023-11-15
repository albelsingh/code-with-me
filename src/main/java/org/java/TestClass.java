package org.java;

import java.util.HashMap;

public class TestClass {


    Integer[] arr = {2, 6, 4, 10, 8};
    Integer target = 12;
    //

    public String reverseString(String str) {
        char ch[] = str.toCharArray();
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            j--;
        }
        return String.valueOf(ch);
    }

    // Returns number of pairs in arr[0..n-1]
    // with sum equal to 'sum'
    static void printPairs(int arr[], int n, int sum) {

        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for (int i = 0; i < n; i++) {

            // Search if a pair can be formed with
            // arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);

                for (int j = 0; j < count; j++)
                    System.out.print("(" + rem + ", "
                            + arr[i] + ")"
                            + "\n");
            }
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }
    }
}
