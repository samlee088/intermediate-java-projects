package group1.task6;
import java.util.ArrayList;
import java.util.List;
import group1.task6.Card;

public class Hand {
    private List<Card> cards;
    private int score;

    public Hand() {
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        if (card.getValue() == 1) {
            score += (score + 11 <= 21) ? 11 : 1;
        }
    }

    public int getScore() {
        return score;
    }
    public List<Card> getCards() {
        return cards;
    }

    public void print() {
        for (Card card: cards) {
            System.out.println(card.getSuit() + ", " + card.getValue());
        }
    }
    
}
