import ex03_inheritance.Animal;
import ex03_inheritance.Dog;
import ex03_inheritance.Cat;
import ex03_inheritance.Bird;
import ex03_inheritance.Parrot;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

@DisplayName("Exercise 3.1 — Animal Kingdom")
class AnimalTest {

    // ── Inheritance structure ─────────────────────────────────────────────────

    @Test @DisplayName("Dog is an instance of Animal")
    void dogIsAnimal() {
        assertInstanceOf(Animal.class, new Dog("Rex", 3));
    }

    @Test @DisplayName("Cat is an instance of Animal")
    void catIsAnimal() {
        assertInstanceOf(Animal.class, new Cat("Whiskers", 5));
    }

    @Test @DisplayName("Bird is an instance of Animal")
    void birdIsAnimal() {
        assertInstanceOf(Animal.class, new Bird("Tweety", 2));
    }

    @Test @DisplayName("Parrot is an instance of both Bird and Animal")
    void parrotIsBirdAndAnimal() {
        Parrot p = new Parrot("Polly", 4, "Pretty bird!");
        assertInstanceOf(Bird.class,   p);
        assertInstanceOf(Animal.class, p);
    }

    // ── Parrot phrase ─────────────────────────────────────────────────────────

    @Test @DisplayName("Parrot.makeSound() prints its phrase")
    void parrotPrintsPhrase() {
        String out = capture(() -> new Parrot("Polly", 4, "Pretty bird!").makeSound());
        assertTrue(out.contains("Pretty bird!"),
            "Parrot.makeSound() should print its phrase — got: " + out);
    }

    @Test @DisplayName("Parrot uses whatever phrase it was constructed with")
    void parrotCustomPhrase() {
        String out = capture(() -> new Parrot("Rio", 2, "Hello mate!").makeSound());
        assertTrue(out.contains("Hello mate!"),
            "Parrot should use its own phrase — got: " + out);
    }

    // ── Distinct sounds ───────────────────────────────────────────────────────

    @Test @DisplayName("Dog and Cat produce different sounds")
    void differentSounds() {
        String dog = capture(() -> new Dog("Rex", 3).makeSound());
        String cat = capture(() -> new Cat("Luna", 2).makeSound());
        assertNotEquals(dog, cat, "Dog and Cat should override makeSound() differently");
    }

    // ── Polymorphism ──────────────────────────────────────────────────────────

    @Test @DisplayName("makeSound() via Animal reference calls the subclass version")
    void polymorphicMakeSound() {
        Dog realDog = new Dog("Rex", 3);
        String direct    = capture(realDog::makeSound);
        String viaAnimal = capture(((Animal) realDog)::makeSound);
        assertEquals(direct, viaAnimal,
            "Calling makeSound() through Animal reference should call Dog's overridden version");
    }

    @Test @DisplayName("Animal[] can hold mixed types and call makeSound() on each")
    void animalArrayPolymorphism() {
        Animal[] animals = {
            new Dog("Rex", 3),
            new Cat("Mochi", 1),
            new Parrot("Rio", 2, "Squawk!")
        };
        for (Animal a : animals) {
            String out = capture(a::makeSound);
            assertFalse(out.isBlank(),
                a.getClass().getSimpleName() + ".makeSound() should print something");
        }
    }

    // ── Helper ────────────────────────────────────────────────────────────────

    private String capture(Runnable r) {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(buf));
        try { r.run(); } finally { System.setOut(old); }
        return buf.toString().trim();
    }
}
