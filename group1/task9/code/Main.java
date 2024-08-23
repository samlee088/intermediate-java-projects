package group1.task9.code;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 11;

        while(choice > 10 || choice <= 0) {
            System.out.println("Please choose a number between 1 and 10");
            choice = scanner.nextInt();
        }

        

        
    }
}
