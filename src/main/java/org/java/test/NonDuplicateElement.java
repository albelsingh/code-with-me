package org.java.test;

import java.util.*;
import java.util.stream.Stream;

public class NonDuplicateElement {
    int[] arr = {1,2,3,4,2,1,5,6,6}; //3,4,5

    public int findSum() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++){
            int find=0;
            for(int j=i;j<arr.length;j++){
                if(arr[i] == arr[j])
                    find=1;
            }
            if(find==1){
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(i->i).sum();
    }

    int brr[]={3,5,7,9,10,2,1,20};
    //Result: Find Non Duplicate Element and sum of them
}
