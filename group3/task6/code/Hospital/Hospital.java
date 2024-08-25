package group3.task6.code.Hospital;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import group3.task6.code.Employees.Doctor;
import group3.task6.code.Employees.Receptionist;

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

    public Map<String, Object> getEmployees(String role) {
        return getEmployees().get(role);
    }

    public int getReceptionistsCount() {
        return getEmployees().get("receptionists").size();
    }

    public int getDoctorsCount() {
        return getEmployees().get("doctors").size();
    }

    public void setReceptionists(Receptionist receptionist) {
        getEmployees("receptionists").put(receptionist.getEmployeeName(), receptionist);
    }
    public void setDoctors(Doctor doctor) {
        getEmployees("doctors").put(doctor.getEmployeeName(), doctor);
    }
}
