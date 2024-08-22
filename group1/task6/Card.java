package group1.task6;

enum CardSuit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

public class Card {
    private final CardSuit suit;
    private final int value;

    public Card(CardSuit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }
    
    public void print() {
        System.out.println(getSuit() + " " + getValue());
    }
}

