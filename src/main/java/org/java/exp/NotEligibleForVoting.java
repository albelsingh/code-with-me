package org.java.exp;

public class NotEligibleForVoting extends RuntimeException{

    public NotEligibleForVoting(String message){
        super(message);
    }
}
