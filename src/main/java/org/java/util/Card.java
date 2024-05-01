package org.java.util;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Card {
    enum Suit {
        // must be in increasing order.
        Spades, Diamonds, Clubs, Hearts
    }

    static final Suit[] SUITS = Suit.values();

    private final int number;
    private final Suit suit;

    /*
     * Randomly creates a card numbered 1 to 13 (ace = 1!) and labelled "Hearts","Clubs","Diamonds" or "Spades".
     */
    public Card() {
        Random rand = new Random();
        suit = SUITS[rand.nextInt(SUITS.length)];
        number = rand.nextInt(13) + 1;
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }

    static final String[] NAMES = ",Ace,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King".split(",");

    public String cardString() {
        assert number > 1 && number < NAMES.length;
        return NAMES[number] + " of " + suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", suit=" + suit +
                '}';
    }
}
class PackOfCards {
    private final List<Card> cards;

    public PackOfCards(int size) {
        // note duplicates are possible, i.e. ever card could be the same.
        cards = IntStream.range(0, size)
                .mapToObj(n -> new Card())
                .collect(Collectors.toList());
    }

    public Card findLargest() {
        return cards.stream().max(Comparator.comparing(Card::getNumber)
                .thenComparing(Card::getSuit)).get();
    }

    @Override
    public String toString() {
        return "PackOfCards{" +
                "cards=" + cards +
                '}';
    }

    public static void main(String[] args) {
        PackOfCards pack=new PackOfCards(52);
        System.out.println(pack.findLargest());
    }
}
