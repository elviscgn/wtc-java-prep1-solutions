# Section 7 — Composition

Composition = building complex objects by combining simpler ones. "Has-a" relationship instead of "is-a". A `Car` has an `Engine`. A `Library` has `Books`. Prefer composition over inheritance when the relationship is not truly a parent-child type.

---

## Exercise 7.1 — Computer Builder

**Difficulty:** Core | **Topic:** Composition, Has-a Relationship

Build a computer system using composition. Every class is its own file (or inner class — your choice).

**Create these component classes:**
- **CPU:** `brand` (String), `cores` (int), `clockSpeedGHz` (double), `getInfo()`
- **RAM:** `sizeGB` (int), `type` (String e.g. DDR4), `speedMHz` (int), `getInfo()`
- **Storage:** `type` (SSD or HDD), `capacityGB` (int), `readSpeedMBps` (int), `getInfo()`
- **GPU:** `brand` (String), `vramGB` (int), `getInfo()` — optional for some computers

**Then create a `Computer` class:**
- Has a `CPU`, `RAM`, `Storage`, and an optional `GPU` (can be null)
- Constructor takes all components
- `displaySpecs()` — calls `getInfo()` on each component and prints everything neatly
- `isGamingReady()` — returns true if has GPU, RAM >= 16GB, and storage is SSD
- `getTotalCost()` — each component has a price field, return sum

In `main`: build two computers (one gaming, one basic), display specs for both, print whether each is gaming ready.

**You must use:**
- Composition (objects as fields)
- `null` check for optional GPU
- Calling methods on composed objects

---

## Exercise 7.2 — University System

**Difficulty:** Advanced | **Topic:** Composition, Collections, Real Design

Build a university management system using composition and `ArrayList`:

```
University
  has many --> Department
                 has many --> Course
                                has many --> Student
                 has many --> Professor
```

**Student class:** `studentId`, `name`, `gpa`, `ArrayList<String> enrolledCourses`

**Professor class:** `name`, `department`, `ArrayList<String> coursesTaught`, `addCourse()`, `getCourses()`

**Course class:** `courseCode`, `courseName`, `Professor instructor`, `ArrayList<Student> students`, `enroll(Student s)`, `getAverageGpa()`

**Department class:** `name`, `ArrayList<Course> courses`, `ArrayList<Professor> professors`, `addCourse()`, `addProfessor()`, `getDepartmentReport()`

**University class:** `name`, `ArrayList<Department> departments`, `addDepartment()`, `findCourse(String code)`, `getTotalStudentCount()`, `printUniversityReport()`

In `main`: build a mini university with 2 departments, 2 courses each, 2 professors, and at least 5 students spread across courses. Print the full university report.

**You must use:**
- `ArrayList<T>`
- Composition at every level
- Methods that delegate to composed objects
- At least one method that searches through nested lists