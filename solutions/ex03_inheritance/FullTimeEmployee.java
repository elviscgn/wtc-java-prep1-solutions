package ex03_inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String name, String employeeId, String department, double salary) {
        this.salary = salary;
        super(name, employeeId, department);
    }

    @Override
    public double calculatePay() {
        return this.salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public static void main(String[] args) {
         FullTimeEmployee e = new FullTimeEmployee("Alice", "E001", "Engineering", 50_000.0);
        System.out.println("aaa" + e.getSalary());
        assertEquals(50_000.0, e.calculatePay(), 0.001);
    }


}
