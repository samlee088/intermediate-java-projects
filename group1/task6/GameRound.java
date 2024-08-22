package group1.task6;

import java.util.Scanner;

public class GameRound {
    static private Scanner input = new Scanner(System.in);
    private UserPlayer player;
    private Dealer dealer;
    private Deck deck;

    public GameRound(UserPlayer player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    private int getBetUser() {
        System.out.print("Enter a bet amount:");
        return input.nextInt();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.draw());
            dealer.addCard(deck.draw());
        }
        System.out.println("Player hand: ");
        player.getHand().print();
        Card dealerCard = dealer.getHand().getCards().get(0);
        System.out.println("Dealer's first card:");
        dealerCard.print();
    }
}
