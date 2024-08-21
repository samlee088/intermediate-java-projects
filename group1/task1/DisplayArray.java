package group1.task1;
import java.util.Scanner;

public class DisplayArray {

    private Scanner scanner;

    public DisplayArray() {
        scanner = new Scanner(System.in);
    }
    public static void main(String [] args) {
        DisplayArray displayArray = new DisplayArray();
     
        displayArray.promptUser();
        
    }

    private void promptUser() {
        System.out.println("Please enter an 5 by 5 number of digits");
        int[][] array = new int[5][5];

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        sumRowsAndCols(array);
    }

    public static void sumRowsAndCols(int[][] array) {
        for(int iteration = 1; iteration >= 0; iteration --) {
            System.out.println("\n");

            for(int i = 0; i < array.length; i++) {

            int sumTemp = 0;
            for (int j = 0; j < array[i].length; j++) {
                sumTemp += iteration == 1 ? array[i][j]: array[j][i];
            }
            System.out.println(sumTemp + " ");
        }   
        }
    }
}