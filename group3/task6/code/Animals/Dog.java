package group3.task6.code.Animals;

public class Dog extends Animal{
    
    public Dog(String name, Integer type) {
        super(name, type);
    }

    @Override
    public void specializedCare() {
        System.out.println("Dog specialized care has been initiated");
    }

    public void spayNeuter() {
        System.out.println("Dog has been spayed/neutered");
    }
}
