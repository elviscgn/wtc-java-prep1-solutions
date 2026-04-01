# 01 -- Encapsulation

## The core idea

Encapsulation means an object owns its data and controls how it is accessed or changed. The outside world cannot reach in and manipulate the internal state directly -- it must go through the methods the class provides.

Think of a vending machine. You cannot reach inside and grab a snack. You interact through a defined interface: insert money, press a button, collect your item. The machine controls what happens internally.

---

## Why it matters

Without encapsulation, your objects have no integrity. Any piece of code anywhere can put them into an illegal state:

```java
// No encapsulation -- fragile
class Patient {
    public int age;
    public double temperature;
}

patient.age = -5;          // physically impossible, nothing stops it
patient.temperature = 900; // dangerous nonsense, nothing stops it
```

With encapsulation, the class enforces its own rules:

```java
// Encapsulated -- self-defending
class Patient {
    private int age;
    private double temperature;

    public void setAge(int age) {
        if (age < 0 || age > 150)
            throw new IllegalArgumentException("Invalid age: " + age);
        this.age = age;
    }

    public void setTemperature(double temp) {
        if (temp < 30.0 || temp > 45.0)
            throw new IllegalArgumentException("Unrealistic temperature: " + temp);
        this.temperature = temp;
    }
}
```

Now the object is self-defending. It is impossible to create a `Patient` with age -5 without an exception being thrown.

---

## The standard pattern

```java
class Employee {
    // 1. Fields are private
    private String name;
    private double salary;
    private String employeeId;  // auto-generated, should never change

    // 2. Constructor sets initial state
    public Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);  // reuse setter validation even in constructor
        this.employeeId = generateId();
    }

    // 3. Getters provide read access
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getEmployeeId() { return employeeId; }

    // 4. Setters provide controlled write access
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.name = name;
    }

    public void setSalary(double salary) {
        if (salary < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");
        this.salary = salary;
    }

    // 5. No setter for employeeId -- it must never change after creation
}
```

---

## What not every field needs a setter

Ask: should this value be changeable after the object is created?

- `employeeId` -- no, it is permanent. Getter only.
- `name` -- yes, people change names. Getter and setter.
- `salary` -- yes, salaries change. Getter and setter with validation.
- `accountBalance` -- this is special: it should not be directly settable at all. Only specific business methods (`deposit`, `withdraw`) should change it. No setter whatsoever.

---

## The `this` keyword

`this` refers to the current instance. It is used when a parameter name shadows a field:

```java
public void setName(String name) {
    this.name = name;  // this.name is the field, name is the parameter
}
```

Without `this.name = name`, you would write `name = name` which assigns the parameter to itself. The field never changes. This is a silent bug.

---

## Concept questions -- answer in full sentences

**Q1.** A classmate says: "Encapsulation just means making fields private." Is this complete? What is missing from that definition?

**Q2.** Explain the difference between a getter and a setter. Are both always needed for every field? Justify your answer with an example.

**Q3.** Why is encapsulation described as making objects "self-defending"?

**Q4.** You have a `BankAccount` class. The balance field has no setter. How should the balance ever change then? What does this tell you about encapsulation and business logic?

**Q5.** What is the `this` keyword and when is it necessary? Give a scenario where forgetting it causes a silent bug.

**Q6.** Describe a real-world system (not a bank account) where encapsulation is critical. Explain what could go wrong without it.

**Q7.** Is it possible to have encapsulation without using the `private` keyword? Explain.

**Q8.** What is the difference between an object's **state** and its **behaviour**? How does encapsulation relate to both?

**Q9.** A getter returns a `List<String>` field directly. Why can this break encapsulation even though the field is private?

**Q10.** Why do we say the constructor is part of encapsulation, not separate from it?
