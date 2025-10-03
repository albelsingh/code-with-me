package org.java.jdk8;

import java.util.Date;

@FunctionalInterface
public interface UPIPayment {
    String doPayment(String source, String destination);

    default double getCoupon(){
        return Math.random();
    }

    default String scanAndPay(){
        return "Payment is successful";
    }
    default Date datePattern(){
        return new Date();
    }
}
