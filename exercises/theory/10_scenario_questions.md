# 10 -- Scenario Questions

For each scenario: will this compile? If not, why? If yes, what is the output or what happens at runtime? Explain your reasoning -- do not just say "error" or "it works."

Answers are in `11_answers.md`. Do not look until you have written your answer.

---

## Scenario A

```java
abstract class Shape {
    public abstract double getArea();
    public void describe() {
        System.out.println("Area: " + getArea());
    }
}

class Triangle extends Shape {
    private double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double getArea() {
        return 0.5 * base * height;
    }
}

Shape s = new Triangle(10, 5);
s.describe();
```

What is the output? Explain why `describe()` in `Shape` is able to call `getArea()` even though `Shape` does not implement it.

---

## Scenario B

```java
abstract class Animal {
    public abstract void makeSound();
}

class Dog extends Animal { }
```

Does this compile? What must you do to fix it?

---

## Scenario C

```java
class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        System.out.println("C");
    }
}

new C();
```

What is the output? In what order and why?

---

## Scenario D

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Duck flies"); }
    public void swim() { System.out.println("Duck swims"); }
}

Flyable f = new Duck();
f.fly();
f.swim();
```

Does this compile? If not, why? If it does, what is the output?

---

## Scenario E

```java
class Animal {
    public void speak() {
        System.out.println("...");
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("Woof");
    }
    public void fetch() {
        System.out.println("Fetching!");
    }
}

Animal a = new Dog();
a.speak();
a.fetch();
```

What happens on each line? What is the output? What is the error if there is one?

---

## Scenario F

```java
class Vehicle {
    private String make;
    public Vehicle(String make) {
        this.make = make;
    }
}

class Car extends Vehicle {
    private int doors;
    public Car(String make, int doors) {
        this.doors = doors;
        super(make);
    }
}
```

Does this compile? What is wrong?

---

## Scenario G

```java
class Animal {
    protected String name;
    public Animal(String name) { this.name = name; }
    public void makeSound() { System.out.println("..."); }
}

class Dog extends Animal {
    public Dog(String name) { super(name); }
    @Override
    public void makeSound() { System.out.println(name + " says Woof!"); }
}

class Cat extends Animal {
    public Cat(String name) { super(name); }
    @Override
    public void makeSound() { System.out.println(name + " says Meow!"); }
}

Animal[] animals = { new Dog("Rex"), new Cat("Luna"), new Dog("Buddy") };
for (Animal a : animals) {
    a.makeSound();
}
```

What is the output? Which concept does this demonstrate?

---

## Scenario H

```java
Animal a = new Dog("Rex");
Dog d = (Dog) a;
Cat c = (Cat) a;
```

Line 1: What happens?
Line 2: What happens?
Line 3: Does it compile? Does it run? What happens?

---

## Scenario I

```java
class Person {
    private String name;
    public Person(String name) { this.name = name; }
}

Person p1 = new Person("Alice");
Person p2 = new Person("Alice");

System.out.println(p1 == p2);
System.out.println(p1.equals(p2));
```

What does each `println` print? Why?

---

## Scenario J

```java
class Counter {
    private static int count = 0;
    private int id;

    public Counter() {
        count++;
        id = count;
    }

    public static int getCount() { return count; }
    public int getId() { return id; }
}

Counter x = new Counter();
Counter y = new Counter();
Counter z = new Counter();

System.out.println(Counter.getCount());
System.out.println(x.getId());
System.out.println(z.getId());
```

What does each `println` print? Explain why.

---

## Scenario K

```java
interface Printable {
    void print();
    default void preview() {
        System.out.println("Preview not available.");
    }
}

class Report implements Printable {
    @Override
    public void print() { System.out.println("Printing report..."); }
    @Override
    public void preview() { System.out.println("Report preview here."); }
}

class Invoice implements Printable {
    @Override
    public void print() { System.out.println("Printing invoice..."); }
    // does NOT override preview()
}

Printable r = new Report();
Printable i = new Invoice();
r.preview();
i.preview();
```

What is the output? Explain why the two calls produce different results.

---

## Scenario L

```java
class Animal {
    public void makeSound() { System.out.println("Generic sound"); }
}

class Dog extends Animal {
    public void makeSound() { System.out.println("Woof"); }  // no @Override
}

Dog d = new Dog();
d.makeSound();
```

Does this compile? Does it run? What is the output? What is the role of `@Override` here?
