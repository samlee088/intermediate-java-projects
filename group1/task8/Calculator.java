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

    public void run() {

       

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
                    System.out.println("Please enter in a new number");
                    input = (double) scanner.nextInt();
                    stack.add(input);
                    break;
                case 2:
                    System.out.println("\n Operation");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    operation(choice);
                    break;
                case 3:
                    clearCalc();
                    System.out.println("Calculator has been cleared");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    private void clearCalc() {
        stack.clear();
    }

    private void operation(int choice) {
        double second;
        double first;
        double result;

        if(stack.size() < 2) {
            System.out.println("Not enough digits entered");
            return;
        }
       
        second = stack.pop();
        first = stack.pop();
     
        switch (choice) {
            case 1: 
                result = first + second;
                break;
            case 2:
                result = first - second;
                break;
            case 3:
                result = first * second;
                break;
            case 4:
                if(second == 0) {
                    System.out.println("Unable to divide by 0");
                    return;
                }
                result = first / second;
                break;
            default:
                result = 0;
                break;
            
            
        }
        System.out.println("Results: " + result);
        stack.push(result);
    }
    

    

 

    
}
