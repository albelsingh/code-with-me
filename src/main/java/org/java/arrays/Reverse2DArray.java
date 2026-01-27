package org.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Reverse2DArray {
    static int M = 3;
    static int N = 3;
    //[{1, 2, 3},
    //  {4, 5, 6},
    //  {7, 8, 9}]

    //{9 8 7},
    //{6 5 4},
    //{3 2 1 }
    static void reverseArray(int arr[][])
    {

        // Traverse each row of arr[][]
        for (int i = 0, k=M-1; i < M-1; i++,k--) {

            // Initialise start and end index
            int start = 0; //0 1 2
            int end = N-1; //2 1 0

            // Till start < end, swap the element
            // at start and end index
            while (start <= M-1 && end >= 0) {
                int temp;
                // Swap the element
                if(i != k) {
                    temp = arr[i][start];
                    arr[i][start] = arr[k][end];
                    arr[k][end] = temp;
                }else if(i==k && start < end) {
                    temp = arr[i][start];
                    arr[i][start] = arr[k][end];
                    arr[k][end] = temp;
                }

                // Increment start and decrement
                // end for next pair of swapping
                start++;
                end--;
            }
        }

        // Print the arr[][] after
        // reversing every row
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] brr= {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        reverseArray(brr);
        System.out.println("----------------");
      /*  int count=1;
        int i=0;
        int j=0;
        for(i=0;i<arr[0].length;i++){
            for(j=0;j<arr[i].length;j++){
               arr[i][j]=count++;
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        arr.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }});
        arr.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }});
        arr.add(new ArrayList<Integer>() {{
            add(7);
            add(8);
            add(9);
        }});

        // Reverse the rows in the array using a loop and ArrayList
        for (int i = 0; i < arr.size(); i++) {
            Collections.reverse(arr.get(i));
        }

        // Print the reversed array
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
