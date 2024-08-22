package group1.task6;

import java.util.Scanner;

class UserPlayer extends Player {
    static private Scanner input = new Scanner(System.in);
    private int balance;

    public UserPlayer(int balance, Hand hand) {
        super(hand);
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public int placeBet(int amount) {
        if (amount > balance) {
            throw new Error("Insufficient funds");
        }
        balance -= amount;
        return amount;
    }

    public void receiveWinnings(int amount) {
        balance += amount;
    }

    public boolean makeMove() {
        if (this.getHand().getScore() > 21) {
            return false;
        }
        // read user input
        System.out.print("Draw card? [y/n] ");
        String move = input.nextLine();
        return move.equals("y");
    }
    
}
