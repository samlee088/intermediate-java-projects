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
        
    }

   
}
