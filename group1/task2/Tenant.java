package group1.task2;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Tenant {
    
    private Map<String, Map<String, Object>> map;
    private Scanner scanner;

    public Tenant() {
        scanner = new Scanner(System.in);
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        
        Tenant tenant = new Tenant();

        tenant.run();

      
        
        
    }

    private void run() {
        while (true) {
            String tenantName;

            System.out.println("\nTenant Management System");
            System.out.println("1. Create Tenant");
            System.out.println("2. Get Monthly Rent");
            System.out.println("3. Get First Month Rent");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            

            switch (choice) {
                case 1:
                    System.out.println("Please enter a tenant name");
                    tenantName = scanner.nextLine();
                    createTenant(tenantName);
                    break;
                case 2:
                    System.out.println("Please enter a tenant name");
                    tenantName = scanner.nextLine();
                    getMonthlyRent(tenantName);
                    break;
                case 3: 
                    System.out.println("Please enter a tenant name");
                    tenantName = scanner.nextLine();
                    getFirstMonthRent(tenantName);
                    break;
                default:
                System.out.println("Invalid choice. Please try again.");
            }
            
        }
    }


    private void createTenant(String tenantName) {
    
        if(map.containsKey(tenantName)) {
            System.out.println("Tenant with that name already exists!");
            return;
        };

        int securityDeposit;
        int monthlyRent;

        while(true) {
            System.out.println("Please select a security deposit greater than 0");
            securityDeposit = scanner.nextInt();
            if(securityDeposit >= 0) {
                break;
            };
        }

        while(true) {
            System.out.println("Please enter a monthly rent value");
            monthlyRent = scanner.nextInt();
            if(monthlyRent >= 0 ) {
                break;
            }
        }
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("securityDeposit", securityDeposit);
        innerMap.put("monthlyRent", monthlyRent);
        map.put(tenantName, innerMap);
       
        System.out.println("Tenant information has been saved");

    }

    private void getMonthlyRent(String tenantName) {

        if(!map.containsKey(tenantName)) {
            System.out.println("Invalid tenant name, unable to find user");
            return;
        }

        Object monthlyRentObject = map.get(tenantName).get("monthlyRent");
        int monthlyRentRetrieval = (int) monthlyRentObject;

        System.out.println("The tenant" + tenantName + " monthly rent is " + monthlyRentRetrieval);
        
    }

    private void getFirstMonthRent(String tenantName) {

        if(!map.containsKey(tenantName)) {
            System.out.println("Invalid tenant name, unable to find user");
            return;
        }

        Map<String, Object> tentantInformation = map.get(tenantName);
        int monthlyRent = (int) tentantInformation.get("monthlyRent");
        int securityDeposit = (int) tentantInformation.get("securityDeposit");

        int firstMonthRent = (monthlyRent * 2) + (securityDeposit);

        System.out.println("The tenant " + tenantName + " has a first month payment of " + firstMonthRent);

    }

    


   
}
