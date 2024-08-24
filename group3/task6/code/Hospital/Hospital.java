package group3.task6.code.Hospital;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Hospital {
    String name;
    Map<String, Map<String, Object>> employees;
    Map<String, Object> patients;
    Queue <String> checkInQueue;
    Queue<String> checkOutQueue;


    public Hospital(String name) {
        this.name = name;
        employees = new HashMap<String, Map<String, Object>>();
        Map<String, Object> receptionists = new HashMap<String, Object>();
        Map<String, Object> doctors = new HashMap<String, Object>();
        employees.put("receptionists", receptionists);
        employees.put("doctors", doctors);
        checkInQueue = new LinkedList<String>();
        checkOutQueue = new LinkedList<String>();

    }

    public Map<String, Map<String, Object>> getEmployees() {
        return employees;
    }

    public int getReceptionists() {
        return getEmployees().get("receptionists").size();
    }

    public int getDoctors() {
        return getEmployees().get("doctors").size();
    }
}
