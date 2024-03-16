package org.java.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Test101 {
    public static void main(String[] args) {
        int arr[] = new int[]{6,1,8,0,3,2,0,1};
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }
            else{
                i++;
            }
        }
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+",");
        }
    }
}
