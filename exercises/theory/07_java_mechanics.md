# 07 -- Java Mechanics

## Constructors

A constructor initialises a new object. It runs once, when the object is created. It has the same name as the class and no return type.

```java
class Car {
    private String make;
    private int year;

    // Constructor
    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }
}

Car c = new Car("Toyota", 2022);  // constructor runs here
```

**Default constructor:** If you write no constructor at all, Java provides a no-argument default constructor for free. The moment you write any constructor yourself, the default disappears. If you then try to call `new Car()` with no arguments, it is a compile error.

**Constructor overloading:** You can have multiple constructors with different parameter lists.

**Constructor chaining with `this()`:** One constructor can call another in the same class using `this(...)`. It must be the first statement.

```java
class Circle {
    private double radius;
    private String color;

    public Circle() {
        this(1.0, "black");  // calls the full constructor -- must be first line
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
}
```

---

## Static vs instance

**Instance members** belong to an object. Each object has its own copy.

**Static members** belong to the class. All objects share one copy. Static members exist before any object is created.

```java
class Counter {
    private static int total = 0;  // shared by all Counter objects
    private int id;                // unique per object

    public Counter() {
        total++;
        this.id = total;
    }

    public static int getTotal() { return total; }  // called on the class
    public int getId() { return id; }               // called on an instance
}

Counter a = new Counter();
Counter b = new Counter();
Counter.getTotal();  // 2 -- static, called on class name
a.getId();           // 1 -- instance, belongs to a
b.getId();           // 2 -- instance, belongs to b
```

**A static method cannot access instance fields or use `this`** -- it has no object context. If you try, you get a compile error.

---

## The `final` keyword

`final` means "this cannot be changed after it is set."

| Where | Effect |
|-------|--------|
| `final` on a class | Cannot be extended. No subclasses allowed. |
| `final` on a method | Cannot be overridden in subclasses. |
| `final` on a variable | Cannot be reassigned after first assignment. Must be set in declaration or constructor. |

```java
final class ImmutablePoint {    // no subclasses allowed
    private final double x;     // cannot be reassigned
    private final double y;

    public ImmutablePoint(double x, double y) {
        this.x = x;  // only place this can be assigned
        this.y = y;
    }

    public final double distanceTo(ImmutablePoint other) {  // cannot be overridden
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}
```

**Important distinction:** A `final` variable means the **reference** cannot change -- but if the object it points to is mutable, the object itself can still be modified.

```java
final List<String> names = new ArrayList<>();
names = new ArrayList<>();  // compile error -- reference cannot change
names.add("Alice");         // fine -- the object itself can be modified
```

---

## The Object class

Every class in Java implicitly extends `Object`. This means every object has these methods available by default:

- `toString()` -- string representation of the object
- `equals(Object obj)` -- whether two objects are "equal"
- `hashCode()` -- integer hash (must be overridden if `equals` is overridden)
- `getClass()` -- returns the class of the object at runtime

**toString():**

The default `toString()` returns something like `Dog@1f6a7b9` -- the class name and a memory-based hash. Useless for debugging. Override it:

```java
@Override
public String toString() {
    return "Dog{name=" + name + ", breed=" + breed + "}";
}
// Now System.out.println(dog) gives you readable output
```

**equals():**

The default `equals()` checks reference equality -- the same as `==`. Two separate objects with identical content are not equal by default. Override it to define what "equal" means for your class:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;                  // same reference
    if (!(obj instanceof Student)) return false;   // different type
    Student other = (Student) obj;
    return this.studentId.equals(other.studentId); // equal if same ID
}
```

**== vs .equals() for Strings:**

`==` checks if two variables point to the exact same object in memory.
`.equals()` checks if two objects have the same content.

```java
String a = new String("hello");
String b = new String("hello");

a == b         // false -- different objects in memory
a.equals(b)   // true -- same content
```

Always use `.equals()` for comparing Strings and objects.

---

## Concept questions -- answer in full sentences

**Q1.** What is a constructor? How does it differ from a regular method?

**Q2.** What is the default constructor? When does Java provide it automatically, and when does it disappear?

**Q3.** What does `this()` do inside a constructor? What constraint must it follow?

**Q4.** What does `static` mean when applied to a field? How is it different from a regular instance field?

**Q5.** Why can a static method not access instance fields? What is the fundamental reason?

**Q6.** What does `final` mean on a variable? Is a `final` variable the same as an immutable object? Explain the difference.

**Q7.** What does `final` on a class mean? Why would you make a class final?

**Q8.** Every Java class implicitly extends `Object`. What does this mean practically? Name three methods your class inherits from `Object`.

**Q9.** Why is the default `toString()` method considered unhelpful? What does the default output look like, and what should you return instead?

**Q10.** Explain the difference between `==` and `.equals()` for objects. Why is `==` almost always wrong for comparing Strings?

**Q11.** What is the relationship between `equals()` and `hashCode()`? Why must you override both together?

**Q12.** A student writes a class with only a parameterised constructor and then tries to create an object with `new MyClass()`. What happens and why?
