# Section 5 — Abstract Classes

An abstract class cannot be instantiated. It defines a contract that subclasses must fulfill by implementing abstract methods. Use it when you want to share some code but force subclasses to provide their own implementation for specific methods.

**Abstract vs Regular class:**
```java
abstract class Vehicle {
    public abstract void startEngine(); // no body, must override
    public void refuel() { ... }        // has a body, inherited as-is
}

new Vehicle(); // COMPILE ERROR — cannot instantiate abstract class
```

---

## Exercise 5.1 — Vehicle Fleet

**Difficulty:** Core | **Topic:** Abstract Classes, abstract methods, Concrete subclasses

Build a vehicle management system using abstract classes:

```
abstract class Vehicle
|-- Car
|-- Motorcycle
|-- Truck
```

**Abstract `Vehicle` class must have:**
- `protected` fields: `make`, `model` (String), `year` (int), `fuelLevel` (double, 0–100)
- Constructor that sets all fields
- `abstract double calculateFuelEfficiency()` — km per litre
- `abstract String getVehicleType()`
- `abstract int getPassengerCapacity()`
- Non-abstract: `refuel(double amount)`, `displayInfo()`, `isLowOnFuel()` (returns true if < 20%)

**Car:** efficiency 15 km/L, capacity 5.
**Motorcycle:** efficiency 25 km/L, capacity 2.
**Truck:** has a `cargoTons` field, efficiency 8 km/L, capacity 3.

In `main`: try to write `new Vehicle()` — observe the compile error, then comment it out. Create the three subclasses and store in a `Vehicle[]` array. Loop and `displayInfo()` for each.

**You must use:**
- `abstract` keyword on class and methods
- At least 3 abstract methods
- At least 2 non-abstract methods in the base class
- `Vehicle[]` array

---

## Exercise 5.2 — Game Characters (RPG)

**Difficulty:** Advanced | **Topic:** Abstract Classes, Constructor Chains, Game Logic

Build a simple RPG character system:

```
abstract class GameCharacter
|-- Warrior
|-- Mage
|-- Archer
```

**Abstract `GameCharacter` must have:**
- `protected`: `name` (String), `health` (int), `maxHealth` (int), `level` (int), `attackPower` (int)
- `abstract int attack()` — returns damage dealt
- `abstract String getSpecialAbility()`
- `abstract void useSpecialAbility()`
- Non-abstract: `takeDamage(int damage)`, `heal(int amount)`, `isAlive()`, `levelUp()`, `displayStats()`
- `levelUp()` increases level by 1, maxHealth by 10, attackPower by 5, fully heals

**Warrior:** has a `shield` (boolean). `attack()` deals `attackPower` + random 1–10. `useSpecialAbility()` activates shield for one turn.

**Mage:** has `mana` (int). `attack()` costs 10 mana and deals double `attackPower` if mana available, else normal attack. `useSpecialAbility()` regenerates 30 mana.

**Archer:** has `arrows` (int). `attack()` uses 1 arrow, deals `attackPower + 15` if arrows > 0, else melee for half. `useSpecialAbility()` restores 10 arrows.

In `main`: create one of each, simulate a 5-round battle where each character attacks a shared enemy (start enemy at 300 health), print round-by-round results.

**You must use:**
- `abstract` class and abstract methods
- `Math.random()` for random damage
- A simple battle loop
- `isAlive()` check
