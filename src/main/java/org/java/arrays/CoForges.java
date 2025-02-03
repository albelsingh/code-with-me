package org.java.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class CoForges {
    public String reverseString(String str) {
        char ch[] = str.toCharArray();
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            j--;
        }
        //return String.valueOf(ch);
        return new String(ch);
    }

    // Returns number of pairs in arr[0..n-1]
    // with sum equal to 'sum'
    public static void printPairs(int arr[], int n, int sum) {
        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // Traverse through all elements
        for (int i = 0; i < n; i++) {
            // Search if a pair can be formed with
            // arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);
                for (int j = 0; j < count; j++)
                    System.out.print("(" + rem + ", " + arr[i] + ")" + "\n");
            }
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }
    }

    public static void getPaire(int arr[], int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.stream(arr).forEach(i -> {
            int rem = sum - i;
            if (hashMap.containsKey(rem)) {
                int count = hashMap.get(rem);
                for (int j = 0; j < count; j++)
                    System.out.println("Paire is (" + rem + "," + i + ")");
            }
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        });
    }

    public static void main(String[] args) {
        CoForges test = new CoForges();
        String input = "Bangalore";
        String str = test.reverseString(input);
        System.out.println("String is :: " + input + ", After reverse :: " + str);
        int arr[] = {1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;
        printPairs(arr, n, sum);
        getPaire(arr, 6);
    }
}

