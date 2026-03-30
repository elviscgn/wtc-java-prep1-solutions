package ex03_inheritance;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String name, String employeeId, String department) {
        super(name, employeeId, department);
    }

    @Override
    public double calculatePay() {
        return this.salary;
    }

    
}
