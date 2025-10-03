package org.java.jdk8;

public class Paytm implements UPIPayment{
    /**
     * @param source 
     * @param destination
     * @return
     */
    @Override
    public String doPayment(String source, String destination) {
        return "success";
    }

    //Optional override
    /**
     * @return
     */
    @Override
    public String scanAndPay() {
        return UPIPayment.super.scanAndPay();
    }
}
