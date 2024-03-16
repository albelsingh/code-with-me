package org.java.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmpAddress {
    int pinCode;

    public EmpAddress(int pincode){
        this.pinCode=pincode;
    }

    public int getPinCode() {
        return pinCode;
    }
}
