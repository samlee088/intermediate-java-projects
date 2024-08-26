package group3.task6.code.Animals;

public class Cat extends Animal{

    public Cat(String name, Integer type) {
        super(name, type);
    }

    @Override
    public void specializedCare() {
        System.out.println("Cat specialized care has been initiated");
    }

    public void spayNeuter() {
        System.out.println("Cat has been spayed/neutered");
    }

    
}
