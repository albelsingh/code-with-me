package org.java.util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CapProblem {
 //u1 showid s3
    public static ArrayList<String> getUsersWhoViewedTopShows(HashMap<String, List<String>> userToShowsMap,
                                                       HashMap<String,Integer> showsToView) {
       Integer count=0;
       String userId="";
        Iterator<Map.Entry<String, List<String>>> iterator = userToShowsMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            List<String> listOfShows = next.getValue();
            String user = next.getKey();
            for(String show:listOfShows) {
                Integer views=showsToView.get(show);
                if(views>count){
                    count=views;
                    userId=user;
                }
            }
        }
        System.out.println(userId+" "+count);
        return null;
    }

    public static void main(String[] args) {
        List<String> listOfShows1=Arrays.asList("s1","s2","s3");
        List<String> listOfShows2=Arrays.asList("s1","s2","s4");
        List<String> listOfShows3=Arrays.asList("s2","s3","s4");
        HashMap<String,List<String>> userShow=new HashMap<>();
        userShow.put("u1",listOfShows1);
        userShow.put("u2",listOfShows2);
        userShow.put("u3",listOfShows3);
        HashMap<String,Integer> showViews=new HashMap<>();
        showViews.put("s1",100);
        showViews.put("s2",300);
        showViews.put("s3",500);
        showViews.put("s4",800);
        getUsersWhoViewedTopShows(userShow,showViews);
        //Public ArrayList<String> getUsersWhoViewedTopShows(HashMap<String, List<String>> userToShowsMap, HashMap<String,Integer>> showsToView) {}
    }
}
