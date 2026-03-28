# Section 9 — Build Tools (Maven)

You will not write Java here. These are written exercises about what Maven does and how to use it. Answer in comments in a Java file, or just think through each one.

---

## Exercise 9.1 — Maven Concepts

**Difficulty:** Core | **Topic:** Build Tools, pom.xml, Maven Lifecycle

Create a file called `MavenNotes.java` with a `main` method that does nothing. In the file, answer each of the following **in a comment** above the `main` method:

1. What is Maven and why does it exist? (3 sentences max)
2. What is a `pom.xml` file? Name 5 things it can contain.
3. What are the 3 main Maven build lifecycle phases in order? What does each one do?
4. What command do you run to compile a Maven project?
5. What command do you run to run tests?
6. What command do you run to package the project into a JAR?
7. What is a Maven dependency? Give an example of what one looks like in XML.
8. What is the difference between `src/main/java` and `src/test/java`?
9. What does `mvn clean` do and why would you use it?

**Key Maven commands to memorise:**
```
mvn compile          → compiles source code
mvn test             → runs tests
mvn package          → creates JAR/WAR
mvn clean            → deletes target/ folder
mvn clean install    → clean then build and install to local repo
mvn dependency:tree  → shows all dependencies
```
