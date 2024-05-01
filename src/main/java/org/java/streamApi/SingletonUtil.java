package org.java.streamApi;

public class SingletonUtil {
    private static volatile SingletonUtil singletonUtil;
    private SingletonUtil(){

    }
    public static SingletonUtil getSingletonUtil(){
        if(singletonUtil ==null){
            synchronized (SingletonUtil.class){
                if(singletonUtil ==null){
                    singletonUtil=new SingletonUtil();
                }
            }
        }
        return singletonUtil;
    }

    public static void main(String[] args) {
        SingletonUtil s1=SingletonUtil.getSingletonUtil();
        SingletonUtil s2=SingletonUtil.getSingletonUtil();
        System.out.println(s1.hashCode()+" - "+s2.hashCode());
    }
}
