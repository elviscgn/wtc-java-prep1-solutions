# Section 3 — Inheritance

Inheritance lets a child class reuse and extend a parent class. Key Java specifics: `extends` keyword, `super()` constructor call, method overriding with `@Override`.

---

## Exercise 3.1 — Animal Kingdom

**Difficulty:** Starter | **Topic:** Inheritance, super, Method Overriding

Create a single file `Animals.java` containing all classes below (or separate files, your choice). Build this hierarchy:

```
Animal
|-- Dog
|-- Cat
|-- Bird
    |-- Parrot
```

**Animal class must have:**
- `protected String name`
- `protected int age`
- Constructor: `Animal(String name, int age)`
- `makeSound()` — prints a generic sound
- `describe()` — prints name, age, and calls `makeSound()`
- `toString()` override

**Each subclass must:**
- Call `super()` in its constructor
- Override `makeSound()` with a specific sound
- Add at least one unique field and one unique method

**Parrot (extends Bird) must:**
- Have a `String phrase` field
- Override `makeSound()` to print the phrase

**You must use:**
- `extends`
- `super()` constructor call
- `@Override`
- `protected` fields (accessed in subclasses)

**Expected output (example):**
```
Name: Rex | Age: 3 | Type: Dog
Rex says: Woof!
Name: Polly | Age: 2 | Type: Parrot
Polly says: Pretty bird! Pretty bird!
```

---

## Exercise 3.2 — Employee Payroll System

**Difficulty:** Core | **Topic:** Inheritance, super methods, Method Overriding

Build a payroll system. Create these classes:

```
Employee (base)
|-- FullTimeEmployee
|-- PartTimeEmployee
|-- Contractor
```

**Employee base class:**
- `private String name`, `String employeeId`, `String department`
- `calculatePay()` — returns double (base version returns 0, meant to be overridden)
- `printPaySlip()` — prints a formatted pay slip, calls `calculatePay()` internally
- `toString()` override

**FullTimeEmployee:** has a monthly salary (double). `calculatePay()` returns the salary.

**PartTimeEmployee:** has `hoursWorked` (double) and `hourlyRate` (double). `calculatePay()` returns hours × rate.

**Contractor:** has `dailyRate` (double) and `daysWorked` (int). `calculatePay()` returns daily × days. Also has a `String company` field.

In `main`: create one of each, print all pay slips, then store all three in an `Employee[]` array and loop through printing pay for each.

**You must use:**
- `extends`
- `@Override`
- `super()` constructor
- `Employee[]` array containing all three types
- Calling `calculatePay()` through the base type reference

> **Hint:** When you store a `FullTimeEmployee` in an `Employee` variable and call `calculatePay()`, Java calls the overridden version. That is polymorphism — and it's what the next section is about.
