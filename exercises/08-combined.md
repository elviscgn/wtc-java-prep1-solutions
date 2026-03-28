# Section 8 — Combining Everything

These exercises require you to use all OOP concepts together. This is closest to what assessment questions look like.

---

## Exercise 8.1 — Zoo Management System

**Difficulty:** Advanced | **Topic:** Full OOP — All Concepts

Design and build a zoo management system from scratch. This is an open-ended design exercise — make your own reasonable choices, but you must satisfy these requirements:

**Interfaces to create:**
- `Feedable` — `feed(String foodType)`, `getHungerLevel()`
- `Trainable` — `train(String command)`, `getTrainedCommands()`
- `Exhibitable` — `getExhibitName()`, `getViewingHours()`

**Abstract class to create:**
- `abstract Animal`: `name`, `species`, `age`, `weight`, `isEndangered`
- Abstract methods: `makeSound()`, `getAnimalType()`, `getDietType()`
- Non-abstract: `describe()`, `sleep()`, `eat()`

**Concrete animal classes** (each extends `Animal` and implements some interfaces):
- **Lion** — implements `Feedable` and `Exhibitable`
- **Dolphin** — implements `Feedable`, `Trainable`, and `Exhibitable`
- **Elephant** — implements `Feedable`, `Trainable`, and `Exhibitable`
- **Snake** — implements `Feedable` and `Exhibitable` only

**ZooKeeper class** (use composition):
- `name`, `ArrayList<Animal> assignedAnimals`
- `feedAll()`, `trainAll()` — loops and calls the methods only if the animal implements the interface (use `instanceof`)
- `addAnimal(Animal a)`, `getReport()`

**Zoo class** (use composition):
- `name`, `ArrayList<ZooKeeper> keepers`, `ArrayList<Animal> allAnimals`
- `addKeeper()`, `addAnimal()`, `assignAnimalToKeeper()`
- `getDailyReport()` — prints full zoo status

**You must use:**
- `abstract` class
- At least 3 interfaces
- Composition at `Zoo` and `ZooKeeper` level
- `instanceof` checks
- `ArrayList`
- `@Override`
- Polymorphism via `Animal[]` or `Animal` reference

---

## Exercise 8.2 — Robot Command System ⭐

**Difficulty:** Advanced | **Topic:** Full OOP — Mirrors Your Curriculum Exactly

This is your curriculum's Robot exercise, rebuilt from scratch. **Do not refer to your course materials** — build it from memory and your own understanding.

**Build these classes:**

**`abstract class Command`:**
- `private String name`, `String argument`
- Constructor: `Command(String name)` and `Command(String name, String argument)`
- `getName()`, `getArgument()` getters
- `abstract boolean execute(Robot target)`
- `static Command create(String input)` — parses `"forward 10"` into a `ForwardCommand`

**`class Robot`:**
- `private String name`, `int x`, `int y` (position), `String status`, `boolean running`
- Constructor: `Robot(String name)` — starts at 0,0
- `handleCommand(Command c)` — calls `c.execute(this)`
- `updatePosition(int steps)` — moves forward (increase y), returns false if would go out of bounds (-200 to 200)
- `setStatus(String s)`, `getStatus()`, `getPosition()` (returns formatted string), `getName()`
- `shutdown()`

**Concrete command classes:**
- **ForwardCommand** — moves robot forward
- **BackCommand** — moves robot backward (decrease y)
- **ShutdownCommand** — shuts down the robot
- **HelpCommand** — sets a help message as status
- **TurnCommand** — has direction (left/right), updates a direction field on robot

In `main`: create a robot, send it at least 8 different commands using `Command.create()`, print its status after each one. Try to move it out of bounds.

**You must use:**
- `abstract` class and abstract method
- Static factory method (`Command.create()`)
- Polymorphism — `handleCommand` takes `Command`, not a specific subclass
- All 5 command types
