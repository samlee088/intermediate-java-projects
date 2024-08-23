package group1.task8;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private Stack<Double> stack;
    private Scanner scanner;
    

    public Calculator() {
        this.stack = new Stack<>();
        this.scanner = new Scanner(System.in);
    }

    private void run() {

       

        while(true) {

            System.out.println("\n Choice");
            System.out.println("1. Add Number");
            System.out.println("2. Choose Operation");
            System.out.println("3. Clear Calculator");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            double input;

            switch(choice) {
                case 1:
                    input = scanner.nextInt();
                    stack.add(input);
                case 2:
                    System.out.println("\n Operation");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.print("Enter your choice: ");
                    input = scanner.nextInt();

                case 3:
                    clearCalc();
                    System.out.println("Calculator has been cleared");
                default:
                    System.out.println("Please enter a valid option")
            }
        }
    }

    private void clearCalc() {
        stack.clear();
    }

    private void operation(int choice) {
        
        double second = stack.pop();
        double first = stack.pop();
        double result;

        switch (choice) {
            case 1: 
                result = first + second;
            case 2:
                result = first - second;
            case 3:
                result = first * second;
            case 4:
                result = first / second;
            default:
                result = 0;
            
            
        }
        stack.push(result);
    }
    

    

 

    
}
