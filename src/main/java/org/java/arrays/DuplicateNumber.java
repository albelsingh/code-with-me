package org.java.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
    static int[] removeDuplicates(int arr[]){
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int i=0; i<arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else{
                arr[i]=-1;
                count++;
            }
        }
        int j=arr.length-1;
        int i=0;
        while(i<j){
            if(arr[i]==-1){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }else{
                i++;
            }
        }
        Arrays.sort(arr,0,arr.length-count);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,2,3,4,4,5};
        int[] brr=removeDuplicates(arr);
        System.out.println(Arrays.toString(brr));
    }
}
