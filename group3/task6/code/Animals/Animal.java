package group3.task6.code.Animals;

public class Animal {
    String name;
    Integer type;

    public Animal(String name, Integer type) {
        this.name = name;
        this.type = type;
    }
    public void routineVisit() {
        System.out.println("Patient has finished routine visit");
        return;
    }

    public String getName() {
        return name;
    }

    public void specializedCare() {
        System.out.println("Patient has finished specialized care");
        return;
    }

    public void addAnimalTag() {
        System.out.println("Patient has finished adding animal tag");
        return;
    }
}
