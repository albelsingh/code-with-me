package org.java.streamApi;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class StreamAPICode {

    public List<Integer> calculateSquare(List<Integer> list){

        return list.stream().map(x->x*x).collect(Collectors.toList());
    }

    public List<String> findWords(List<String> wordList){

        return wordList.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
    }

    public List<String> sortList(List<String> wordList){

        return wordList.stream().sorted().collect(Collectors.toList());
    }

    public void printNumber(List<Integer> list){

        list.forEach(x-> System.out.println(x));
    }

    public int calculateSum(List<Integer> list){

        return list.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
    }

}
