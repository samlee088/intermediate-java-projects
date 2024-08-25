package group3.task6.code;

import java.util.Scanner;

import group3.task6.code.Employees.Receptionist;
import group3.task6.code.Hospital.Hospital;

public class HospitalOperations {
    Scanner scanner;

    public HospitalOperations() {
        scanner = new Scanner(System.in);
    }

    public void run(Hospital hospital) {
        

        while(true) {
            System.out.println("\n Please pick an operation");
            System.out.println("1. Create an receptionist");
            System.out.println("2. Create a doctor");
            System.out.println("3. Receptionist Working");
            System.out.println("4. Doctor Working");
            System.out.println("6. Add Pet to hospital records");
            System.out.println("7. Check In Pet");
            System.out.println("8. Doctor accept pet for visit");
            System.out.println("9. Treat Pet");
            System.out.println("10. Doctor finish visit");
            System.out.println("11. Check Out Pet");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    createAReceptionist(hospital);
            }
        }
    }

    private void createAReceptionist(Hospital hospital) {
        String receptionistName = scanner.next();
        if(hospital.getEmployees("receptionists").containsKey(receptionistName)) {
            System.out.println("Receptionists already added to database");
            return;
        }

        Receptionist receptionist = new Receptionist(receptionistName, 1);
        try{
            hospital.setReceptionists(receptionist);
            System.out.println("Able to save receptionist to hospital" + " receptionistName");
        } catch (Error e) {
            System.out.println("An error occurred with saving receptionist " + receptionistName + " " + e.getMessage());
        }
        

    }
}
