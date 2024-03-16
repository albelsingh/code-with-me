package org.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate {
    String name;
    int age;

    public static String validate(Candidate cand) {
        try {
            if (cand.getAge() < 18) {
                throw new NotEligibleForVoting("You are not eligible for voting " + cand.getName());
            } else
                return "You are eligible for voting";
        } catch (NotEligibleForVoting e) {
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        Candidate albel = new Candidate("Albel", 18);
        Candidate xyz = new Candidate("xyz", 15);
        System.out.println(validate(xyz));
    }
}
