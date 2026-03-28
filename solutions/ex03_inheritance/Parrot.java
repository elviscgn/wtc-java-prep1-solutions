package ex03_inheritance;

public class Parrot extends Bird {

    private String phrase;

    public Parrot(String name,  int age, String phrase) {
        super(name, age);
        this.phrase = phrase;
    }

    @Override
    public void makeSound() {
         System.out.print(name + " says:" + phrase);
     }
}
