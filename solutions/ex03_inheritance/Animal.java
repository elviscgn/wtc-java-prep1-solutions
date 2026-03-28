package ex03_inheritance;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("?");
    }

    public void describe() {
        System.out.println("Name: " + name + "Age: " + age);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}
