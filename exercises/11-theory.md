# Section 11 — Low-Level vs High-Level Languages

This section is theory. No coding. Answer these in a notes file or just think them through.

---

## Exercise 11.1 — Language Theory Questions

**Difficulty:** Core | **Topic:** Low/High Level, Compilation, JVM

Answer each of the following. Keep answers concise but complete:

1. What is a low-level language? Give 2 examples.
2. What is a high-level language? Give 3 examples.
3. What is the difference between compiled and interpreted languages? Which is Java?
4. What is bytecode and why does Java use it?
5. What is the JVM? What problem does it solve?
6. What does "write once, run anywhere" mean in the context of Java?
7. What is the difference between the JDK and the JRE?
8. Why is C considered closer to hardware than Java?
9. What is garbage collection and why do high-level languages have it?
10. Name one advantage and one disadvantage of high-level languages compared to low-level.

---

**Java's execution model — know this:**

```
Source code (.java)
        |
   javac (Java Compiler)
        |
  Bytecode (.class)      ← platform independent
        |
  JVM (Java Virtual Machine)  ← platform specific
        |
  Machine code (runs on your OS)
```
