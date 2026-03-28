# Java OOP Cheatsheet

Keep this open while you code.

---

## Access Modifiers

| Modifier    | Same class | Same package | Subclass | World |
|-------------|------------|--------------|----------|-------|
| `private`   | YES         | NO           | NO       | NO    |
| *(default)* | YES         | YES           | NO       | NO    |
| `protected` | YES         | YES           | YES       | NO    |
| `public`    | YES         | YES           | YES       | YES    |

---

## Key Keywords

| Keyword          | What it does |
|------------------|--------------|
| `extends`        | Inherit from a parent class. `class Dog extends Animal` |
| `implements`     | Fulfil an interface contract. `class Dog implements Runnable` |
| `abstract`       | Cannot instantiate this class / method has no body |
| `interface`      | Pure contract — all methods abstract by default |
| `super()`        | Call the parent constructor — **must be first line** |
| `super.method()` | Call the parent version of an overridden method |
| `@Override`      | Annotation — tells compiler you intend to override |
| `instanceof`     | Check type at runtime: `if (a instanceof Dog)` |
| `this`           | Reference to current object instance |
| `static`         | Belongs to class, not instance. Shared across all objects |
| `final`          | Cannot override (method), cannot extend (class), cannot reassign (variable) |

---

## Abstract Class vs Interface — Quick Decision

| | Abstract Class | Interface |
|---|---|---|
| Can have fields? | YES Yes | NO No (only constants) |
| Can have constructors? | YES Yes | NO No |
| Can have implemented methods? | YES Yes | YES Only `default`/`static` |
| Multiple inheritance? | NO One only | YES Many interfaces |
| Use when... | Sharing real code among related classes | Defining a capability for unrelated classes |

---

## Common Mistakes Coming from Python

| Python | Java |
|--------|------|
| Indentation defines blocks | Use `{ }` always |
| No semicolons | Every statement ends with `;` |
| `x = 5` | `int x = 5;` — types are explicit |
| `x == y` for strings | `x.equals(y)` for String comparison |
| Lists are dynamic | Arrays are fixed. Use `ArrayList<T>` for dynamic |
| Multiple inheritance | Only one `extends` — use interfaces for multiple |
| `super().__init__()` anywhere | `super()` must be the **FIRST** line in constructor |
| Abstract method has `pass` | Abstract method has **NO body**, not even `{}` |
| N/A | An interface cannot have instance fields |
| `@override` doesn't exist | `@Override` doesn't make the override happen — signature must match exactly |

---

## ArrayList Quick Reference

```java
import java.util.ArrayList;

ArrayList<String> list = new ArrayList<>();
list.add("hello");
list.get(0);          // "hello"
list.size();          // 1
list.remove(0);       // removes first element
list.contains("hi");  // false

// Enhanced for loop
for (String s : list) {
    System.out.println(s);
}
```

---

## Casting & instanceof

```java
Animal a = new Dog("Rex", 3);

// Check before casting
if (a instanceof Dog) {
    Dog d = (Dog) a;   // safe cast
    d.fetch();         // Dog-specific method
}
```

---

## Maven Cheatsheet

```
mvn compile          → compile src/main/java
mvn test             → run src/test/java tests
mvn package          → build JAR into target/
mvn clean            → delete target/
mvn clean install    → clean + build + install to ~/.m2
mvn dependency:tree  → list all dependencies
```

**pom.xml structure:**
```xml
<project>
  <groupId>com.example</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0</version>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

---

## Git Cheatsheet

```bash
git init                        # new repo
git clone <url>                 # copy remote repo
git add .                       # stage all changes
git commit -m "message"         # save snapshot
git status                      # what's changed?
git log --oneline               # compact history
git diff                        # unstaged changes
git diff HEAD~1 HEAD            # last commit vs current
git branch <name>               # create branch
git checkout <name>             # switch branch
git checkout -b <name>          # create + switch
git merge <branch>              # merge into current
git stash                       # save changes temporarily
git stash pop                   # restore stashed changes
git push origin main            # push to remote
git pull                        # pull from remote
```

---