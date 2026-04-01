# 06 -- Composition vs Inheritance

## The core question

When you want to build a new class using an existing class, you have two options:

- **Inheritance (IS-A):** Make the new class a subclass. It becomes a specialised version of the existing class.
- **Composition (HAS-A):** Give the new class a field that holds an instance of the existing class. It uses it as a component.

Choosing the wrong one leads to code that is brittle, confusing, or hard to change.

---

## IS-A vs HAS-A

**IS-A (inheritance):**
A `Dog` IS an `Animal`. A `SavingsAccount` IS a `BankAccount`. A `Manager` IS an `Employee`.

The subclass is a specialised version of the parent. It passes the IS-A test.

**HAS-A (composition):**
A `Car` HAS an `Engine`. A `Library` HAS `Books`. A `University` HAS `Departments`.

The class contains another object as a component. One thing is made up of another.

---

## When inheritance goes wrong

The temptation: "I need a stack. ArrayList already manages a list. Let me extend it."

```java
// Looks convenient -- but it is wrong
class Stack extends ArrayList<Object> {
    public void push(Object item) { add(item); }
    public Object pop() { return remove(size() - 1); }
}
```

The problem: `Stack` inherits **all** of `ArrayList`'s methods. Users of your `Stack` can now call:

```java
stack.add(0, item);   // inserts at position 0 -- violates stack order
stack.get(5);         // random access -- stacks do not work this way
stack.remove(3);      // removes from middle -- completely wrong
stack.clear();        // also wrong in many contexts
```

A `Stack` is not a list. It just uses a list internally. The IS-A test fails. A `Stack` IS NOT an `ArrayList` -- it only needs one.

**The correct design using composition:**

```java
class Stack {
    private ArrayList<Object> items = new ArrayList<>(); // hidden internal tool

    public void push(Object item) { items.add(item); }
    public Object pop() { return items.remove(items.size() - 1); }
    public Object peek() { return items.get(items.size() - 1); }
    public boolean isEmpty() { return items.isEmpty(); }
    // Nothing else is exposed -- the contract is clean
}
```

Now `Stack` only exposes what a stack should expose. The internal `ArrayList` is an implementation detail.

---

## The IS-A test

Before using inheritance, ask: "Is X truly a Y in all situations?"

- Is a `Dog` an `Animal`? Yes, always. Use inheritance.
- Is a `Stack` an `ArrayList`? No -- a stack is a restricted data structure. Use composition.
- Is a `Manager` an `Employee`? Yes -- a manager is a specialised employee. Use inheritance.
- Is a `Car` an `Engine`? No -- a car uses an engine. Use composition.
- Is a `Square` a `Rectangle`? Feels like yes -- but mathematically, you cannot resize a square's width without also changing its height, which violates `Rectangle`'s contract. This is a famous case where the IS-A test misleads you.

---

## Why "favour composition over inheritance"

Inheritance creates **tight coupling**. The subclass depends on the internals of the parent. When the parent changes, the subclass may break -- even if you did not touch the subclass. This is called the **fragile base class problem**.

Composition is **looser**. The class interacts with the component through its public interface. You can change the component's implementation without touching the class using it. You can also swap out the component entirely.

Composition also works around the single-inheritance limitation. A class can have multiple composed objects of different types.

---

## They are not always opposites

You can use both together. A `Manager` can extend `Employee` (inheritance -- IS-A) and also have a `Department` field (composition -- HAS-A).

```java
class Manager extends Employee {       // IS-A Employee
    private Department department;     // HAS-A Department
    private List<Employee> team;       // HAS-A list of Employees

    public Manager(String name, Department department) {
        super(name);
        this.department = department;
        this.team = new ArrayList<>();
    }
}
```

---

## Concept questions -- answer in full sentences

**Q1.** What is the difference between inheritance and composition? Describe both in terms of the relationship they model.

**Q2.** What is the IS-A test? Give two examples of where it passes and two where it fails.

**Q3.** Why is `class Stack extends ArrayList` considered bad design? What specific problems does it cause?

**Q4.** What is the "fragile base class problem"? How does composition help avoid it?

**Q5.** A developer says: "I always use inheritance because it means I write less code." What is the flaw in this reasoning?

**Q6.** Is it ever correct to use both inheritance and composition in the same class? Describe a realistic example.

**Q7.** The `Square extends Rectangle` example is a famous case where the IS-A test misleads you. Explain what goes wrong.

**Q8.** How does composition give you more flexibility than inheritance when requirements change?

**Q9.** What does "tight coupling" mean in the context of inheritance? Why is tight coupling undesirable?

**Q10.** You are building a `Logger` class. You need it to write to files, and you already have a `FileWriter` class. Should `Logger` extend `FileWriter` or contain one? Justify your answer.
