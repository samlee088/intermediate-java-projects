package group3.task6.code.Employees;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Employee {
    private List<String> patient;
    public Doctor(String name, Integer type) {
        super(name, type);
        patient = new ArrayList();
    }

    public void receiveAnimal() {}

    public void treatAnimal(){}

    public void completeVisit(){}

    public Integer getPatients() {
        return patient.size();
    }

    public void addPatient(String patient) {
        this.patient.add(patient);
    }

    public String getCurrentPatient() {
        return patient.get(0); 
    }

    public void removePatient() {
        patient.remove(0);
    }
}
