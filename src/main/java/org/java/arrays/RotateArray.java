package org.java.arrays;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class RotateArray {
    public static int[] reverseArray(int[] arr){
        int j=arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            j--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr =new int[]{1,2,3,4,5,6,7};
        int k=3;
        //k=3 o/p={5,6,7,1,2,3,4}
        //4,3,2,1 - 7,6,5 => 5,6,7,1,2,3,4
        //System.out.println(Arrays.binarySearch(arr,1));
        System.out.println();
        int[] drr=new int[arr.length];
        AtomicInteger j= new AtomicInteger();
        Arrays.stream(RotateArray.reverseArray(Arrays.copyOfRange(arr,0,arr.length-k))).forEach(i->drr[j.getAndIncrement()]=i);
        Arrays.stream(RotateArray.reverseArray(Arrays.copyOfRange(arr,arr.length-k,arr.length))).forEach(i->drr[j.getAndIncrement()]=i);
        System.out.println(Arrays.toString(drr));
        Arrays.stream(RotateArray.reverseArray(drr)).forEach(System.out::println);

    }

}
