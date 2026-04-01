# 08 -- Access Modifiers

## The four levels

Java has four access levels, controlling where a field, method, or class can be accessed from.

| Modifier | Same class | Same package | Subclass (any package) | Anywhere |
|----------|-----------|--------------|----------------------|---------|
| `private` | yes | no | no | no |
| (default / package-private) | yes | yes | no | no |
| `protected` | yes | yes | yes | no |
| `public` | yes | yes | yes | yes |

---

## private

Only the class that declares it can access it. Not even subclasses.

```java
class BankAccount {
    private double balance;  // only BankAccount methods can touch this

    public void deposit(double amount) {
        balance += amount;  // fine -- same class
    }
}

class SavingsAccount extends BankAccount {
    public void addInterest() {
        balance += balance * 0.05;  // COMPILE ERROR -- balance is private to BankAccount
        // Use a getter instead: getBalance()
    }
}
```

Use `private` for all fields by default. This is the most restrictive and most protective option.

---

## protected

The class, its subclasses (anywhere), and classes in the same package.

```java
class Animal {
    protected String name;  // accessible to all Animal subclasses
    protected int age;
}

class Dog extends Animal {
    public void describe() {
        System.out.println(name + " is " + age + " years old.");
        // fine -- Dog is a subclass of Animal
    }
}
```

Use `protected` when a subclass genuinely needs direct access to the field. In practice, even in inheritance hierarchies, many developers prefer `private` fields with `protected` getters/setters, keeping control centralised.

---

## public

Accessible from anywhere.

Use `public` for:
- Methods that form the class's public interface (getters, service methods)
- Constants (`public static final`)
- Class declarations that need to be used outside their package

Never use `public` for instance fields (use `private` with a getter instead).

---

## Default (package-private)

No keyword. Only accessible within the same package. Not accessible from subclasses in other packages.

```java
class Helper {
    void doSomething() { }  // package-private -- no modifier
}
```

Rarely used deliberately. It is a common mistake to forget a modifier and accidentally get package-private when you meant `public`.

---

## Access modifiers on classes

A top-level class can only be `public` or package-private (default). It cannot be `private` or `protected`.

- `public class MyClass` -- accessible from anywhere
- `class MyClass` (no modifier) -- only accessible within the same package

---

## Common patterns and rules

```java
// Fields: always private
private String name;
private double balance;

// Methods forming the public interface: public
public void deposit(double amount) { ... }
public double getBalance() { return balance; }

// Internal helper methods: private
private void validateAmount(double amount) { ... }

// Fields needed by subclasses: private with protected getter
private String name;
protected String getName() { return name; }

// Alternatively: protected field (less controlled)
protected String name;
```

---

## Why this matters for OOP

Access modifiers are the enforcement mechanism for encapsulation. Without them, encapsulation is just a convention. With them, the compiler physically prevents code from accessing what it should not.

When you make a field `private`, you are not just saying "please don't access this directly." You are making it impossible.

---

## Concept questions -- answer in full sentences

**Q1.** What are the four access modifiers in Java? Rank them from most restrictive to least restrictive.

**Q2.** What is the difference between `private` and `protected`? Give a concrete example where this distinction matters.

**Q3.** Why should instance fields almost always be `private` rather than `public`?

**Q4.** A subclass is in a different package from its parent. Which members of the parent can it still access?

**Q5.** What is package-private access? When would you intentionally use it?

**Q6.** Can a top-level class be declared `private`? Why or why not?

**Q7.** What is the relationship between access modifiers and encapsulation? How do they work together?

**Q8.** You have a parent class with a `private` field. The subclass needs to read this field. What are the two ways to handle this correctly?

**Q9.** A method is declared with no access modifier. What level of access does it have? Is this usually intentional or a mistake?

**Q10.** Why is it wrong to use `protected` for all fields in a class hierarchy "just to make things easier for subclasses"?
