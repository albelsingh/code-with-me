package org.java.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public enum DeckofCards {
    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2);
    private final int value;
    DeckofCards(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

class PlayingCard implements Comparator<PlayingCard> {

    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public PlayingCard(int rank) {
        this.rank = rank;
    }

    @Override
    public int compare(PlayingCard o1, PlayingCard o2) {
        if(o1.getRank() < o2.getRank()){
            return o2.getRank();
        }else{
            return o1.getRank();
        }
    }

    public static void main(String[] args) {
        PlayingCard pl1=new PlayingCard(DeckofCards.KING.getValue());
        PlayingCard pl2=new PlayingCard(DeckofCards.QUEEN.getValue());
        List<PlayingCard> list=new ArrayList<>();
        list.add(pl1);
        list.add(pl2);
        System.out.println(list);
    }
}