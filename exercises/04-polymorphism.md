# Section 4 — Polymorphism

Polymorphism = one interface, many behaviours. The same method call produces different results depending on the actual object type at runtime. This is the power move of OOP.

**Key concept:**
```java
Animal a = new Dog("Rex", 3);
a.makeSound(); // calls Dog's makeSound(), not Animal's
```
The variable type is `Animal`. The object type is `Dog`. Java uses the object type to decide which method to run. This is **dynamic dispatch**.

---

## Exercise 4.1 — Shape Calculator

**Difficulty:** Core | **Topic:** Polymorphism, Method Overriding, Base Class Reference

Build a shape system from scratch:

```
Shape (base class)
|-- Circle
|-- Rectangle
|-- Triangle
```

**Shape base class:**
- `protected String color`
- `calculateArea()` returns double (return 0 in base, override in all children)
- `calculatePerimeter()` returns double
- `displayInfo()` — prints color, area, perimeter. Calls the above two methods.

Each subclass stores its own dimensions and overrides both calculation methods.

**In main:**
- Create a `Shape[]` array with one of each shape
- Loop through the array and call `displayInfo()` on each
- Find and print the shape with the largest area (loop again)
- Calculate and print the total perimeter of all shapes combined

**You must use:**
- `Shape[]` array
- `@Override` on both methods
- Calling methods through `Shape` reference
- A loop that calls `displayInfo()` without knowing the concrete type

---

## Exercise 4.2 — Notification System

**Difficulty:** Core | **Topic:** Polymorphism, Real-world Design

Build a notification system:

```
Notification (base)
|-- EmailNotification
|-- SMSNotification
|-- PushNotification
```

**Notification base class:**
- `protected String recipient`, `String message`, `String timestamp`
- `send()` — prints a generic send message
- `getType()` — returns String (override in each subclass)
- `formatMessage()` — returns String (override in each subclass with different formatting)

**EmailNotification** adds: `String subject`, `String senderEmail`. Its `formatMessage()` returns a properly formatted email string.

**SMSNotification** adds: `String phoneNumber`. Its `formatMessage()` truncates message to 160 chars.

**PushNotification** adds: `String appName`, `String deviceId`. Its `formatMessage()` is short and snappy.

In `main`: create a `Notification[]` with all three types. Loop through and call `send()` on each, demonstrating that the correct version fires.
