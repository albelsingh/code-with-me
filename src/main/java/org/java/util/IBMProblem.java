package org.java.util;

public class IBMProblem {

    public static String reverse(String str){
        char[] chars=str.toCharArray();
        char temp;
        int j=str.length()-1;
        for(int i=0;i<str.length()/2;i++){
            temp =chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            j--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        String str="abaxyzzyxf";
        //System.out.println(reverse("abcd"));
        String temp="";
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                String subString=str.substring(i,j);
                String reverseStr=reverse(subString);
                if(subString.equalsIgnoreCase(reverseStr)){
                    if(temp.isEmpty())
                        temp=reverseStr;

                    if(temp.length()>reverseStr.length()){
                        System.out.println("----"+temp);
                        temp=reverseStr;
                    }
                }
            }
        }
        System.out.println("String is palindrome "+temp);
    }
}
