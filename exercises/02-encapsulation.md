# Section 2 — Encapsulation

Encapsulation = hiding internal state behind methods. Private fields. Controlled access. Validation in setters. This is the foundation of OOP.

---

## Exercise 2.1 — Bank Account

**Difficulty:** Starter | **Topic:** Encapsulation, Access Modifiers, Constructors

Create `BankAccount.java` with a `BankAccount` class and a `main` method in the same file.

**The class must have:**
- `private String accountHolder`
- `private String accountNumber` (auto-generated, user cannot set it directly)
- `private double balance` (never goes below 0)

**Methods:**
- Constructor: `BankAccount(String accountHolder, double initialBalance)`
- `deposit(double amount)` — validates amount is positive
- `withdraw(double amount)` — validates funds available, prints message if not
- `getBalance()` — returns double
- `getAccountHolder()` — returns String
- `getAccountNumber()` — returns String
- `printStatement()` — prints all account details neatly

**You must use:**
- `private` fields
- `public` getters
- NO setter for `balance` (only `deposit`/`withdraw` can change it)
- NO setter for `accountNumber`
- Validation logic inside methods

> **Hint:** For account number generation: use a static counter or just concatenate `"ACC"` with a number. `static int counter = 1000;` then `accountNumber = "ACC" + counter++;`

**Expected output (example):**
```
Account: ACC1000 | Holder: Alice | Balance: R500.00
Depositing R200.00...
Account: ACC1000 | Holder: Alice | Balance: R700.00
Withdrawing R900.00... Insufficient funds.
Account: ACC1000 | Holder: Alice | Balance: R700.00
```

---

## Exercise 2.2 — Student Record

**Difficulty:** Core | **Topic:** Encapsulation, Validation, toString

Create `Student.java`. The `Student` class must represent a university student. This exercise focuses on tight validation.

**Fields (all private):**
- `String name` — cannot be null or empty
- `int age` — must be between 16 and 60
- `double gpa` — must be between 0.0 and 4.0
- `String studentId` — auto-generated, not settable by user

**Requirements:**
- Throw an `IllegalArgumentException` with a descriptive message if any validation fails
- Provide getters for all fields
- Provide setters for `name`, `age`, and `gpa` — each with validation
- Override `toString()` to return a clean one-line summary of the student
- Write a `main` method that creates 3 students, updates some fields, and deliberately triggers at least one exception (catch it and print the message)

**You must use:**
- `private` fields
- `IllegalArgumentException`
- `try-catch` in main
- `toString()` override
- `@Override` annotation
