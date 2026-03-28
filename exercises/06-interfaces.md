# Section 6 — Interfaces (unsure if they'll include these)

An interface is a pure contract. No fields (except constants). No constructor. All methods are implicitly `public` and `abstract` (unless `default` or `static`). A class can implement multiple interfaces — solving Java's single-inheritance limitation.

**Interface vs Abstract Class:**
- Use **abstract class** when: subclasses share real code (fields, implemented methods)
- Use **interface** when: you want to define a capability that unrelated classes can have

A `Dog` and an `Alarm` can both be `Loudable`. They share no code — just the capability.

---

## Exercise 6.1 — Printable and Saveable

**Difficulty:** Starter | **Topic:** Interfaces, implements, Multiple Interfaces

Create the following interfaces:

```java
interface Printable {
    void print();
    String getPreviewText();
}

interface Saveable {
    void save(String filename);
    void load(String filename);
    boolean isSaved();
}
```

Then create these classes that implement the interfaces:

- **Report** — implements both `Printable` and `Saveable`. Has `title`, `content`, `author`.
- **Image** — implements `Printable` only. Has `filename`, `width`, `height`.
- **Config** — implements `Saveable` only. Has a list of key-value settings (use simple String fields).

In `main`: create one of each. Call all available methods. Store `Report` and `Image` in a `Printable[]` array and loop through calling `print()`.

**You must use:**
- `interface` keyword
- `implements` keyword
- At least one class implementing two interfaces
- `Printable[]` array reference

---

## Exercise 6.2 — Smart Home Devices

**Difficulty:** Core | **Topic:** Interfaces, Multiple Inheritance via Interfaces

Build a smart home system using interfaces to define capabilities:

```java
interface Switchable    { void turnOn(); void turnOff(); boolean isOn(); }
interface Dimmable      { void setDimLevel(int percent); int getDimLevel(); }
interface Schedulable   { void setSchedule(String time); void cancelSchedule(); }
interface Controllable  { void setTemperature(int degrees); int getTemperature(); }
```

**Create these device classes:**
- **SmartLight** — implements `Switchable` and `Dimmable`
- **SmartThermostat** — implements `Switchable` and `Controllable`
- **SmartPlug** — implements `Switchable` and `Schedulable`
- **SmartLamp** — implements `Switchable`, `Dimmable`, and `Schedulable`

**In main:**
- Store all four in a `Switchable[]` array. Loop and turn them all on, then off.
- Create a `Dimmable[]` with just the dimmable devices. Loop and set them to 50%.
- Demonstrate that `SmartLamp` can be stored in `Switchable`, `Dimmable`, or `Schedulable` variables.

**You must use:**
- Four interfaces
- Classes implementing multiple interfaces
- Three different interface-typed arrays
- `instanceof` to check type before casting where needed
