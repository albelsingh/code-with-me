package org.java.common;

public class Bucket<T> {
    private T item;

    public void putInBucket(T item) {
        this.item = item;
    }

    public T fetchFromBucket() {
        return item;
    }
    public static void main(String[] args) {
        Bucket<String> bucket1 = new Bucket<String>();
        Bucket<Integer> bucket2 = new Bucket<Integer>();

        bucket1.putInBucket("Hello World!");
        bucket2.putInBucket(12345);

        System.out.printf(bucket1.fetchFromBucket());
        System.out.println();
        System.out.printf("%s",bucket2.fetchFromBucket());
    }
}
