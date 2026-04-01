# 09 -- Design Thinking Questions

These are open-ended questions. There is no single right answer. What matters is your reasoning -- can you apply OOP principles to justify a design decision?

Write at least 3-4 sentences per answer. Think out loud.

---

## Design questions

**Q1.** You are designing a system for a zoo. You have Lions, Dolphins, and Parrots. Some animals can be trained, some can be exhibited to the public, and some can do both. How would you structure this using OOP? Explain which tools (abstract class, interface, inheritance, composition) you would use and why.

---

**Q2.** A developer is building a payment system. They create a class `Payment` and then extend it into `CreditCardPayment`, `DebitCardPayment`, and `CashPayment`. Later the team needs to add `CryptoPayment`. What are the advantages of this design? What would need to change when adding the new type?

---

**Q3.** You have a `Rectangle` class with `width`, `height`, `getArea()`, and `setWidth()`. A teammate suggests creating `Square extends Rectangle` since a square is a special rectangle. Argue for and against this decision from an OOP perspective.

---

**Q4.** Describe the single responsibility principle in your own words (one class, one job). Now describe how violating it might look in a Java class, and what problems that creates.

---

**Q5.** You are building a `Logger` class that writes log messages to a file. You already have a `FileWriter` class. A teammate says to extend `FileWriter`. Another says to use composition. Who is right and why?

---

**Q6.** What is the "open/closed principle"? (A class should be open for extension but closed for modification.) Give an example of a design that follows it and one that violates it.

---

**Q7.** You have an abstract class `Vehicle` with subclasses `Car`, `Truck`, and `Motorcycle`. Now you want to add electric versions of each: `ElectricCar`, `ElectricTruck`, `ElectricMotorcycle`. How would you structure this? What problems could arise if you just keep extending?

---

**Q8.** A class has 15 methods and fields covering user authentication, database saving, email sending, and report generation. What principle does this violate? What would you do to fix it and what are the benefits?

---

**Q9.** You are asked to design a `Notification` system that can send notifications via Email, SMS, and Push. New notification types will be added in the future. Design it using OOP so that adding a new type requires minimal changes. Explain your reasoning.

---

**Q10.** What does "loose coupling" mean? How do interfaces contribute to loose coupling? Give a real example of tightly coupled code and explain how interfaces would improve it.
