package group3.task6.code.Employees;

public class Employee {
    String name;
    Integer type;
    Boolean currentlyWorking;

    public Employee(String name, Integer type) {
        this.name = name;
        this.type = type;
        this.currentlyWorking = false;
    }

    public void working() {
        currentlyWorking = !currentlyWorking;
    }

    public String getEmployeeName() {
        return name;
    }
}
