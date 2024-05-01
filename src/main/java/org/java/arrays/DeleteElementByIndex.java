package org.java.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DeleteElementByIndex {
    /**
     * here is an array {1,2,3,4,5,1,2,3) Write Java method to delete 6th element in this array
     *
     */
    public static int [] deleteElement(int[] arr,int index){

       /* int[] arr_new = new int[arr.length-1];
        for(int i=0, k=0;i<arr.length;i++){
            if(i!=index){
                arr_new[k]=arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));
        return arr_new;*/

        System.out.println("Whole array :" + Arrays.toString(arr));
        int count =0;
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                count++;

                // shifting elements
                for(int k = i; k < arr.length - 1; k++){
                    arr[k] = arr[k+1];
                }
                i--;
                break;
            }
        }

        System.out.print("After Deletion :" );
        for(int i = 0; i < arr.length-count; i++){
            System.out.print(" " + arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] array=new int[]{1,2,3,4,5,1,2,3}; //4
        //System.out.println(Arrays.toString(deleteElement(array,5)));
        int [] brr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};
        Set<Integer> set=new HashSet<>();
        Arrays.stream(brr).filter(i->!set.add(i)).forEach(System.out::println);
        System.out.println();


    }
}
