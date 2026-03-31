# 05 -- Interfaces

## The core idea

An interface is a pure contract. It says: any class that implements me must provide these methods. It does not say how -- just that the methods must exist and be accessible.

An interface has no instance state and no constructor. It is not a class. It is a specification of behaviour.

---

## Why interfaces exist

Java only allows a class to extend one other class. But in real systems, an object often needs to fulfil multiple roles. A `Duck` is an `Animal`, but it is also `Flyable` and `Swimmable`. A `SmartPhone` is a `Device`, but it is also `Camera`, `MusicPlayer`, and `Navigator`.

Interfaces solve this by letting a class commit to multiple contracts simultaneously.

---

## Interface declaration

```java
interface Printable {
    void print();               // implicitly public abstract
    String getPreviewText();    // implicitly public abstract
}

interface Saveable {
    void save(String filename);
    boolean isSaved();
}
```

Every method in an interface is implicitly `public` and `abstract` -- you do not need to write these keywords (though you can).

Interfaces cannot have:
- Instance fields (only `public static final` constants)
- Constructors
- Regular non-static, non-default methods with bodies (before Java 8)

---

## Implementing an interface

```java
class Report implements Printable, Saveable {
    private String title;
    private String content;
    private boolean saved = false;

    // Must implement ALL methods from Printable
    @Override
    public void print() {
        System.out.println("=== " + title + " ===");
        System.out.println(content);
    }

    @Override
    public String getPreviewText() {
        return content.substring(0, Math.min(100, content.length()));
    }

    // Must implement ALL methods from Saveable
    @Override
    public void save(String filename) {
        System.out.println("Saving to: " + filename);
        saved = true;
    }

    @Override
    public boolean isSaved() {
        return saved;
    }
}
```

If you implement an interface but miss one of its methods, the code will not compile. The contract is enforced.

---

## Polymorphism through interfaces

Just like with classes, you can store objects in interface-typed variables:

```java
Printable p = new Report();   // upcasting to interface type
p.print();                    // calls Report's print()
p.save("file.txt");           // COMPILE ERROR -- save() is not in Printable

Saveable s = new Report();    // same Report object, different reference type
s.save("file.txt");           // works
```

This is how you write code that works with any class implementing the interface, regardless of the specific type.

---

## Default methods (Java 8+)

An interface can have methods with a body using the `default` keyword. Implementing classes inherit this automatically and can override it if needed.

```java
interface Describable {
    String getName();
    String getCategory();

    default void describe() {
        System.out.println(getName() + " [" + getCategory() + "]");
        // default implementation using other interface methods
    }
}
```

Why this exists: before Java 8, adding a new method to an interface would break every class that implemented it. `default` methods allow interfaces to evolve without breaking existing implementations.

---

## Interface vs Abstract class -- the full comparison

| | Interface | Abstract Class |
|--|-----------|---------------|
| Instance fields | No (only constants) | Yes |
| Constructor | No | Yes |
| Method bodies | Only `default`/`static` | Yes (any method) |
| Extend/implement | `implements` (many) | `extends` (one only) |
| Access modifiers on methods | Always `public` | Any modifier |
| When to use | Define a capability for unrelated classes | Share code between related classes |

---

## Choosing between them

Use an **abstract class** when:
- The classes are closely related (they share a common identity)
- You want to share actual code (fields, implemented methods) between subclasses
- Example: `Animal` with shared `name`, `age`, `eat()` behaviour

Use an **interface** when:
- The classes may be completely unrelated but share a capability
- You need a class to fulfil multiple roles
- Example: `Flyable` -- an `Eagle` and an `Airplane` can both fly, but they share no code

---

## Interface as a type

One of the most important uses of interfaces: they let you write code that accepts **anything implementing the interface**, regardless of class hierarchy.

```java
public void printAll(List<Printable> items) {
    for (Printable p : items) {
        p.print();  // works for any class implementing Printable
    }
}
```

A `Report`, an `Image`, and a `Receipt` are completely unrelated classes. But if they all implement `Printable`, they can all go into this list and be printed with the same code.

---

## Concept questions -- answer in full sentences

**Q1.** What is an interface? How is it fundamentally different from a class?

**Q2.** Why does Java have interfaces if it already has abstract classes? What problem do interfaces solve that abstract classes cannot?

**Q3.** What does it mean to "implement" an interface? What obligation does a class take on when it does?

**Q4.** What happens if a class claims to implement an interface but does not provide all the required methods?

**Q5.** Can a class implement multiple interfaces? Can a class extend multiple classes? Explain the difference and why Java is designed this way.

**Q6.** Explain what "programming to an interface" means and why it is considered good design practice.

**Q7.** What are `default` methods in an interface? Why were they added to Java? What problem do they solve?

**Q8.** Why can an interface not have instance fields? What can it have instead?

**Q9.** You have two classes -- `Bird` and `Aeroplane` -- that are completely unrelated in your class hierarchy. Both need a `fly()` method. How do you design this and why is an interface the right tool here rather than a shared parent class?

**Q10.** What is the difference between an interface and an abstract class when it comes to constructors?

**Q11.** If `Printable p = new Report()`, why can you not call `p.save()` even if `Report` implements both `Printable` and `Saveable`?

**Q12.** How do interfaces contribute to polymorphism?
