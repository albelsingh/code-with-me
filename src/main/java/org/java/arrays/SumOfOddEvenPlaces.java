package org.java.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfOddEvenPlaces {
    /**
     *
     * 214365
     * Odd places 2*4*6 48
     * Even places 1*3*5 15
     * Sum 48 + 15 63
     *
     */
    public static int getSum(String [] arr){
        int even=1;
        int odd=1;
        for(int i=0;i<arr.length;i++){
            if(i%2 == 0){
                even=even* Integer.parseInt(arr[i]);
            }else{
                odd=odd*Integer.parseInt(arr[i]);
            }
        }
        return odd+even;
    }
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        String num="214365";
        num=kb.next();
        String [] a= num.split("");
        System.out.println(getSum(a));

    }
}
