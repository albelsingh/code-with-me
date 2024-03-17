package org.java.immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmpAddress {
    int pinCode;
    String city;

    public EmpAddress(String city,int pincode) {
        this.city=city;
        this.pinCode = pincode;
    }
}
