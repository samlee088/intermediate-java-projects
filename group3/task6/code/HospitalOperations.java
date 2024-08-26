package group3.task6.code;

import java.util.Map;
import java.util.Scanner;

import group3.task6.code.Animals.Animal;
import group3.task6.code.Animals.Cat;
import group3.task6.code.Animals.Dog;
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
                    addAnimal(hospital);
                case 6:
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
        hospital.addEmployeeWorking(doctor,"doctor");
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
        hospital.addEmployeeWorking(receptionist,"receptionist");
    
    }

    private void addAnimal(Hospital hospital) {
        String animalName = scanner.next();
        Map<String, Animal> animals = hospital.getAnimals();

        if(animals.containsKey(animalName)) {
            System.out.println("Animal already registered");
            return;
        }
        System.out.println("Please choose an animal type, 0-generic, 1-dog, 2-cat");
        Integer animalType = scanner.nextInt();
        
        while(animalType > 3 || animalType < 0) {
            System.out.println("Please choose a valid animal type");
            animalType = scanner.nextInt();
        }

        switch (animalType) {
            case 1:
                Animal animal = new Animal(animalName, animalType);
                hospital.setAnimal(animal);
            case 2:
                Dog dog = new Dog(animalName, animalType);
                hospital.setAnimal(dog);
            case 3:
                Cat cat = new Cat(animalName, animalType);
                hospital.setAnimal(cat);
            default:
                System.out.println("Unable to add animal to data base");
        }

        System.out.println("Able to add animal to data base for " + animalName);
    
    }

    private void checkInPet(Hospital hospital) {
        /* first check and see if there is a receptionist
         *  if not there must be one working
         *  check and see if animal is registered
         *      it not, it must be
         *  add animal to the queue waiting to be picked up by a doctor
         */

        Map<String, Object> receptionists = hospital.getEmployees("receptionists");
        if(receptionists.size() == 0) {
            System.out.println("There are no registered receptionists at this hospital yet");
            return;
        }

        if(hospital.getEmployeesWorking("receptionist").size() == 0) {
            System.out.println("There are no receptionists currently working to check in patient");
            return;
        }

        String animalName = scanner.next();
        
        Map <String, Animal> animals = hospital.getAnimals();

        if(!animals.containsKey(animalName)) {
            System.out.println("Unable to locate animal in database, please add in first before checking in");
            return;
        }

        hospital.checkInAnimal(animals.get(animalName));

    }
}
