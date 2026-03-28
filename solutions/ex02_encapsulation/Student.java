/*

Throw an IllegalArgumentException with a descriptive message if any validation fails
Provide getters for all fields
Provide setters for name, age, and gpa — each with validation
Override toString() to return a clean one-line summary of the student
Write a main method that creates 3 students, updates some fields, and deliberately triggers at least one exception (catch it and print the message)
You must use:

private fields
IllegalArgumentException
try-catch in main
toString() override
@Override annotation
*/

package ex02_encapsulation;

import java.util.Random;

public class Student {
    private String name; // — cannot be null or empty
    private int age; //— must be between 16 and 60
    private double gpa; //— must be between 0.0 and 4.0
    private String studentId; //— auto-generated, not settable by user

    public Student(String name, int age, double gpa) {
        this.name = name;

        if (age < 16 || age > 60) {
            throw new IllegalArgumentException("Can't be tht old");
        }

        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException();
        }

        this.age = age;

        Random rand = new Random();
        int num = rand.nextInt(100000);
        this.studentId = String.valueOf(num);
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    public double getGpa() {
        return this.gpa;
    }

    public String getStudentId() {
        return this.studentId;
    }

     public void setName(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        if (s.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = s;
    }

    public void setAge(int i) {
        if (i < 16 || i > 60) {
            throw new IllegalArgumentException();
        }
        this.age = i;

    }
    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException();
        }
        this.gpa = gpa;
    }


    @Override
    public String toString() {
        return (String) this.name;
    }

}
