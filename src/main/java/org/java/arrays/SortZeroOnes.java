package org.java.arrays;

import java.util.Arrays;

public class SortZeroOnes {
    private static void sortZeroAndOne(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int temp;
        while(i<j){
            if(arr[i] ==1){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }else {
                i++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        /*
        Input: N = 5, arr[ ] = {1,0,1,1,0}
        Output: {0,0,1,1,1}
        // Time Complexity : O(n)
        // Space Complexity : O(1)
         */
        int arr[]={1,0,1,1,0,1,1,0};
        sortZeroAndOne(arr);
    }
}
