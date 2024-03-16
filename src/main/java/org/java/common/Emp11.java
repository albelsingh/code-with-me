package org.java.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class Emp11 {
    String name;
    EmpAddress address;

    public Emp11(String name,EmpAddress address){
        this.name=name;
        EmpAddress tempAdd=new EmpAddress(address.getPinCode());
        this.address=tempAdd;
    }

    public String getName() {
        return name;
    }

    public EmpAddress getAddress() {
EmpAddress tempAdd=new EmpAddress(address.getPinCode());

        return address;
    }

    public static void main(String[] args) {
        EmpAddress add=new EmpAddress(560076);
        Emp11 e=new Emp11("Neha",add);
        System.out.println(e.getName()+" "+e.getAddress().getPinCode());

        List<Integer> list=Arrays.asList(1,1,2,3,5,5); //2
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i< list.size();i++){
            if(map.containsKey(list.get(i))){
                map.put(list.get(i),(map.get(list.get(i)))+1);
            }else{
                map.put(list.get(i),1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()==1){
                System.out.println(m.getKey());
                break;
            }
        }


    }
}
