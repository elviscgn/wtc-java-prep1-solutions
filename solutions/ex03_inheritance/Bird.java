package ex03_inheritance;

public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        // TODO Auto-generated method stub
        System.out.println("chirp");
    }
}
