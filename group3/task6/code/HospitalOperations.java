package group3.task6.code;

import java.util.Map;
import java.util.Scanner;

import group3.task6.code.Employees.Doctor;
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
            System.out.println("5. Add Pet to hospital records");
            System.out.println("6. Check In Pet");
            System.out.println("7. Doctor accept pet for visit");
            System.out.println("8. Treat Pet");
            System.out.println("9. Doctor finish visit");
            System.out.println("10. Check Out Pet");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    createAReceptionist(hospital);
                case 2:
                    createADoctor(hospital);
                case 3:
                    doctorOnDuty(hospital);
                case 4:
                    receptionistOnDuty(hospital);
                case 5:

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
    private void createADoctor(Hospital hospital) {
        String doctorName = scanner.next();
        if(hospital.getEmployees("receptionists").containsKey(doctorName)) {
            System.out.println("Receptionists already added to database");
            return;
        }

        Doctor doctor = new Doctor(doctorName, 0);
        try{
            hospital.setDoctors(doctor);
            System.out.println("Able to save  to hospital" + " doctorName");
        } catch (Error e) {
            System.out.println("An error occurred with saving doctor " + doctorName + " " + e.getMessage());
        }
        

    }

    private void doctorOnDuty(Hospital hospital) {
        System.out.println("Please enter a doctor's name to check in as working");
        String doctorsName = scanner.next();

        Map<String, Object> doctors = hospital.getEmployees("doctors");
        if(doctors.size() == 0) {
            System.out.println("No doctors registered");
            return;
        }

        if(!doctors.containsKey(doctorsName)) {
            System.out.println("No doctor with this name found in database");
            return;
        }

        Doctor doctor = (Doctor) doctors.get(doctorsName);

        doctor.working();

        hospital.setDoctors(doctor);
    }

    private void receptionistOnDuty(Hospital hospital) {
        System.out.println("Please enter a doctor's name to check in as working");
        String receptionistsName = scanner.next();

        Map<String, Object> receptionists = hospital.getEmployees("receptionists");
        if(receptionists.size() == 0) {
            System.out.println("No doctors registered");
            return;
        }

        if(!receptionists.containsKey(receptionistsName)) {
            System.out.println("No doctor with this name found in database");
            return;
        }

        Receptionist receptionist = (Receptionist) receptionists.get(receptionistsName);

        receptionist.working();

        hospital.setReceptionists(receptionist);
    }

    private void addAnimal() {
        
    }
}
