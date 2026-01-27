package org.java.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairDifference {
    // The function assumes that the array is sorted
    //Asked in Wissen Interview
    static boolean findPair(int arr[],int n)
    {
        int size = arr.length;

        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < size && j < size)
        {
            if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n))
            {
                System.out.println("Pair Found: "+
                        "( "+arr[i]+", "+ arr[j]+" )");
                return true;
            }
            else if (arr[j] - arr[i] < n)
                j++;
            else
                i++;
        }

        System.out.print("No such pair");
        return false;
    }

    public static void getPairs(int[] arr,int diff){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int rem=diff-arr[i];
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
            if(map.containsKey(rem)){
                int count=map.get(rem);
                for(int j=0;j<count;j++){
                    System.out.println("("+arr[i]+","+rem+")");
                }
            }
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        //find pairs of element whose diff is equal to n
        int arr[] = {1, 8, 30, 3, 40, 100};
        int n = 27;
        Arrays.sort(arr);
        findPair(arr,n);

        //find pairs of element whose sum is equal to m
        int brr[] = {1, 5, 7,-1};
        int m = arr.length;
        getPairs(brr,m);
    }
}
