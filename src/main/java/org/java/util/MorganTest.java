package org.java.util;

public class MorganTest {
    public static String compressStr(String str){
        String cStr="";
        int count=0;
        char ch=str.charAt(0);
        for(int i=0;i<str.length();i++){
            if(ch==str.charAt(i)){
                count++;
            }else{
                cStr=cStr+count+ch;
                ch=str.charAt(i);
                count=0;
                i--;
            }
        }
        cStr=cStr+count+ch;
        return cStr;
    }
    public static void main(String[] args) {
        String str="aabbccdddaa"; //
        //2a2b2c2d2a
        System.out.println(compressStr(str));
    }
}
